package br.com.gft.wa.manager.controller;

import br.com.gft.wa.manager.request.ReserveEmployeeRequest;
import br.com.gft.wa.manager.service.ReserveEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class ReserveEmployeeController {

    @Autowired
    private final ReserveEmployee reserveEmployee;

    public ReserveEmployeeController(ReserveEmployee reserveEmployee) {
        this.reserveEmployee = reserveEmployee;
    }

    @Transactional
    @PostMapping("/manager/reserve")
    public void reserve(@RequestBody @Valid @NotNull ReserveEmployeeRequest request) {
        reserveEmployee.reserve(request);
    }
}
