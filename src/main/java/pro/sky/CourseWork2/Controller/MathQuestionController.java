package pro.sky.CourseWork2.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import pro.sky.CourseWork2.Service.QuestionService;

public class MathQuestionController {
    private QuestionService service;

    public MathQuestionController(@Qualifier("") QuestionService questionService) {
        this.service = questionService;
    }
}
