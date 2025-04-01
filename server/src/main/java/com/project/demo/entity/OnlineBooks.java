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
 * 线上图书：(OnlineBooks)表实体类
 *
 */
@TableName("`online_books`")
@Data
@EqualsAndHashCode(callSuper = false)
public class OnlineBooks implements Serializable {

    // OnlineBooks编号
    @TableId(value = "online_books_id", type = IdType.AUTO)
    private Integer online_books_id;

    // 图书编号
    @TableField(value = "`book_number`")
    private String book_number;
    // 图书名称
    @TableField(value = "`book_name`")
    private String book_name;
    // 图书类别
    @TableField(value = "`book_category`")
    private String book_category;
    // 封面
    @TableField(value = "`cover`")
    private String cover;
    // 作者
    @TableField(value = "`author`")
    private String author;
    // 出版社
    @TableField(value = "`press`")
    private String press;
    // VIP价格
    @TableField(value = "`vip_price`")
    private Integer vip_price;
    // 图书简介
    @TableField(value = "`book_introduction`")
    private String book_introduction;
    // 详情
    @TableField(value = "`details`")
    private String details;

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
