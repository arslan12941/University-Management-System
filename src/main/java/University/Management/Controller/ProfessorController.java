package University.Management.Controller;

import University.Management.Entity.Course;
import University.Management.Entity.Professor;
import University.Management.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByProfessor(@PathVariable Long id) {
        return professorService.getCoursesByProfessor(id);
    }
}