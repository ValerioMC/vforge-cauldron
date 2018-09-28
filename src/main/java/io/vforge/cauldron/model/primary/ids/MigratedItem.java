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
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="ADDR_ID", referencedColumnName="ID"),
            @JoinColumn(name="ADDR_ZIP", referencedColumnName="ZIP")
    })
    private String description;

    @Builder
    private MigratedItem(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
