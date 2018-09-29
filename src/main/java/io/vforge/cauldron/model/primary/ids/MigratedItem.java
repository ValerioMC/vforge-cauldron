package io.vforge.cauldron.model.primary.ids;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "MIGRATED_ITEM")
public class MigratedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Builder
    private MigratedItem(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
