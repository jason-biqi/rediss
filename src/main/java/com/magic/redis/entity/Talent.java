package com.magic.redis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_talent_model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer title;
    private String news;
    @Column(name = "title_name")
    private String titleName;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "author")
    private String author;
}
