package io.vforge.cauldron.repository.primary;

import io.vforge.cauldron.model.primary.elementcollection.Collector;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CollectorRepository extends CrudRepository<Collector, Long> {

    @EntityGraph(value = "Collector.attributes", type = EntityGraph.EntityGraphType.LOAD)
    List<Collector> findByAttributesKeyAndAttributesValue(String key, String value);
}
