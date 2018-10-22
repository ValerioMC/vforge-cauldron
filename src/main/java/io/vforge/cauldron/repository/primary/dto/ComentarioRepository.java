package io.vforge.cauldron.repository.primary.dto;

import io.vforge.cauldron.model.primary.dtoout.ComentarioEdital;
import io.vforge.cauldron.model.primary.dtoout.ComentarioEditalDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends CrudRepository<ComentarioEdital, Long> {

    @Query(value = "SELECT new io.vforge.cauldron.model.primary.dtoout.ComentarioEditalDto(c.id, c.texto, c.dataCriacao, c.dataUltimaEdicao, c.excluida) " +
            "FROM ComentarioEdital c")
    public List<ComentarioEditalDto> findAllByEdital(@Param("numero") String nuEdital);

}
