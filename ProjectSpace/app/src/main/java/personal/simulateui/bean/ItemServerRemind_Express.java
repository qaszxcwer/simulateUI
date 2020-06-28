package personal.simulateui.bean;

/**
 * 作者：qaszxcwer，日期：2020/5/27
 * 服务：我的快递
 */
public class ItemServerRemind_Express extends ItemServerRemind {
    /**
     * 物流状态
     */
    private String status;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 快递单号
     */
    private String expressNo;

    public ItemServerRemind_Express(int type, String name, String time, String status, String goodsName, String expressNo) {
        super(type, name, time);
        this.status = status;
        this.goodsName = goodsName;
        this.expressNo = expressNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }
}
