package br.com.gft.wa.opening.domain.opening;

import br.com.gft.wa.opening.domain.BusinessException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpeningRepository extends JpaRepository<Opening, Long> {

    default Opening getOne(Long id) {
        return findById(id).orElseThrow(() -> new BusinessException("Vaga de id " + id + " não encontrada"));
    }

}
