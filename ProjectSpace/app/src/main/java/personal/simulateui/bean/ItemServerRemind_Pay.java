package personal.simulateui.bean;

/**
 * 作者：qaszxcwer，日期：2020/5/27
 * 服务：支付助手
 */
public class ItemServerRemind_Pay extends ItemServerRemind {
    /**
     * 付款金额
     */
    private String money;
    /**
     * 付款地点
     */
    private String address;

    public ItemServerRemind_Pay(int type, String name, String time, String money, String address) {
        super(type, name, time);
        this.money = money;
        this.address = address;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
