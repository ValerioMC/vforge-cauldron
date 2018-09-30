package io.vforge.cauldron.model.primary.bquery;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Credits {
    @Id
    @GeneratedValue
    private UUID id;
    private int diasPlazo;
    private long fecha;
    private int payNumber;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

}
