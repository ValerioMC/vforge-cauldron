package io.vforge.cauldron.repository.secondary;

import io.vforge.cauldron.model.secondary.manytomany.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
