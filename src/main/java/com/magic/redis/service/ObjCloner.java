package com.magic.redis.service;

import java.io.*;

/**
 * @author jiaosong
 * @version V1.0
 * @ClassName:ObjCloner
 * @Description: TODO
 * @Date 14:26
 */
public class ObjCloner<T> {



    public static <T>T clone(T obj) throws IOException, ClassNotFoundException {

        T t;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(obj);


        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream  ois = new ObjectInputStream(bis);

        t = (T)ois.readObject();

        return t;
    }


}
