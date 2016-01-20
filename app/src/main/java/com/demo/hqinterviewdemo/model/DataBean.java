package com.demo.hqinterviewdemo.model;

import java.io.Serializable;

/**
 * Created by shivang on 19/1/16.
 */
public class DataBean implements Serializable{

    private String url = "";
    private String filePath = "";
    private String namespace = "";
    private Boolean cache = false;
    private String key = "";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Boolean getCache() {
        return cache;
    }

    public void setCache(Boolean cache) {
        this.cache = cache;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
