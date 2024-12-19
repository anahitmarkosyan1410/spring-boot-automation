package com.automation.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigManager {

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${username}")
    private String userName;

    @Value("${password}")
    private String password;

    @Value("${rest.assured.base-uri}")
    private String restBaseURI;

    @Value("${rest.assured.port}")
    private int restPort;

    @Value("${rest.assured.base-path}")
    private String restBasePath;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRestBaseURI() {
        return restBaseURI;
    }

    public int getRestPort() {
        return restPort;
    }

    public String getRestBasePath() {
        return restBasePath;
    }

    public void setRestBaseURI(String restBaseURI) {
        this.restBaseURI = restBaseURI;
    }

    public void setRestBasePath(String restBasePath) {
        this.restBasePath = restBasePath;
    }
}
