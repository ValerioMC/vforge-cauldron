package io.vforge.cauldron.repository.primary;

import io.vforge.cauldron.model.primary.ids.MigratedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MigratedItemRepository extends JpaRepository<MigratedItem, Long> {
}
