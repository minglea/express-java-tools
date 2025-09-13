package club.mrxiao.sf.bean.order;

import lombok.Data;

/**
 * 收件人信息
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 */
@Data
public class OrderContactInfoDto {

    /**
     * 收件人姓名
     */
    private String contactName;

    /**
     * 收件人电话
     */
    private String contactPhone;

    /**
     * 收件人手机
     */
    private String contactMobile;

    /**
     * 收件省
     */
    private String province;

    /**
     * 收件市
     */
    private String city;

    /**
     * 收件区/县
     */
    private String district;

    /**
     * 收件详细地址
     */
    private String address;

    /**
     * 收件人公司名
     */
    private String company;

    /**
     * 收件人邮编
     */
    private String postCode;
}