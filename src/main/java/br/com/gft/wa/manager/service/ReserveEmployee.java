package br.com.gft.wa.manager.service;

import br.com.gft.wa.manager.domain.employee.Employee;
import br.com.gft.wa.manager.domain.employee.EmployeeRepository;
import br.com.gft.wa.manager.domain.wa.WaControl;
import br.com.gft.wa.manager.domain.wa.WaControlRepository;
import br.com.gft.wa.manager.request.ReserveEmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public class ReserveEmployee {

    private final WaControlRepository waControlRepository;

    private final EmployeeRepository employeeRepository;

    public ReserveEmployee(WaControlRepository waControlRepository, EmployeeRepository employeeRepository) {
        this.waControlRepository = waControlRepository;
        this.employeeRepository = employeeRepository;
    }

    public void reserve(ReserveEmployeeRequest request) {
        WaControl waControl = waControlRepository.getOne(request.getWaControlId());
        Employee employee = employeeRepository.getOne(request.getUserId());
        waControl.reserve(request.getProject(), request.getReservation(), request.getAmountDays(), employee);
    }
}
