package com.grosr.api.config;

/**
 * Created by grosr on 3/26/17.
 */
public enum AllowedURL {
    API("api.grosr.com"),
    VENDOR("vendor.grosr.com"),
    GROSR("grosr.com"),
    ADMIN("admin.grosr.com");

    private AllowedURL(String url){
        this.url = url;
    }
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
