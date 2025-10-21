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
@TableName("course_reservation")
public class CourseReservation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 預約課程
     */
    private String course;

    /**
     * 學生姓名
     */
    private String studentName;

    /**
     * 聯絡方式
     */
    private String contactInfo;

    /**
     * 預約校區
     */
    private String school;

    /**
     * 備註
     */
    private String remark;


}
