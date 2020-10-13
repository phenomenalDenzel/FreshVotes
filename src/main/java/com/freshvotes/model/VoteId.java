package com.freshvotes.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class VoteId implements Serializable{
    private static final long serialVersionUID = 6202269445639364170L;

    @ManyToOne
    private User user;
    @ManyToOne
    private Feature feature;

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(final Feature feature) {
        this.feature = feature;
    }
}
