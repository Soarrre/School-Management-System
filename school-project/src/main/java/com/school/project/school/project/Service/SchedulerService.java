package com.school.project.school.project.service;

import com.school.project.school.project.models.Course;
import com.school.project.school.project.models.Scheduler;
import com.school.project.school.project.models.User;
import com.school.project.school.project.models.dto.SchedulerInsertRequest;
import com.school.project.school.project.repository.CourseRepository;
import com.school.project.school.project.repository.SchedulerRepository;
import com.school.project.school.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulerService {
    private final SchedulerRepository schedulerRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Autowired
    public SchedulerService(SchedulerRepository schedulerRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.schedulerRepository = schedulerRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

<<<<<<< HEAD
    public List<Scheduler> getSchedule() {
=======
    public List<Scheduler> get() {
>>>>>>> master
        return schedulerRepository.findAll();
    }

    public Scheduler getById(Integer id) {
        return schedulerRepository.findById(id).orElse(null);
    }

    public void add(SchedulerInsertRequest dto) {

<<<<<<< HEAD
        Scheduler overlappingScheduler = schedulerRepository.findByStartDateOrEndDate(dto.startDate, dto.endDate)
                                                            .orElseThrow( () -> new IllegalStateException("scheduler incepand la aceasta ora deja exista"));
=======
        if (dbScheduler != null) {
            throw new IllegalStateException(("nu exista acest curs"));
        }
>>>>>>> master

        Scheduler existingUserAtCourse = schedulerRepository.findByUserIdAndCourseId(dto.userId, dto.courseId)
                                                            .orElseThrow(() -> new IllegalStateException("user deja in curs"));

        User dbUser = userRepository.findUserById(dto.userId).get();
        Course dbCourse = courseRepository.findById(dto.courseId).get();

        schedulerRepository.save(new Scheduler(dto.startDate, dto.endDate, dbUser, dbCourse));
    }


    public void delete(Integer schedulerId) {
        schedulerRepository.findById(schedulerId);
        boolean exists = schedulerRepository.existsById(schedulerId);
        if (!exists) {
            throw new IllegalStateException("scheduler with id" + schedulerId + " does not exist");
        }
<<<<<<< HEAD
    }

=======

        User dbUser = userRepository.findUserById(dto.userId).get();

        if (dbUser != null) {
            throw new IllegalStateException(("exista user"));
        }
        Optional<User> userById = userRepository.findById(dbUser.getId());
        if (userById.isPresent()) {
            throw new IllegalStateException("user exista deja in scheduler");
        }
        Course dbCourse = courseRepository.findCourseById(dto.courseId).get();
        if (dbCourse != null) {
            throw new IllegalStateException(("exista cursuri"));
        }
        Optional<Course> courseById = courseRepository.findById(dbCourse.getId());
        throw new IllegalStateException(("curs exista deja in scheduler"));
    }

    //  schedulerRepository.save();
    public void delete(Integer schedulerId) {
        schedulerRepository.findById(schedulerId);
        boolean exists = schedulerRepository.existsById(schedulerId);
        if (!exists) {
            throw new IllegalStateException("scheduler with id" + schedulerId + " does not exist");
        }
    }

>>>>>>> master
  /*  @Transactional
    public void update(Integer schedulerId, SchedulerUpdateRequest request) {
        Scheduler scheduler = schedulerRepository.findById(schedulerId).orElseThrow(() -> new IllegalStateException("course with id" + schedulerId + "does not exist"));
        if (request.startDate != null && request.startDate != 0 && !Objects.equals(scheduler.getstartDate(), request.startDate)) {
            scheduler.setstartDate(request.startDate);

        }
       }
   */
}

