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
 * 在线阅读：(OnlineReading)表实体类
 *
 */
@TableName("`online_reading`")
@Data
@EqualsAndHashCode(callSuper = false)
public class OnlineReading implements Serializable {

    // OnlineReading编号
    @TableId(value = "online_reading_id", type = IdType.AUTO)
    private Integer online_reading_id;

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
    // 内容
    @TableField(value = "`content`")
    private String content;

    // 点击数
    @TableField(value = "hits")
    private Integer hits;

    // 点赞数
    @TableField(value = "praise_len")
    private Integer praise_len;








    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
