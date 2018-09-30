package io.vforge.cauldron.model.primary.distmax;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "user_id")
    private Long userId;

    @Column
    private boolean deleted;


}
