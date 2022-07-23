package com.kou.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaokou
 * @since 2022-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ms_sys_log")
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long createDate;

    private String ip;

    private String method;

    private String module;

    private String nickname;

    private String operation;

    private String params;

    private Long time;

    private Long userid;


}
