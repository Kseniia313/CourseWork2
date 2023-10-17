package pro.sky.CourseWork2.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.CourseWork2.Service.QuestionService;
import pro.sky.CourseWork2.dto.Question;

import java.util.Collection;

@RestController
@RequestMapping("/java")

public class JavaController {
    private final QuestionService service;

    public JavaController(@Qualifier("javaQuestionService") QuestionService service) {

        this.service = service;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer) {

        return service.add(question, answer);
    }


    @GetMapping("/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return service.getAll();
    }
}
