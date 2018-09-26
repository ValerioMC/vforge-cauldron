package io.vforge.cauldron.model.primary.elementcollection;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@NamedEntityGraph(name = "Collector.attributes",
        attributeNodes = @NamedAttributeNode("attributes"))
@Entity
@Table(name = "COLLECTOR")
public class Collector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COLLECTOR_ID")
    private Long id;

    @NotNull
    private String name;

    @ElementCollection
    @CollectionTable(name = "COLLECTOR_ATTRIBUTES", joinColumns = @JoinColumn(name = "COLLECTOR_ID"))
    private List<CollectorAttribute> attributes;


}