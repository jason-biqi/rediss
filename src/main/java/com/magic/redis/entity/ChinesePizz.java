package com.magic.redis.entity;

/**
 * @author jiaosong
 * @version V1.0
 * @ClassName:ChinesePizz
 * @Description: TODO
 * @Date 10:50
 */
public class ChinesePizz implements Pizz {

    private String name;
    private Integer price;




    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void perpare() {
        System.err.println(name+"准备");
    }

    @Override
    public void bake() {
        System.err.println(name+"制作");
    }

    @Override
    public void box() {
        System.err.println(name+"打包");
    }
}
