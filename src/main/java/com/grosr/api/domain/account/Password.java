package com.grosr.api.domain.account;

import com.grosr.api.domain.common.BaseDomain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by grosr on 3/26/17.
 */
@Entity
@Table(name = "G_PASSWORD")
public class Password extends BaseDomain{

    @Id
    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @Column(name = "password")
    private String password;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return getUserId() != null ? getUserId().equals(account.getUserId()) : account.getUserId() == null;
    }

    @Override
    public int hashCode() {
        return getUserId() != null ? getUserId().hashCode() : 0;
    }
}
