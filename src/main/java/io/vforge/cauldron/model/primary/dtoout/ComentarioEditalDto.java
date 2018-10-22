package io.vforge.cauldron.model.primary.dtoout;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ComentarioEditalDto {

    private Long id;
    private String texto;
    private Calendar dataCriacao;
    private Calendar dataUltimaEdicao;
    private List<ComentarioEdital> respostasComentario;
    private Boolean excluida;

    public ComentarioEditalDto(Long id, String texto, Calendar dataCriacao, Calendar dataUltimaEdicao, Boolean excluida) {
        this.id = id;
        this.texto = texto;
        this.dataCriacao = dataCriacao;
        this.dataUltimaEdicao = dataUltimaEdicao;
        this.excluida = excluida;
    }
}