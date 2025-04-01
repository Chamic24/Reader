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
 * 阅读设置：(ReadSettings)表实体类
 *
 */
@TableName("`read_settings`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ReadSettings implements Serializable {

    // ReadSettings编号
    @TableId(value = "read_settings_id", type = IdType.AUTO)
    private Integer read_settings_id;

    // 图书编号
    @TableField(value = "`book_number`")
    private String book_number;
    // 图书名称
    @TableField(value = "`book_name`")
    private String book_name;
    // 图书类别
    @TableField(value = "`book_category`")
    private String book_category;
    // 作者
    @TableField(value = "`author`")
    private String author;
    // 章节
    @TableField(value = "`chapter`")
    private String chapter;
    // 用户编号
    @TableField(value = "`user_number`")
    private Integer user_number;
    // 阅读背景
    @TableField(value = "`reading_background`")
    private String reading_background;
    // 字体大小
    @TableField(value = "`font_size`")
    private String font_size;
    // 字体样式
    @TableField(value = "`font_style`")
    private String font_style;
    // 阅读进度
    @TableField(value = "`reading_progress`")
    private String reading_progress;
    // 阅读批注
    @TableField(value = "`read_comments`")
    private String read_comments;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
