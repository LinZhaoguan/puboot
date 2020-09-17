package com.puboot.entity.system;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * pb_sys_user_role
 *
 * @author
 */
@Data
@TableName("pb_sys_user_role")
public class SysUserRole implements Serializable {

    private Integer id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roleId;

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