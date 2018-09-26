package io.vforge.cauldron.manytomanyextra;

import io.vforge.cauldron.model.secondary.manytomanyextra.Post;
import io.vforge.cauldron.model.secondary.manytomanyextra.Tag;
import io.vforge.cauldron.repository.secondary.manytomanyextra.TagRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyExtraTest {

    @Autowired
    private TagRepository tagRepository;

    @Test
    public void testPersistence() {
        Tag misc = Tag.builder().name("spring-boot").build();
        Tag jdbc = Tag.builder().name("spring-rest").build();
        Tag hibernate = Tag.builder().name("spring-data-jpa").build();
        Tag jooq = Tag.builder().name("liquibase").build();

        tagRepository.save(misc);
        tagRepository.save(jdbc);
        tagRepository.save(hibernate);
        tagRepository.save(jooq);
    }





}
