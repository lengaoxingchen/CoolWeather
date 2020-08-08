package cn.testrunner.coolweather.db;

import org.litepal.crud.DataSupport;

public class Country extends DataSupport {

    /*
    主键Id
     */
    private int id;

    /*
    县级名称
     */
    private String countryName;

    /*
    天气Id
     */
    private int weatherId;

    /*
    当前县所属市的id
     */
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
