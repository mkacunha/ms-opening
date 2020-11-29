package br.com.gft.wa.opening.service;

import br.com.gft.wa.opening.domain.employee.Employee;
import br.com.gft.wa.opening.domain.employee.EmployeeRepository;
import br.com.gft.wa.opening.domain.opening.Opening;
import br.com.gft.wa.opening.domain.opening.OpeningRepository;
import br.com.gft.wa.opening.request.NewOpeningRequest;
import org.springframework.stereotype.Service;

@Service
public class NewOpening {

    private final EmployeeRepository employeeRepository;

    private final OpeningRepository openingRepository;

    public NewOpening(EmployeeRepository employeeRepository, OpeningRepository openingRepository) {
        this.employeeRepository = employeeRepository;
        this.openingRepository = openingRepository;
    }

    public void newOpening(NewOpeningRequest request) {
        Employee employee = employeeRepository.getOne(request.getUserId());
        Opening opening = new Opening(
                request.getName(),
                request.getHiringDate(),
                request.getPriority(),
                request.getActivities(),
                request.getRequirements(),
                request.getDesirable(),
                request.getCustomer(),
                employee,
                request.getKnowledge()
        );
        openingRepository.save(opening);
    }


}
