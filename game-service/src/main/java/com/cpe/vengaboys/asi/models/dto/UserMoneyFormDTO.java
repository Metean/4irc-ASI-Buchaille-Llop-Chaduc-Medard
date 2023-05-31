package com.cpe.vengaboys.asi.models.dto;

public class UserMoneyFormDTO {
    private Long userId;
    private Double money;

    public UserMoneyFormDTO() {}
    public UserMoneyFormDTO(Double money) {
        this.money=money;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId=userId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
