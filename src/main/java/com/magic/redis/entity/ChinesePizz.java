package com.magic.redis.entity;

import java.io.Serializable;

/**
 * @author jiaosong
 * @version V1.0
 * @ClassName:ChinesePizz
 * @Description: TODO
 * @Date 10:50
 */
public class ChinesePizz implements Pizz , Serializable ,Cloneable {

    private String name;
    private Integer price;
    private Letter letter;

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    /**
     * @Author chengpunan
     * @Description //TODO
     * @Date 13:31 2019/12/12
     * @Param [name]
     * @return void
     **/
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
