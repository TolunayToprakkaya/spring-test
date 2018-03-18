package com.example.demo.domain.entities;

import com.example.demo.domain.entities.seedwork.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "createTime")
    private Timestamp createTime;
    @Column(name = "updateTime")
    private Timestamp updateTime;

    @RestResource(exported = false)
    @ManyToOne
    @JoinColumn(name = "create_by")
    private User createBy;

    @RestResource(exported = false) // bunlar rest cagrisi yaptiginda rekursif olarak kendini dondurup, stackoverflow hatasi verir, ondan ignore ettik.
    @ManyToOne
    @JoinColumn(name = "update_by")
    private User updateBy;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @JsonIgnore
    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    @JsonIgnore
    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }
}
