package br.com.gft.wa.manager.service;

import br.com.gft.wa.manager.domain.employee.Employee;
import br.com.gft.wa.manager.domain.employee.EmployeeRepository;
import br.com.gft.wa.manager.domain.wa.WaControl;
import br.com.gft.wa.manager.domain.wa.WaControlRepository;
import br.com.gft.wa.manager.request.ProposeEmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public class ProposeEmployee {

    private final WaControlRepository waControlRepository;

    private final EmployeeRepository employeeRepository;

    public ProposeEmployee(WaControlRepository waControlRepository, EmployeeRepository employeeRepository) {
        this.waControlRepository = waControlRepository;
        this.employeeRepository = employeeRepository;
    }

    public void propose(ProposeEmployeeRequest request) {
        WaControl waControl = waControlRepository.getOne(request.getWaControlId());
        Employee user = employeeRepository.getOne(request.getUserId());
        waControl.propose(request.getProject(), request.getOpportunity(), user);
    }
}
