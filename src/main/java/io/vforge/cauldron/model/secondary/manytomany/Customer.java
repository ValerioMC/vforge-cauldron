package io.vforge.cauldron.model.secondary.manytomany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @ToString.Include
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "CUSTOMER_ADDRESS",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID") ,
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID"))
    private List<Address> addresses;

}
