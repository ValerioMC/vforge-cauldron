package io.vforge.cauldron.model.primary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {

    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name="author_generator", sequenceName = "author_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ToString.Include
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ORDER_ITEM_ID")
    private OrderCoreItem coreItem;
}