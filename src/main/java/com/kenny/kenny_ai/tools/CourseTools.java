package com.kenny.kenny_ai.tools;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.kenny.kenny_ai.entity.po.Course;
import com.kenny.kenny_ai.entity.po.CourseReservation;
import com.kenny.kenny_ai.entity.po.School;
import com.kenny.kenny_ai.entity.query.CourseQuery;
import com.kenny.kenny_ai.service.ICourseReservationService;
import com.kenny.kenny_ai.service.ICourseService;
import com.kenny.kenny_ai.service.ISchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CourseTools {

    private final ICourseService courseService;
    private final ISchoolService schoolService;
    private final ICourseReservationService courseReservationService;

    @Tool(description = "根據條件查詢課程")
    public List<Course> queryCourse(CourseQuery query) {
        if (query == null) {
            return List.of();
        }
        QueryChainWrapper<Course> wrapper = courseService.query()
                .eq(query.getType() != null, "type", query.getType()) // type = '編程'
                .le(query.getEdu() != null, "edu", query.getEdu()); // deu <= 2
        if (query.getSorts() != null && !query.getSorts().isEmpty()) {
            for (CourseQuery.Sort sort : query.getSorts()) {
                wrapper.orderBy(true, sort.getAsc(),sort.getField());
            }
        }
        return wrapper.list();
    }

    @Tool(description = "查詢所有校區")
    public List<School> querySchool() {
        return schoolService.list();
    }

    @Tool(description = "根據課程名稱查詢哪些校區有該課程")
    public List<School> querySchoolsByCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            return List.of();
        }
        
        // 查詢哪些校區有該課程的預約記錄
        List<String> schoolNames = courseReservationService.query()
                .eq("course", courseName.trim())
                .list()
                .stream()
                .map(CourseReservation::getSchool)
                .distinct()
                .toList();
        
        if (schoolNames.isEmpty()) {
            return List.of();
        }
        
        // 根據校區名稱查詢校區詳情
        return schoolService.query()
                .in("name", schoolNames)
                .list();
    }

}
