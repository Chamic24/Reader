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
 * 购买VIP：(PurchaseVip)表实体类
 *
 */
@TableName("`purchase_vip`")
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseVip implements Serializable {

    // PurchaseVip编号
    @TableId(value = "purchase_vip_id", type = IdType.AUTO)
    private Integer purchase_vip_id;

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
    // VIP价格
    @TableField(value = "`vip_price`")
    private String vip_price;
    // 用户编号
    @TableField(value = "`user_number`")
    private Integer user_number;
    // 姓名
    @TableField(value = "`full_name`")
    private String full_name;
    // 电话
    @TableField(value = "`telephone`")
    private String telephone;



    // 审核状态
    @TableField(value = "examine_state")
    private String examine_state;

    // 支付状态
    @TableField(value = "pay_state")
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @TableField(value = "pay_type")
    private String pay_type;


    // 审核回复
    @TableField(value = "examine_reply")
    private String examine_reply;




    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
