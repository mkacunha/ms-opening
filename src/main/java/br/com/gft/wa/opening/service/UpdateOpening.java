package br.com.gft.wa.opening.service;

import br.com.gft.wa.opening.domain.opening.Opening;
import br.com.gft.wa.opening.domain.opening.OpeningRepository;
import br.com.gft.wa.opening.request.UpdateOpeningRequest;
import org.springframework.stereotype.Service;

@Service
public class UpdateOpening {

    private final OpeningRepository openingRepository;

    public UpdateOpening(OpeningRepository openingRepository) {
        this.openingRepository = openingRepository;
    }

    public Opening update(Long id, UpdateOpeningRequest request) {
        Opening opening = openingRepository.getOne(id);
        opening.update(request);
        return openingRepository.save(opening);
    }


}
