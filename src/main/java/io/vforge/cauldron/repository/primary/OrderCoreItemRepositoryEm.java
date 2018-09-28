package io.vforge.cauldron.repository.primary;

import io.vforge.cauldron.model.primary.OrderCoreItem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderCoreItemRepositoryEm {

    @PersistenceContext
    @Qualifier("primaryEntityManagerFactory")
    private EntityManager entityManager;


    public void detachOrderItem(OrderCoreItem orderCoreItem) {
        entityManager.detach(orderCoreItem);
    }
}
