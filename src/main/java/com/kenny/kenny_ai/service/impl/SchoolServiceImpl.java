package com.kenny.kenny_ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kenny.kenny_ai.entity.po.School;
import com.kenny.kenny_ai.mapper.SchoolMapper;
import com.kenny.kenny_ai.service.ISchoolService;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements ISchoolService {

}