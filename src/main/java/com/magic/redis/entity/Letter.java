package com.magic.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_letter")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Letter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "letter")
    private String letter;
    @Column(name = "createDate")
    private String createDate;
    @Column(name = "name")
    private String name;


    public static Boolean aaa(Letter letter){


        return letter==new Letter();
    }



}
