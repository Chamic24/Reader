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
 * 小说分类：(NovelClassification)表实体类
 *
 */
@TableName("`novel_classification`")
@Data
@EqualsAndHashCode(callSuper = false)
public class NovelClassification implements Serializable {

    // NovelClassification编号
    @TableId(value = "novel_classification_id", type = IdType.AUTO)
    private Integer novel_classification_id;

    // 小说类别
    @TableField(value = "`novel_category`")
    private String novel_category;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
