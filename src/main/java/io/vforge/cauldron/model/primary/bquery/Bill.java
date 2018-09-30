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
    private long dateCreated;
    private boolean active;
    private String billSeq;
    private String stringSeq;
    private String priceType;
    private double iva;
    private double ice;
    private double total;
    private double subTotal;
    private double baseNoTaxes;
    private double baseTaxes;
    private String ordenDecompra;
    private String srr;
    private String lugar;
    private String otir;
    private double discount;
    private int discountPercentage;
    private String claveDeAcceso;
    private String idSri;
    private int typeDocument;
    private String quotationSeq;
    private String stringQuotationSeq;


    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<Payment> payment;
}