package pro.sky.CourseWork2.Service;

import org.springframework.stereotype.Service;
import pro.sky.CourseWork2.Exception.NotEnoughQuestionException;
import pro.sky.CourseWork2.dto.Question;

import java.util.*;
import java.util.Random;
import java.util.function.BooleanSupplier;

@Service

public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new HashSet<>();
    private final Random rnd = new Random();

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }

    public JavaQuestionService() {

    }

    @Override

    public Question add(String question, String answer) {
        Question questionForExam = new Question(question, answer);
        return add(questionForExam);
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new NotEnoughQuestionException();
        }
        int random = rnd.nextInt(questions.size());
        return (Question) questions.toArray()[random];
    }
}




