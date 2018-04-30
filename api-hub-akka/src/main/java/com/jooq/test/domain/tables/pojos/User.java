/*
 * This file is generated by jOOQ.
*/
package com.jooq.test.domain.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User implements Serializable {

    private static final long serialVersionUID = 1046185529;

    private Integer   userId;
    private String    account;
    private String    activeYn;
    private Timestamp createDttm;
    private String    dept;
    private String    email;
    private String    name;
    private String    password;
    private String    role;
    private Timestamp updateDttm;

    public User() {}

    public User(User value) {
        this.userId = value.userId;
        this.account = value.account;
        this.activeYn = value.activeYn;
        this.createDttm = value.createDttm;
        this.dept = value.dept;
        this.email = value.email;
        this.name = value.name;
        this.password = value.password;
        this.role = value.role;
        this.updateDttm = value.updateDttm;
    }

    public User(
        Integer   userId,
        String    account,
        String    activeYn,
        Timestamp createDttm,
        String    dept,
        String    email,
        String    name,
        String    password,
        String    role,
        Timestamp updateDttm
    ) {
        this.userId = userId;
        this.account = account;
        this.activeYn = activeYn;
        this.createDttm = createDttm;
        this.dept = dept;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.updateDttm = updateDttm;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getActiveYn() {
        return this.activeYn;
    }

    public void setActiveYn(String activeYn) {
        this.activeYn = activeYn;
    }

    public Timestamp getCreateDttm() {
        return this.createDttm;
    }

    public void setCreateDttm(Timestamp createDttm) {
        this.createDttm = createDttm;
    }

    public String getDept() {
        return this.dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getUpdateDttm() {
        return this.updateDttm;
    }

    public void setUpdateDttm(Timestamp updateDttm) {
        this.updateDttm = updateDttm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(userId);
        sb.append(", ").append(account);
        sb.append(", ").append(activeYn);
        sb.append(", ").append(createDttm);
        sb.append(", ").append(dept);
        sb.append(", ").append(email);
        sb.append(", ").append(name);
        sb.append(", ").append(password);
        sb.append(", ").append(role);
        sb.append(", ").append(updateDttm);

        sb.append(")");
        return sb.toString();
    }
}
