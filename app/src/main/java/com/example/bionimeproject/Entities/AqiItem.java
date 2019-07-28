package com.example.bionimeproject.Entities;

import com.google.gson.annotations.SerializedName;

/**
 * 空汙指標
 * */
public class AqiItem {
    private String SiteName;
    private String County;
    private String AQI;
    private String Pollutant;
    private String Status;
    private String SO2;
    private String CO;
    private String CO_8hr;
    private String O3;
    private String O3_8h;
    private String PM10;
    @SerializedName("PM2.5")
    private String PM25;
    private String NO2;
    private String NOx;
    private String NO;
    private String WindSpeed;
    private String WindDirec;
    private String PublishTime;
    @SerializedName("PM2.5_AVG")
    private String PM25_AVG;
    private String PM10_AVG;
    private String SO2_AVG;
    private String Longitude;
    private String Latitude;
    private String SiteId;


    public AqiItem() {
    }

    public AqiItem(String SiteName, String County, String AQI, String Pollutant, String Status, String SO2, String CO, String CO_8hr, String O3, String O3_8h, String PM10, String PM25, String NO2, String NOx, String NO, String WindSpeed, String WindDirec, String PublishTime, String PM25_AVG, String PM10_AVG, String SO2_AVG, String Longitude, String Latitude, String SiteId) {
        this.SiteName = SiteName;
        this.County = County;
        this.AQI = AQI;
        this.Pollutant = Pollutant;
        this.Status = Status;
        this.SO2 = SO2;
        this.CO = CO;
        this.CO_8hr = CO_8hr;
        this.O3 = O3;
        this.O3_8h = O3_8h;
        this.PM10 = PM10;
        this.PM25 = PM25;
        this.NO2 = NO2;
        this.NOx = NOx;
        this.NO = NO;
        this.WindSpeed = WindSpeed;
        this.WindDirec = WindDirec;
        this.PublishTime = PublishTime;
        this.PM25_AVG = PM25_AVG;
        this.PM10_AVG = PM10_AVG;
        this.SO2_AVG = SO2_AVG;
        this.Longitude = Longitude;
        this.Latitude = Latitude;
        this.SiteId = SiteId;


    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public void setCountry(String country) {
        County = country;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getAQI() {
        return AQI;
    }

    public String getCountry() {
        return County;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setCO(String CO) {
        this.CO = CO;
    }

    public void setCO_8hr(String CO_8hr) {
        this.CO_8hr = CO_8hr;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public void setNO2(String NO2) {
        this.NO2 = NO2;
    }

    public void setNOx(String NOx) {
        this.NOx = NOx;
    }

    public void setO3(String o3) {
        O3 = o3;
    }

    public void setO3_8h(String o3_8h) {
        O3_8h = o3_8h;
    }

    public void setPM10(String PM10) {
        this.PM10 = PM10;
    }

    public void setPM25(String PM25) {
        this.PM25 = PM25;
    }

    public void setPM25_AVG(String PM25_AVG) {
        this.PM25_AVG = PM25_AVG;
    }

    public void setPollutant(String pollutant) {
        Pollutant = pollutant;
    }

    public void setPM10_AVG(String PM10_AVG) {
        this.PM10_AVG = PM10_AVG;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public void setSO2(String SO2) {
        this.SO2 = SO2;
    }

    public void setPublishTime(String publishTime) {
        PublishTime = publishTime;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setWindDirec(String windDirec) {
        WindDirec = windDirec;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public void setSO2_AVG(String SO2_AVG) {
        this.SO2_AVG = SO2_AVG;
    }

    public void setWindSpeed(String windSpeed) {
        WindSpeed = windSpeed;
    }

    public void setSiteId(String siteId) {
        SiteId = siteId;
    }

    public String getCO() {
        return CO;
    }

    public String getCO_8hr() {
        return CO_8hr;
    }

    public String getNO() {
        return NO;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getNO2() {
        return NO2;
    }

    public String getO3() {
        return O3;
    }

    public String getNOx() {
        return NOx;
    }

    public String getO3_8h() {
        return O3_8h;
    }

    public String getPollutant() {
        return Pollutant;
    }

    public String getStatus() {
        return Status;
    }

    public String getSO2() {
        return SO2;
    }

    public String getPM10() {
        return PM10;
    }

    public String getPM25() {
        return PM25;
    }

    public String getWindSpeed() {
        return WindSpeed;
    }

    public String getWindDirec() {
        return WindDirec;
    }

    public String getPublishTime() {
        return PublishTime;
    }

    public String getPM25_AVG() {
        return PM25_AVG;
    }

    public String getPM10_AVG() {
        return PM10_AVG;
    }

    public String getSO2_AVG() {
        return SO2_AVG;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getSiteId() {
        return SiteId;
    }
}
