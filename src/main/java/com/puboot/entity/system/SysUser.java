package com.puboot.entity.system;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * pb_sys_user
 *
 * @author
 */
@Data
@TableName("pb_sys_user")
public class SysUser implements Serializable {

    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private Integer nickName;

    /**
     * 性别 1-男 0-女
     */
    private Boolean sex;

    private String email;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 住址
     */
    private String address;

    /**
     * 是否有效 0-无效 1-有效
     */
    private Boolean enabled;

    /**
     * 是否被锁定 0-未锁定 1-已锁定
     */
    private Boolean locked;

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