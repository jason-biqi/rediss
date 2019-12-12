package com.magic.redis.service;

import com.magic.redis.entity.Pizz;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaosong
 * @version V1.0
 * @ClassName:CreateContre
 * @Description: TODO
 * @Date 10:59
 */
public class CreateContre {

    private static Map<String,Pizz> map=new HashMap<>();

    private CreatPizz creatPizz;

    public void setCreatPizz(CreatPizz creatPizz) {
        this.creatPizz = creatPizz;
    }

    public Pizz out(String name){
        Pizz pizz = map.get(name);
        if (pizz==null){
            map.put(name,creatPizz.myCreatPizz(name));
            return map.get(name);
        }

        return pizz;
    }
}
