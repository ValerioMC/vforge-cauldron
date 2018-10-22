package io.vforge.cauldron;


import io.vforge.cauldron.model.primary.ids.MigratedItem;
import io.vforge.cauldron.repository.primary.BillRepository;
import io.vforge.cauldron.repository.primary.MigratedItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MigratedItemTest {

    @Autowired
    private MigratedItemRepository migratedItemRepository;

    @Autowired
    private BillRepository billRepository;

    @Test
    public void testManualId() {

        MigratedItem migratedItem = MigratedItem.builder().id(100L).description("suka").build();

        migratedItemRepository.save(migratedItem);

        Optional<MigratedItem> byId = migratedItemRepository.findById(100L);

        log.debug("migrated items:", byId.get());
    }

    @Test
    public void testLocalDate() {
        LocalDate now = LocalDate.now() ;
        LocalDateTime.of(LocalDate.of(2999, 12, 31), LocalTime.MIDNIGHT).atZone(ZoneId.of(
                "UTC")).format(DateTimeFormatter.ISO_INSTANT);
        log.debug("Log", now);
    }

}
