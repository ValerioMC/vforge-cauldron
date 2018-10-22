package io.vforge.cauldron.model.primary.elementcollection;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class CollectorAttribute {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ID")
//    private Long id;

    @Column(name = "ATTRIBUTE_NAME")
    private String key;

    @Column(name = "ATTRIBUTE_VALUE")
    private String value;

    @Builder
    public CollectorAttribute(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
