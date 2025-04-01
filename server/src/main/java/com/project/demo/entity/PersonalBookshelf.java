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
 * 个人书架：(PersonalBookshelf)表实体类
 *
 */
@TableName("`personal_bookshelf`")
@Data
@EqualsAndHashCode(callSuper = false)
public class PersonalBookshelf implements Serializable {

    // PersonalBookshelf编号
    @TableId(value = "personal_bookshelf_id", type = IdType.AUTO)
    private Integer personal_bookshelf_id;

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
    // 出版社
    @TableField(value = "`press`")
    private String press;
    // 用户编号
    @TableField(value = "`user_number`")
    private Integer user_number;
    // 电话
    @TableField(value = "`telephone`")
    private String telephone;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
