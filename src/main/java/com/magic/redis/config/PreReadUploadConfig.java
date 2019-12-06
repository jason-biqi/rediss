package com.magic.redis.config;

import org.springframework.stereotype.Component;

@Component
public class PreReadUploadConfig {


    private String uploadPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }


}
