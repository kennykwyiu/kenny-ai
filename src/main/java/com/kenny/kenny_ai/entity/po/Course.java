package com.kenny.kenny_ai.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course")
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主鍵
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 學科名稱
     */
    private String name;

    /**
     * 學歷背景要求：0-無，1-初中，2-高中、3-大專、4-本科以上
     */
    private Integer edu;

    /**
     * 課程類型：程式設計、設計、自媒體、其它
     */
    private String type;

    /**
     * 課程價格
     */
    private Long price;

    /**
     * 學習時長，單位: 天
     */
    private Integer duration;


}
