package com.tata.jiuye.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UmsMemberAndBranch implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户id(手机号)")
    private String userName;

    @ApiModelProperty(value = "是否是配送中心(00否  01是)")
    private Integer isBranch;

    @ApiModelProperty(value = "父级配送中心id")
    private Long parent;

    @ApiModelProperty(value = "会员配送中心id")
    private Long userBarnchId;

    @ApiModelProperty(value = "自身用户ID")
    private Long memberId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIsBranch() {
        return isBranch;
    }

    public void setIsBranch(Integer isBranch) {
        this.isBranch = isBranch;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getUserBarnchId() {
        return userBarnchId;
    }

    public void setUserBarnchId(Long userBarnchId) {
        this.userBarnchId = userBarnchId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", isBranch=").append(isBranch);
        sb.append(", parent=").append(parent);
        sb.append(", userBarnchId=").append(userBarnchId);
        sb.append(", memberId=").append(memberId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}