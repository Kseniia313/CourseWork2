package pro.sky.CourseWork2.Service;

import pro.sky.CourseWork2.dto.Question;

import java.util.Collection;
import java.util.List;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
