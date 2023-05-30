package com.cpe.llop.chaduc.buchaille.medard.asi.models;

import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private String roomName;

    private Boolean isCancel;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Card card1 = null;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Card card2 = null;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private User winner = null;


    public Room() {
    }

    public Room(Card card1) {
        this.card1 = card1;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }


    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Boolean getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Boolean isCancel) {
        this.isCancel = isCancel;
    }

    public Card getCard1() {
        return card1;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public Card getCard2() {
        return card2;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }
}
