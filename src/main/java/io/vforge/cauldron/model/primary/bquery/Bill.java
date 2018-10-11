package io.vforge.cauldron.model.primary.bquery;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Bill {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<Payment> payment;
}