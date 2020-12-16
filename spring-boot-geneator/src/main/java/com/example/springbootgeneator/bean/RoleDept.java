package com.example.springbootgeneator.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role_dept")
public class RoleDept {
    /**
     * 编号
     */
    @Id
    private Long id;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Long roleId;

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
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
}