package io.vforge.cauldron.repository.primary;

import io.vforge.cauldron.model.primary.bquery.Bill;
import io.vforge.cauldron.model.primary.bquery.Credits;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CreditsRepository extends CrudRepository<Credits, UUID> {

    List<Credits> findAllByPaymentBill(Bill bill);

    List<Credits> findAllByPaymentBillId(UUID id);

}
