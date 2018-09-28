package io.vforge.cauldron.repository.primary;

import io.vforge.cauldron.model.primary.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    //@Override
    @QueryHints(value = { @QueryHint(name = org.hibernate.annotations.QueryHints.FLUSH_MODE, value = "COMMIT") })
    <S extends OrderItem> S save(S entity);
}
