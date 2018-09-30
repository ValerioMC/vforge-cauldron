package io.vforge.cauldron.repository.primary;

import io.vforge.cauldron.model.primary.distmax.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("select max(answer) from Answer answer where answer.deleted = false group by answer.userId, answer.questionId")
    List<Answer> findLatestAnswersByUserQuestionNotDeleted();

    @Query("select max(answer) from Answer answer group by answer.userId, answer.questionId")
    List<Answer> findLatestAnswersByUserQuestion();

    @Query("select max(answer.id) from Answer answer group by answer.userId, answer.questionId")
    List<Long> findLatestAnswersId();

    List<Answer> findAllByDeletedIsFalseAndIdIn(List<Long> ids);
}
