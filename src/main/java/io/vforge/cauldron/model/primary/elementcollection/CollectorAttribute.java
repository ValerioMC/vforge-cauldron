package io.vforge.cauldron.model.primary.elementcollection;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class CollectorAttribute {

    @Column(name = "ATTRIBUTE_NAME")
    private String key;

    @Column(name = "ATTRIBUTE_VALUE")
    private String value;

}
