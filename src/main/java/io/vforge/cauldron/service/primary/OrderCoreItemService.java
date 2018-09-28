package io.vforge.cauldron.service.primary;

import io.vforge.cauldron.model.primary.OrderCoreItem;
import io.vforge.cauldron.model.primary.OrderItem;
import io.vforge.cauldron.repository.primary.OrderCoreItemRepository;
import io.vforge.cauldron.repository.primary.OrderCoreItemRepositoryEm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderCoreItemService {

    private final OrderCoreItemRepository orderCoreItemRepository;

    private final OrderCoreItemRepositoryEm orderCoreItemRepositoryEm;

    @Transactional
    public void testSecondSave() {

        OrderCoreItem orderCoreItem1 = new OrderCoreItem();
        OrderItem orderItem1 = new OrderItem();

        orderCoreItem1.setDescription("ORIGINAL DESCRIPTION");
        orderCoreItem1.setOrderItem(orderItem1);

        OrderCoreItem save = orderCoreItemRepository.save(orderCoreItem1);

        orderCoreItem1.setDescription("MODIFIED DESCRIPTION");

        orderCoreItemRepository.save(orderCoreItem1);

        Optional<OrderCoreItem> byId = orderCoreItemRepository.findById(save.getId());

        log.debug("description:", byId.get().getDescription());
    }

    @Transactional(rollbackOn = {Throwable.class})
    public void testNoSecondSave() {

        OrderCoreItem orderCoreItem1 = new OrderCoreItem();
        OrderItem orderItem1 = new OrderItem();

        orderCoreItem1.setDescription("ORIGINAL DESCRIPTION");
        orderCoreItem1.setOrderItem(orderItem1);

        OrderCoreItem save = orderCoreItemRepository.save(orderCoreItem1);

        orderCoreItem1.setDescription("MODIFIED DESCRIPTION");

        Optional<OrderCoreItem> byId = orderCoreItemRepository.findById(save.getId());

        log.debug("description:", byId.get().getDescription());
    }

    @Transactional
    public void testNoSecondSaveDetach() {

        OrderCoreItem orderCoreItem1 = new OrderCoreItem();
        OrderItem orderItem1 = new OrderItem();

        orderCoreItem1.setDescription("ORIGINAL DESCRIPTION");
        orderCoreItem1.setOrderItem(orderItem1);

        OrderCoreItem save = orderCoreItemRepository.save(orderCoreItem1);

        orderCoreItem1.setDescription("MODIFIED DESCRIPTION");

        Optional<OrderCoreItem> byId = orderCoreItemRepository.findById(save.getId());
        log.debug("description:", byId.get().getDescription());

        orderCoreItemRepositoryEm.detachOrderItem(orderCoreItem1);

        Optional<OrderCoreItem> byIdDetached = orderCoreItemRepository.findById(save.getId());
        log.debug("description:", byIdDetached.get().getDescription());
    }

    @Transactional
    public OrderCoreItem orderCoreItemStore() {
        OrderCoreItem orderCoreItem1 = new OrderCoreItem();
        OrderItem orderItem1 = new OrderItem();

        orderCoreItem1.setDescription("ORIGINAL DESCRIPTION");
        orderCoreItem1.setOrderItem(orderItem1);

        OrderCoreItem save = orderCoreItemRepository.save(orderCoreItem1);

        return save;
    }

    @Transactional
    public void orderCoreItemModify(OrderCoreItem orderCoreItem) {
        orderCoreItem.setDescription("MODIFIED DESCRIPTION");

        Optional<OrderCoreItem> byId = orderCoreItemRepository.findById(orderCoreItem.getId());
        log.debug("description:", byId.get().getDescription());

        byId.get().setDescription("MODIFIED DESCRIPTION");

        byId = orderCoreItemRepository.findById(orderCoreItem.getId());
        log.debug("description:", byId.get().getDescription());

        orderCoreItemRepositoryEm.detachOrderItem(byId.get());

        byId = orderCoreItemRepository.findById(orderCoreItem.getId());
        log.debug("description:", byId.get().getDescription());

        Optional<OrderCoreItem> byIdDetached = orderCoreItemRepository.findById(orderCoreItem.getId());
        log.debug("description:", byIdDetached.get().getDescription());
    }

}
