package com.magic.redis.entity;

import lombok.Data;
import org.reflections.serializers.Serializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "about_company")
public class AboutCompany implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Long type;
    @Column(name = "created_time")
    private Date createdTime;
    @Column(name = "update_time")
    private  Date updateTime;

}
