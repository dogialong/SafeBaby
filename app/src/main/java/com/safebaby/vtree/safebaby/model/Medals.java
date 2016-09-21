package com.safebaby.vtree.safebaby.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

/**
 * Created by longdg123 on 9/21/2016.
 */
@Table(name="Medal")
class Medals extends Model implements Serializable {
    @Column(name="id_medal")
    private int id_medal;
    @Column(name="medal_home")
    private int medal_home;
    @Column(name="medal_picnic")
    private int medal_picnic;

    public Medals() {
        super();
    }

    public Medals(int id_medal, int medal_home, int medal_picnic) {
        super();
        this.id_medal = id_medal;
        this.medal_home = medal_home;
        this.medal_picnic = medal_picnic;
    }
}
