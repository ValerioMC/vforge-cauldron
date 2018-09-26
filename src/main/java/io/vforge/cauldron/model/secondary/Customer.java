package io.vforge.cauldron.model.secondary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @ToString.Include
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
