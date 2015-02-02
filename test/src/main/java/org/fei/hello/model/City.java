package org.fei.hello.model;


public class City {

    private long id;
    private long cityCode;
    private String cityName;
    private String shortName;
    private int status;
    private String cityUrl;
    private String weatherUrl;
    private int cityOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCityCode() {
        return cityCode;
    }

    public void setCityCode(long cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCityUrl() {
        return cityUrl;
    }

    public void setCityUrl(String cityUrl) {
        this.cityUrl = cityUrl;
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public int getCityOrder() {
        return cityOrder;
    }

    public void setCityOrder(int cityOrder) {
        this.cityOrder = cityOrder;
    }

    public String toString() {
        return "id: "+id+" cityCode: "+cityCode+" cityName: "+cityName;
    }


}
