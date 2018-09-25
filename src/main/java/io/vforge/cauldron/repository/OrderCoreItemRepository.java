package io.vforge.cauldron.repository;

import io.vforge.cauldron.model.OrderCoreItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCoreItemRepository extends JpaRepository<OrderCoreItem, Long> {
}
