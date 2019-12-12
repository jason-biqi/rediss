package com.magic.redis.service;

import com.magic.redis.entity.Pizz;
import org.hibernate.validator.constraints.SafeHtml;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        CreateContre createContre=new CreateContre();
        createContre.setCreatPizz(new ChineseCtreat());


        Pizz pizz = createContre.out("ChinesePizz");
        Pizz pizz1 = createContre.out("ChinesePizz");
        pizz.perpare();
        pizz.bake();
        pizz.box();
        System.err.println(pizz.equals(pizz1));



    }


}
