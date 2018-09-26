package io.vforge.cauldron.model.secondary.manytomanyextra;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "POST_TAG")
public class PostTag {

    @EmbeddedId
    private PostTagId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tagId")
    private Tag tag;

    @Column(name = "created_on")
    private Date createdOn = new Date();
}
