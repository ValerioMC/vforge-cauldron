package io.vforge.cauldron.distmax;

import io.vforge.cauldron.AbstractTest;
import io.vforge.cauldron.model.primary.distmax.Answer;
import io.vforge.cauldron.repository.primary.AnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
public class TestDistMax extends AbstractTest {

    @Autowired
    @NotNull
    private AnswerRepository answerRepository;

    @Test
    public void testDistMax() {

        List<Answer> answers = answerRepository.findLatestAnswersByUserQuestionNotDeleted();

        log.debug("Latest answers: ", answers);

        List<Long> ids = answerRepository.findLatestAnswersId();

        log.debug("Latest answers: ", answers);

        List<Answer> allByDeletedIsFalseAndIdIn = answerRepository.findAllByDeletedIsFalseAndIdIn(ids);

        log.debug("Latest answers: ", allByDeletedIsFalseAndIdIn);

    }

}
