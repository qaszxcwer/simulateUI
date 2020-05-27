package personal.simulateui.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 作者：qaszxcwer，日期：2020/5/27
 */
public class ItemServerRemind implements MultiItemEntity {
    @Override
    public int getItemType() {
        return type;
    }
    /**
     * 服务类型
     */
    private int type;
    /**
     * 服务名称
     */
    private String name;
    /**
     * 服务时间
     */
    private String time;

    public ItemServerRemind(int type, String name, String time) {
        this.type = type;
        this.name = name;
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
