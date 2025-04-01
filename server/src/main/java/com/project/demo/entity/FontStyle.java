package com.project.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 字体样式：(FontStyle)表实体类
 *
 */
@TableName("`font_style`")
@Data
@EqualsAndHashCode(callSuper = false)
public class FontStyle implements Serializable {

    // FontStyle编号
    @TableId(value = "font_style_id", type = IdType.AUTO)
    private Integer font_style_id;

    // 字体样式
    @TableField(value = "`font_style`")
    private String font_style;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
