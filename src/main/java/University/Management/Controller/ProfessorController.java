package University.Management.Controller;

import University.Management.Entity.Course;
import University.Management.Entity.Professor;
import University.Management.Service.ProfessorService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Professor> addProfessor(@RequestBody Professor professor) {
        Professor savedProfessor = professorService.addProfessor(professor);
        return ResponseEntity.ok(savedProfessor);
    }

    @PostMapping("/{id}/courses")
    public ResponseEntity<Course> addCourse(@PathVariable Long id, @RequestBody Course course) {
        Course savedCourse = professorService.addCourse(id, course);
        return ResponseEntity.ok(savedCourse);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesByProfessor(@PathVariable Long id) {
        List<Course> courses = professorService.getCoursesByProfessor(id);
        return ResponseEntity.ok(courses);
    }
}