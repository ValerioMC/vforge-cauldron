package io.vforge.cauldron.repository.primary;

import io.vforge.cauldron.model.primary.ids.MigratedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MigratedItemRepository extends JpaRepository<MigratedItem, Long> {
}
