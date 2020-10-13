package com.freshvotes.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Comment {
    @EmbeddedId
    private CommentId pk;
    @Column(length = 5000)
    private String text;

    public CommentId getPk() {
        return pk;
    }

    public void setPk(final CommentId pk) {
        this.pk = pk;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
