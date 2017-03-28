package com.grosr.api.config;

/**
 * Created by grosr on 3/26/17.
 */
public enum Constants {
    ADMIN(new Long(1));

    private Constants(Long id){
        this.id = id;
    }
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
