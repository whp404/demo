package com.imooc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="girl")
public class GirlProperties {
    private  String name;
    private  String height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "GirlProperties{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
