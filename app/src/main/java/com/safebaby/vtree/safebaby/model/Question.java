package com.safebaby.vtree.safebaby.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

/**
 * Created by longdg123 on 9/19/2016.
 */
@Table(name="Question")
public class Question extends Model implements Serializable {
    @Column(name="id_question")
    public int id_question;
    @Column(name="link_image")
    public String link_image;
    @Column(name="name_image")
    public String name_image;
    @Column(name="link_youtube")
    public String link_youtube;
    @Column(name="cate_type")
    public String cate_type;
    public Question() {
        super();
    }

    public Question(String link_image, String name_image, String link_youtube,String cate_type) {
        super();
        this.link_image = link_image;
        this.name_image = name_image;
        this.link_youtube = link_youtube;
        this.cate_type = cate_type;
    }

}
