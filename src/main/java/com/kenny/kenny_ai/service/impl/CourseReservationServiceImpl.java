package com.kenny.kenny_ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kenny.kenny_ai.entity.po.CourseReservation;
import com.kenny.kenny_ai.mapper.CourseReservationMapper;
import com.kenny.kenny_ai.service.ICourseReservationService;
import org.springframework.stereotype.Service;

@Service
public class CourseReservationServiceImpl extends ServiceImpl<CourseReservationMapper, CourseReservation> implements ICourseReservationService {
}
