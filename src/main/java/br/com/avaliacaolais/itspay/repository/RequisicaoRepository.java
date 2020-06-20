package br.com.avaliacaolais.itspay.repository;

import br.com.avaliacaolais.itspay.entity.RequisicaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoRepository extends JpaRepository<RequisicaoEntity, Long> {
}
