package com.magic.redis.service;

import com.magic.redis.entity.ChinesePizz;
import com.magic.redis.entity.Pizz;

/**
 * @author jiaosong
 * @version V1.0
 * @ClassName:ChineseCtreat
 * @Description: TODO
 * @Date 10:55
 */
public class ChineseCtreat implements CreatPizz {
    @Override
    public Pizz myCreatPizz(String name) {

        if (name.equals("ChinesePizz")){
            ChinesePizz chinesePizz = new ChinesePizz();
            chinesePizz.setName(name);
            return chinesePizz;
        }
        return null;
    }
}
