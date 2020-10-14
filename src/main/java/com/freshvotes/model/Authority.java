package com.freshvotes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Authority{
    @NotNull
    @Id
    @Column(length = 50)
    private String authority;

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority){
        this.authority = authority;
    }
}
