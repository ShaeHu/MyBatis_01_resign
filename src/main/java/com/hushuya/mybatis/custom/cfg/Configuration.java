package com.hushuya.mybatis.custom.cfg;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private String Driver;
    private String Url;
    private String Username;
    private String Password;

    private Map<String,Mapper> mappers = new HashMap<String, Mapper>();

    public void setMappers(Map<String, Mapper> mappers){
        this.mappers.putAll(mappers);
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
