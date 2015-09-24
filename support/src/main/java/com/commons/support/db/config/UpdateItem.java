package com.commons.support.db.config;

/**
 * Created by qianjin on 2015/9/24.
 */
public class UpdateItem {

    private Long id;
    private String key;
    private String value;
    private Integer update_key;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getUpdate_key() {
        return update_key;
    }

    public void setUpdate_key(Integer update_key) {
        this.update_key = update_key;
    }
}
