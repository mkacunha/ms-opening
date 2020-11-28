package br.com.gft.wa.manager.domain.wa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WaControlRepository extends JpaRepository<WaControl, Long> {

    default WaControl getOne(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Controle de WA de id " + id + " não encontrado"));
    }
}
