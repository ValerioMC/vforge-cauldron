package io.vforge.cauldron.repository.secondary.manytomanyextra;

import io.vforge.cauldron.model.secondary.manytomanyextra.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
