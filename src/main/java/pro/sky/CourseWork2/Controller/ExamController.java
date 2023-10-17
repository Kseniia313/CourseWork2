package pro.sky.CourseWork2.Controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.CourseWork2.Service.ExaminerService;
import pro.sky.CourseWork2.dto.Question;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping()
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
