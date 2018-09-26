package io.vforge.cauldron.repository.primary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@Slf4j
@Repository
public class QueryOrderCoreItemRepository {

    @PersistenceContext
    @Qualifier("primaryEntityManagerFactory")
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public BigInteger executeQuery(Long todoID) {
        BigInteger woID = (BigInteger) entityManager.createNativeQuery(
                "SELECT COLLECTOR_ID FROM COLLECTOR WHERE COLLECTOR_ID = ?1")
                .setParameter(1, todoID)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
        log.debug("After native query Todo ID: "+ todoID +" / WO ID: "+woID);
        return woID;
    }

}
