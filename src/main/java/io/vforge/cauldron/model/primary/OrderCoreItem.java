package io.vforge.cauldron.model.primary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ORDER_CORE_ITEMS")
public class OrderCoreItem {

    @ToString.Include
    @Id
    @GeneratedValue(generator = "foreign")
    @GenericGenerator(name = "foreign", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "orderItem"))
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne(mappedBy = "coreItem", optional = false)
    private OrderItem orderItem;

}