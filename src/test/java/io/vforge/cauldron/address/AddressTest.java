package io.vforge.cauldron.address;

import io.vforge.cauldron.model.secondary.manytomany.Address;
import io.vforge.cauldron.model.secondary.manytomany.Customer;
import io.vforge.cauldron.repository.secondary.AddressRepository;
import io.vforge.cauldron.repository.secondary.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testAddress() {
        Customer customer = new Customer();
        Customer customer2 = new Customer();

        Address address = new Address();
        address.setPersons(Arrays.asList(customer, customer2));

        Address save = addressRepository.save(address);
        log.debug("saved entities", save);

        List<Customer> persons = save.getPersons();
        log.debug("saved persons", persons);

        for (Customer currentCustomer : persons) {
            Customer save1 = customerRepository.save(currentCustomer);
        }
    }

}
