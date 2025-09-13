package club.mrxiao.sf.api.impl;

import club.mrxiao.common.error.ExpressErrorException;
import club.mrxiao.sf.api.SfService;
import club.mrxiao.sf.bean.order.*;
import club.mrxiao.sf.bean.print.PrintSfOrderResponse;
import club.mrxiao.sf.test.ApiTestModule;
import club.mrxiao.sf.util.json.SfGsonBuilder;
import cn.hutool.core.util.IdUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Guice(modules = ApiTestModule.class)
public class SfOrderServiceImplTest {

    private final Log log = LogFactory.get(this.getClass().getName());

    @Inject
    private SfService sfService;

    @Test
    public void createOrder() throws ExpressErrorException {

        ContactInfo sender = new ContactInfo();
        sender.setContactType(1);
        sender.setContact("**");
        sender.setTel("17737235204");
        sender.setCountry("CN");
        sender.setProvince("北京市");
        sender.setCity("朝阳区");
        sender.setCounty("朝阳区");
        sender.setAddress("西坝河北里***********");

        ContactInfo receiver = new ContactInfo();
        receiver.setContactType(2);
        receiver.setContact("**");
        receiver.setTel("17737235204");
        receiver.setCountry("CN");
        receiver.setProvince("北京市");
        receiver.setCity("朝阳区");
        receiver.setCounty("朝阳区");
        receiver.setAddress("西坝河中里***********");

        List<ContactInfo> contactInfoList = new ArrayList<>();
        contactInfoList.add(sender);
        contactInfoList.add(receiver);


        CargoDetail cargoDetail = new CargoDetail();
        cargoDetail.setName("文件");
        cargoDetail.setCount(1);

        List<CargoDetail> cargoDetails = new ArrayList<>();
        cargoDetails.add(cargoDetail);

        CreateOrderRequest request = CreateOrderRequest.builder()
                .language("zh-CN")
                .orderId(IdUtil.simpleUUID())
                .payMethod(2)
                .remark("测试订单")
                .contactInfoList(contactInfoList)
                .cargoDetails(cargoDetails)
                .sendStartTm(new Date())
                .build();

        CreateOrderResponse response = sfService.getSfOrderService().createOrder(request);

        log.info("【response】:\n {}", SfGsonBuilder.create().toJson(response));

    }


    @Test
    public void orderResp() throws ExpressErrorException {
        OrderRespRequest request = OrderRespRequest.builder()
                .language("zh-CN")
                .orderId("bef1af64721e47df961d3b795f320523")
                .build();
        OrderRespResponse response = sfService.getSfOrderService().orderResp(request);
        log.info("【response】:\n {}", SfGsonBuilder.create().toJson(response));
    }

    @Test
    public void updateOrder() throws ExpressErrorException {
        UpdateOrderRequest request = UpdateOrderRequest.builder()
                .orderId("655f2e6ab9234b5ea327cf06e23642e6")
                .dealType(2)
                .build();
        UpdateOrderResponse response = sfService.getSfOrderService().updateOrder(request);
        log.info("【response】:\n {}", SfGsonBuilder.create().toJson(response));
    }


    @Test
    public void getPrintData() throws ExpressErrorException {
        OrderRespRequest request = OrderRespRequest.builder()
                .language("zh-CN")
                .orderId("bef1af64721e47df961d3b795f320523")
                .build();
        PrintSfOrderResponse response = this.sfService.getSfOrderService().getPrintData(request);
        log.info("【response】:\n {}", SfGsonBuilder.create().toJson(response));
    }
}
