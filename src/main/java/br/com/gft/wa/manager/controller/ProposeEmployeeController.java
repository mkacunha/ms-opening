package br.com.gft.wa.manager.controller;

import br.com.gft.wa.manager.request.ProposeEmployeeRequest;
import br.com.gft.wa.manager.service.ProposeEmployee;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class ProposeEmployeeController {

    private final ProposeEmployee proposeEmployee;

    public ProposeEmployeeController(ProposeEmployee proposeEmployee) {
        this.proposeEmployee = proposeEmployee;
    }

    @Transactional
    @PostMapping("/manager/propose")
    public void propose(@RequestBody @NotNull @Valid ProposeEmployeeRequest request) {
        proposeEmployee.propose(request);
    }

}
