package io.vforge.cauldron.repository.primary;

import io.vforge.cauldron.model.primary.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
