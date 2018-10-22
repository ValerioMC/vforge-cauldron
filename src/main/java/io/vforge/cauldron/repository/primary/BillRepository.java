package io.vforge.cauldron.repository.primary;

import io.vforge.cauldron.model.primary.bquery.Bill;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface BillRepository extends PagingAndSortingRepository<Bill, UUID> {

    public List<Bill> findByActiveIsTrue();

}
