package com.puboot.entity.system;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * pb_sys_authority
 *
 * @author
 */
@Data
@TableName("pb_sys_authority")
public class SysAuthority implements Serializable {

    private Integer id;

    /**
     * 权限名称
     */
    private String authName;

    /**
     * 权限编码
     */
    private String authCode;

    /**
     * 权限路径
     */
    private String authUrl;

    /**
     * 权限类型 1-菜单 2-按钮
     */
    private Integer authType;

    /**
     * 权限图标
     */
    private String authIcon;

    /**
     * 权限排序
     */
    private Integer authOrder;

    /**
     * 权限描述
     */
    private String authDescription;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建用户ID
     */
    private Integer createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新用户ID
     */
    private Integer updateBy;

    /**
     * 逻辑删除 0-未删除 1-已删除
     */
    @TableLogic
    private Boolean delFlag;

    private static final long serialVersionUID = 1L;
}