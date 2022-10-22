package com.school.project.school.project.controllers;

import com.school.project.school.project.models.Scheduler;
import com.school.project.school.project.models.dto.SchedulerInsertRequest;
import com.school.project.school.project.models.dto.SchedulerUpdateRequest;
import com.school.project.school.project.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/scheduler")

public class SchedulerController {

    private final SchedulerService schedulerService;

    @Autowired
    public SchedulerController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping(produces = {"application/json"})
    public Scheduler getScheduler(Integer schedulerId) {
        return schedulerService.getById(schedulerId);
    }

    @PostMapping(produces = {"application/json"})
    public boolean registerNewScheduler(@RequestBody SchedulerInsertRequest dto) {
        schedulerService.add(dto);
        return true;
    }

    @DeleteMapping(path = "{schedulerId}")
    public void deleteScheduler(@PathVariable("schedulerId") Integer schedulerId) {
        schedulerService.delete(schedulerId);
    }

    @PutMapping(path = "{schedulerId}")
    public void updateScheduler(@PathVariable("schedulerId") Integer schedulerId, @RequestBody SchedulerUpdateRequest request) {
        schedulerService.update(schedulerId, request);
    }
    

}
