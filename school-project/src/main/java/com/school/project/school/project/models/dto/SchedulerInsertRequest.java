package com.school.project.school.project.models.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class SchedulerInsertRequest {
    public LocalDateTime startDate;
    public LocalDateTime endDate;

    public Integer userId;
    public Integer courseId;
}
