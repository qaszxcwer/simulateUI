package personal.simulateui.bean;

/**
 * 作者：qaszxcwer
 * 日期：2020/7/22
 */
public class RegionBean {
    /**
     * 省份拼音首字母
     */
    private String regionCode;

    /**
     * 省份名称
     */
    private String regionsName;

    public RegionBean(String regionCode, String regionsName) {
        this.regionCode = regionCode;
        this.regionsName = regionsName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionsName() {
        return regionsName;
    }

    public void setRegionsName(String regionsName) {
        this.regionsName = regionsName;
    }
}
