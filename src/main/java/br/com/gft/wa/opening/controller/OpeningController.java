package br.com.gft.wa.opening.controller;

import br.com.gft.wa.opening.domain.opening.OpeningRepository;
import br.com.gft.wa.opening.request.NewOpeningRequest;
import br.com.gft.wa.opening.request.UpdateOpeningRequest;
import br.com.gft.wa.opening.response.OpeningResponse;
import br.com.gft.wa.opening.response.OpeningSummaryResponse;
import br.com.gft.wa.opening.service.NewOpening;
import br.com.gft.wa.opening.service.UpdateOpening;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RestController
public class OpeningController {

    private final NewOpening newOpening;

    private final OpeningRepository openingRepository;

    private final UpdateOpening updateOpening;

    public OpeningController(NewOpening newOpening, OpeningRepository openingRepository, UpdateOpening updateOpening) {
        this.newOpening = newOpening;
        this.openingRepository = openingRepository;
        this.updateOpening = updateOpening;
    }

    @PostMapping("/openings")
    public void post(@RequestBody @NotNull @Valid NewOpeningRequest request) {
        newOpening.newOpening(request);
    }

    @GetMapping("/openings")
    public List<OpeningSummaryResponse> getAll() {
        return openingRepository.findAll().stream().map(OpeningSummaryResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/openings/{id}")
    public OpeningResponse get(@PathVariable("id") Long id) {
        return new OpeningResponse(openingRepository.getOne(id));
    }

    @PutMapping("/openings/{id}")
    public OpeningResponse update(@PathVariable("id") Long id, @RequestBody @NotNull @Valid UpdateOpeningRequest request) {
        return new OpeningResponse(updateOpening.update(id, request));
    }
}
