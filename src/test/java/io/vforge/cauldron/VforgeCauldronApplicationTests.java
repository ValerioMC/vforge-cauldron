package io.vforge.cauldron;

import io.vforge.cauldron.model.primary.elementcollection.Collector;
import io.vforge.cauldron.model.primary.elementcollection.CollectorAttribute;
import io.vforge.cauldron.model.primary.OrderCoreItem;
import io.vforge.cauldron.model.primary.OrderItem;
import io.vforge.cauldron.repository.primary.CollectorRepository;
import io.vforge.cauldron.repository.primary.OrderCoreItemRepository;
import io.vforge.cauldron.repository.primary.OrderItemRepository;
import io.vforge.cauldron.repository.primary.QueryOrderCoreItemRepository;
import io.vforge.cauldron.service.primary.OrderCoreItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class VforgeCauldronApplicationTests {

    @Autowired
    private OrderCoreItemService orderCoreItemService;

    @Autowired
    private OrderCoreItemRepository orderCoreItemRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CollectorRepository collectorRepository;

    @Autowired
    private QueryOrderCoreItemRepository queryOrderCoreItemRepository;

    @Test
    public void testOrder() {
        OrderItem item = new OrderItem();
        OrderCoreItem coreItem = new OrderCoreItem();
        coreItem.setOrderItem(item);
        item.setCoreItem(coreItem);
        orderCoreItemRepository.save(coreItem);
        //orderItemRepository.save(item);
        List<OrderCoreItem> all = orderCoreItemRepository.findAll();
        log.debug("log: ", all);
        List<OrderCoreItem> allOrderByIdAndAndOrderItem = orderCoreItemRepository.findAllByOrderByIdAscOrderItemAsc();
        log.debug("log: ", allOrderByIdAndAndOrderItem);
    }


    @Test
    public void testSessionCacheNo2sdSave() {

        orderCoreItemService.testNoSecondSave();
    }

    @Test
    public void testSessionCache2sdSave() {

        orderCoreItemService.testSecondSave();
    }

    @Test
    public void testSessionDetached() {

        orderCoreItemService.testNoSecondSaveDetach();
    }

    @Test
    public void testSessionDetached2Session() {

        OrderCoreItem orderCoreItem = orderCoreItemService.orderCoreItemStore();
        orderCoreItemService.orderCoreItemModify(orderCoreItem);
    }



    @Test
    public void testCauldron() {
        CollectorAttribute collectorAttribute = new CollectorAttribute("test", "test");
        CollectorAttribute collectorAttribute1 = new CollectorAttribute("test1", "test1");
        CollectorAttribute collectorAttribute3 = new CollectorAttribute("test2", "test2");

        Collector collector = Collector.builder()
                 .name("firstCollector")
                 .attributes(Arrays.asList(collectorAttribute, collectorAttribute1, collectorAttribute3)).build();

        Collector save = collectorRepository.save(collector);
        log.debug("saved collector: " + save);

        List<Collector> byAttributes = collectorRepository.findByAttributesKeyAndAttributesValue("test", "test");
        log.debug("saved collector: " + byAttributes);

    }

    @Test
    public void testCauldronNative() {

        CollectorAttribute collectorAttribute = new CollectorAttribute("test", "test");
        CollectorAttribute collectorAttribute1 = new CollectorAttribute("test1", "test1");
        CollectorAttribute collectorAttribute3 = new CollectorAttribute("test2", "test2");

        Collector collector = Collector.builder()
                .name("firstCollector")
                .attributes(Arrays.asList(collectorAttribute, collectorAttribute1, collectorAttribute3)).build();

        Collector save = collectorRepository.save(collector);
        log.debug("saved collector: " + save);

        List<Collector> byAttributes = collectorRepository.findByAttributesKeyAndAttributesValue("test", "test");
        log.debug("saved collector: " + byAttributes);

        BigInteger integer = queryOrderCoreItemRepository.executeQuery(1L);
        log.debug("found entity: " + integer);
    }

}
