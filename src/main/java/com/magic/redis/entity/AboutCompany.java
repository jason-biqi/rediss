package com.magic.redis.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "about_company")
public class AboutCompany {
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
