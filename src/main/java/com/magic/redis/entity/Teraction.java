package com.magic.redis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_interaction_model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teraction implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "head")
    private String head;
    @Column(name = "body")
    private String body;
}
