package University.Management.Service;

import University.Management.Entity.Course;
import University.Management.Entity.Professor;
import University.Management.Repository.CourseRepository;
import University.Management.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;

    public ProfessorService(ProfessorRepository professorRepository, CourseRepository courseRepository) {
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }

    public Professor addProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Course addCourse(Long professorId, Course course) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found!"));

        course.setProfessor(professor);
        return courseRepository.save(course);
    }

    public List<Course> getCoursesByProfessor(Long professorId) {
        if (!professorRepository.existsById(professorId)) {
            throw new RuntimeException("Professor not found!");
        }
        return courseRepository.findByProfessorId(professorId);
    }
}