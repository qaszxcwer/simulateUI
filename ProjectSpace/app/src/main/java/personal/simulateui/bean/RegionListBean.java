package personal.simulateui.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：qaszxcwer
 * 日期：2020/7/22
 */
public class RegionListBean {
    private String regionCode;

    private List<String> regionList = new ArrayList<>();

    public RegionListBean(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public List<String> getRegionList() {
        return regionList;
    }

    public void addRegion(String regionName) {
        regionList.add(regionName);
    }
}
