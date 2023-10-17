package pro.sky.CourseWork2.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.CourseWork2.Exception.NotEnoughQuestionException;
import pro.sky.CourseWork2.dto.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    @BeforeEach
    void beforeEach() {
        underTest = new JavaQuestionService();
    }

    private JavaQuestionService underTest = new JavaQuestionService();
    private Question question = new Question("question", "answer");

    @Test
    void add_shouldAddQuestionToSetAndReturnQuestionForExam() {
        Question result = underTest.add(question.getQuestion(), question.getAnswer());

        assertTrue(underTest.getAll().contains(question));
        assertEquals(question, result);
    }

    @Test
    void remove_shouldRemoveQuestionAndReturnQuestion() {

        underTest.add(new Question(question.getQuestion(), question.getAnswer()));
        Question result = underTest.remove(new Question(question.getQuestion(), question.getAnswer()));
        assertFalse(underTest.getAll().contains(question));
        assertEquals(question, result);

    }

    @Test
    void getAll_shouldReturnAllCollectionOfQuestions() {
        Question question1 = new Question("question1", "answer1");
        underTest.add(question1);
        underTest.add(question);

        Collection<Question> result= underTest.getAll();

        assertTrue(result.containsAll(Set.of(question, question1)));
    }

    @Test
    void getRandomQuestion_shouldThrowEnoughQuestionExceptionWhenCollectionIsEmpty() {
        NotEnoughQuestionException notEnoughQuestionException = assertThrows(NotEnoughQuestionException.class,
                ()->underTest.getRandomQuestion());
    }

    @Test
    void getRandomQuestion_shouldReturnRandomQuestion() {
        underTest.add(question);

        Question result = underTest.getRandomQuestion();
        assertEquals(question,result);

    }
}