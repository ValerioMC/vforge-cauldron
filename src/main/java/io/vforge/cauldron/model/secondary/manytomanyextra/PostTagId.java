package io.vforge.cauldron.model.secondary.manytomanyextra;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class PostTagId implements Serializable {

    @Column(name = "POST_ID")
    private Long postId;

    @Column(name = "TAG_ID")
    private Long tagId;

    @Column(name = "DESCRIPTION")
    private String description;

}
