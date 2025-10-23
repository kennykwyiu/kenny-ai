package com.kenny.kenny_ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kenny.kenny_ai.entity.po.Course;
import com.kenny.kenny_ai.mapper.CourseMapper;
import com.kenny.kenny_ai.service.ICourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
