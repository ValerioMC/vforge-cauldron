package io.vforge.cauldron.repository.primary;

import io.vforge.cauldron.model.primary.OrderCoreItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderCoreItemRepository extends JpaRepository<OrderCoreItem, Long> {

    List<OrderCoreItem> findAllByOrderByIdAscOrderItemAsc();
}
