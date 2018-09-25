package io.vforge.cauldron;

import io.vforge.cauldron.model.OrderCoreItem;
import io.vforge.cauldron.model.OrderItem;
import io.vforge.cauldron.repository.OrderCoreItemRepository;
import io.vforge.cauldron.repository.OrderItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class VforgeCauldronApplicationTests {

    @Autowired
    private OrderCoreItemRepository orderCoreItemRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test

    public void contextLoads() {
        OrderItem item = new OrderItem();
        OrderCoreItem coreItem = new OrderCoreItem();
        coreItem.setOrderItem(item);
        item.setCoreItem(coreItem);
        //orderItemRepository.save(item);
        orderItemRepository.save(item);

        List<OrderCoreItem> all = orderCoreItemRepository.findAll();

        log.debug("log: ", all);



    }

}
