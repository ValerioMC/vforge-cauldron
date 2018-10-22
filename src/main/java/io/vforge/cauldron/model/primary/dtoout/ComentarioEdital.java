package io.vforge.cauldron.model.primary.dtoout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "comentario_seq", sequenceName = "comentario_seq")
public class ComentarioEdital implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentario_seq")
    private Long id;
    @NotBlank(message = "Não deve estar vazio")
    private String texto;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar dataUltimaEdicao;
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "respostas_comentario",
            joinColumns = @JoinColumn(name = "pergunta_id"),
            inverseJoinColumns = @JoinColumn(name = "resposta_id"))
    private List<ComentarioEdital> respostasComentario;
    @JsonIgnore
    private Boolean excluida;
}