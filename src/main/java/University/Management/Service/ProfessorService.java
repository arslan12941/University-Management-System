package University.Management.Service;

import University.Management.Entity.Course;
import University.Management.Entity.Professor;
import University.Management.Repository.CourseRepository;
import University.Management.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final CourseRepository courseRepository;
    private final ProfessorRepository professorRepository;

    public ProfessorService(CourseRepository courseRepository, ProfessorRepository professorRepository) {
        this.courseRepository = courseRepository;
        this.professorRepository = professorRepository;
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public List<Course> getCoursesByProfessor(Long professorId) {
        return courseRepository.findByProfessorId(professorId);
    }
}