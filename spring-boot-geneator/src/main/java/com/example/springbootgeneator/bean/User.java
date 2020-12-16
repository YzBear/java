package com.example.springbootgeneator.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class User {
    /**
     * 编号
     */
    @Id
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Byte status;

    /**
     * 机构ID
     */
    @Column(name = "dept_id")
    private Long deptId;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新人
     */
    @Column(name = "last_update_by")
    private String lastUpdateBy;

    /**
     * 更新时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @Column(name = "del_flag")
    private Byte delFlag;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取盐
     *
     * @return salt - 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐
     *
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取状态  0：禁用   1：正常
     *
     * @return status - 状态  0：禁用   1：正常
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态  0：禁用   1：正常
     *
     * @param status 状态  0：禁用   1：正常
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取机构ID
     *
     * @return dept_id - 机构ID
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置机构ID
     *
     * @param deptId 机构ID
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新人
     *
     * @return last_update_by - 更新人
     */
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * 设置更新人
     *
     * @param lastUpdateBy 更新人
     */
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * 获取更新时间
     *
     * @return last_update_time - 更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param lastUpdateTime 更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取是否删除  -1：已删除  0：正常
     *
     * @return del_flag - 是否删除  -1：已删除  0：正常
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * 设置是否删除  -1：已删除  0：正常
     *
     * @param delFlag 是否删除  -1：已删除  0：正常
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}