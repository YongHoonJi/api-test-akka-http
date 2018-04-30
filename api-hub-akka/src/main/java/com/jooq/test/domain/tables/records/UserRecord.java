/*
 * This file is generated by jOOQ.
*/
package com.jooq.test.domain.tables.records;


import com.jooq.test.domain.tables.User;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


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
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record10<Integer, String, String, Timestamp, String, String, String, String, String, Timestamp> {

    private static final long serialVersionUID = -1588500382;

    /**
     * Setter for <code>test_temp.user.user_id</code>. 순번
     */
    public void setUserId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>test_temp.user.user_id</code>. 순번
     */
    public Integer getUserId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>test_temp.user.account</code>. 계정
     */
    public void setAccount(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>test_temp.user.account</code>. 계정
     */
    public String getAccount() {
        return (String) get(1);
    }

    /**
     * Setter for <code>test_temp.user.active_yn</code>. 사용여부
     */
    public void setActiveYn(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>test_temp.user.active_yn</code>. 사용여부
     */
    public String getActiveYn() {
        return (String) get(2);
    }

    /**
     * Setter for <code>test_temp.user.create_dttm</code>. 생성일시
     */
    public void setCreateDttm(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>test_temp.user.create_dttm</code>. 생성일시
     */
    public Timestamp getCreateDttm() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>test_temp.user.dept</code>. 부서
     */
    public void setDept(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>test_temp.user.dept</code>. 부서
     */
    public String getDept() {
        return (String) get(4);
    }

    /**
     * Setter for <code>test_temp.user.email</code>. 이메일
     */
    public void setEmail(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>test_temp.user.email</code>. 이메일
     */
    public String getEmail() {
        return (String) get(5);
    }

    /**
     * Setter for <code>test_temp.user.name</code>. 이름
     */
    public void setName(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>test_temp.user.name</code>. 이름
     */
    public String getName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>test_temp.user.password</code>. 패스워드
     */
    public void setPassword(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>test_temp.user.password</code>. 패스워드
     */
    public String getPassword() {
        return (String) get(7);
    }

    /**
     * Setter for <code>test_temp.user.role</code>. 권한
     */
    public void setRole(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>test_temp.user.role</code>. 권한
     */
    public String getRole() {
        return (String) get(8);
    }

    /**
     * Setter for <code>test_temp.user.update_dttm</code>. 수정일시
     */
    public void setUpdateDttm(Timestamp value) {
        set(9, value);
    }

    /**
     * Getter for <code>test_temp.user.update_dttm</code>. 수정일시
     */
    public Timestamp getUpdateDttm() {
        return (Timestamp) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, String, String, Timestamp, String, String, String, String, String, Timestamp> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, String, String, Timestamp, String, String, String, String, String, Timestamp> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return User.USER.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return User.USER.ACCOUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return User.USER.ACTIVE_YN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return User.USER.CREATE_DTTM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return User.USER.DEPT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return User.USER.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return User.USER.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return User.USER.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return User.USER.ROLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field10() {
        return User.USER.UPDATE_DTTM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAccount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getActiveYn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getCreateDttm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getDept();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getRole();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component10() {
        return getUpdateDttm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAccount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getActiveYn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getCreateDttm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getDept();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getRole();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value10() {
        return getUpdateDttm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value1(Integer value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value2(String value) {
        setAccount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value3(String value) {
        setActiveYn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value4(Timestamp value) {
        setCreateDttm(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value5(String value) {
        setDept(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value6(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value7(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value8(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value9(String value) {
        setRole(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord value10(Timestamp value) {
        setUpdateDttm(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRecord values(Integer value1, String value2, String value3, Timestamp value4, String value5, String value6, String value7, String value8, String value9, Timestamp value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer userId, String account, String activeYn, Timestamp createDttm, String dept, String email, String name, String password, String role, Timestamp updateDttm) {
        super(User.USER);

        set(0, userId);
        set(1, account);
        set(2, activeYn);
        set(3, createDttm);
        set(4, dept);
        set(5, email);
        set(6, name);
        set(7, password);
        set(8, role);
        set(9, updateDttm);
    }
}