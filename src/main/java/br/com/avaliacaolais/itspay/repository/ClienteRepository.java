package br.com.avaliacaolais.itspay.repository;

import br.com.avaliacaolais.itspay.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    @Query(value="SELECT cliente FROM ClienteEntity cliente WHERE cliente.cpf =:cpf")
    Optional<ClienteEntity> findByCPF(@Param("cpf") String cpf);
}