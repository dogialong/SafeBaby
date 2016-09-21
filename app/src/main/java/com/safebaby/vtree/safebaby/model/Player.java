package com.safebaby.vtree.safebaby.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

/**
 * Created by longdg123 on 9/21/2016.
 */
@Table(name="User")
public class Player extends Model implements Serializable{
    @Column(name="userName")
    private String userName;

    @Column(name="medalUser",onDelete = Column.ForeignKeyAction.CASCADE)
    private Medals medalUser;

    public Player() {
        super();
    }

    public Player(String userName, Medals medalUser) {
        super();
        this.userName = userName;
        this.medalUser = medalUser;
    }
}

