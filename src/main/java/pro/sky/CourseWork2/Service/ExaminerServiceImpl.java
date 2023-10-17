package pro.sky.CourseWork2.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.Exception.NotEnoughQuestionException;
import pro.sky.CourseWork2.dto.Question;

import java.util.*;


@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random rnd = new Random();
    private final QuestionService questionService;
    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new NotEnoughQuestionException();
        }

        Set<Question> questionsForUzer = new HashSet<>();
        while (questionsForUzer.size() < amount) {
            questionsForUzer.add(questionService.getRandomQuestion());
        }

        return questionsForUzer;
    }
}








