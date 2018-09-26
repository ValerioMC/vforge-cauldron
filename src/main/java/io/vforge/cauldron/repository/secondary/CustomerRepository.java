package io.vforge.cauldron.repository.secondary;

import io.vforge.cauldron.model.secondary.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
