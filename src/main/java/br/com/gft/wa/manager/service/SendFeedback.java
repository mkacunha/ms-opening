package br.com.gft.wa.manager.service;

import br.com.gft.wa.manager.domain.employee.Employee;
import br.com.gft.wa.manager.domain.employee.EmployeeRepository;
import br.com.gft.wa.manager.domain.feedback.Feedback;
import br.com.gft.wa.manager.domain.feedback.FeedbackRepository;
import br.com.gft.wa.manager.request.SendFeedbackRequest;
import org.springframework.stereotype.Service;

@Service
public class SendFeedback {

    private final EmployeeRepository employeeRepository;

    private final FeedbackRepository feedbackRepository;

    public SendFeedback(
            EmployeeRepository employeeRepository,
            FeedbackRepository feedbackRepository
    ) {
        this.employeeRepository = employeeRepository;
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback send(SendFeedbackRequest request) {
        Employee employee = findEmployee(request.getEmployeeId(), Employee.EMPLOYEE);
        Employee manager = findEmployee(request.getManagerId(), Employee.MANAGER);
        Feedback feedback = new Feedback(
                request.getProject(),
                request.getReason(),
                request.getFeedback(),
                request.isWarnedEmployee(),
                request.isRenewing(),
                employee,
                manager);

        return feedbackRepository.save(feedback);
    }

    private Employee findEmployee(Long employeeId, int type) {
        return employeeRepository.findByIdAndType(employeeId, type)
                .orElseThrow(() -> new RuntimeException("Funcionário " + employeeId + " não encontrado"));
    }
}
