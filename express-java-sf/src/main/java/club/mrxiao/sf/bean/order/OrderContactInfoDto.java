package club.mrxiao.sf.bean.order;

import lombok.Data;

/**
 * 订单联系人信息更新 DTO
 * 对应接口元素：<请求> OrderUpdate/OrderContactInfoDto
 * @author wushaojie
 */
@Data
public class OrderContactInfoDto {

    /**
     * 公司名称
     * 类型：String(100)
     * 必填：条件
     */
    private String company;

    /**
     * 联系人
     * 类型：String(100)
     * 必填：条件
     */
    private String contact;

    /**
     * 收方电话
     * 类型：String(20)
     * 必填：条件
     */
    private String tel;

    /**
     * 收方手机
     * 类型：String(20)
     * 必填：否
     */
    private String mobile;

    /**
     * 国家或地区（2位代码，参照附录国家代码）
     * 类型：String(30)
     * 必填：是
     */
    private String country;

    /**
     * 省级行政区名称，如：北京、广东省、广西壮族自治区等
     * 类型：String(30)
     * 必填：否
     */
    private String province;

    /**
     * 地级市名称，必须是标准城市称谓，如：北京市、深圳市、大理白族自治州等
     * 类型：String(100)
     * 必填：否
     */
    private String city;

    /**
     * 县/区级名称，必须是标准称谓，如：福田区
     * 类型：String(30)
     * 必填：否
     */
    private String county;

    /**
     * 详细地址
     * 类型：String(200)
     * 必填：条件（若 province/city 未传，则地址中必须包含省市信息）
     */
    private String address;
}