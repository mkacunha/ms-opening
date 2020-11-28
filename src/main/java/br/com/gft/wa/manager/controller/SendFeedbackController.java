package br.com.gft.wa.manager.controller;

import br.com.gft.wa.manager.domain.feedback.Feedback;
import br.com.gft.wa.manager.request.SendFeedbackRequest;
import br.com.gft.wa.manager.service.NotifyWaEmployee;
import br.com.gft.wa.manager.service.NotifyWaStaff;
import br.com.gft.wa.manager.service.SendFeedback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class SendFeedbackController {

    private final SendFeedback sendFeedback;

    private final NotifyWaStaff notifyWaStaff;

    private final NotifyWaEmployee notifyWaEmployee;

    public SendFeedbackController(SendFeedback sendFeedback, NotifyWaStaff notifyWaStaff, NotifyWaEmployee notifyWaEmployee) {
        this.sendFeedback = sendFeedback;
        this.notifyWaStaff = notifyWaStaff;
        this.notifyWaEmployee = notifyWaEmployee;
    }

    @Transactional
    @PostMapping("/manager/send-feedback")
    public void send(@RequestBody @NotNull @Valid SendFeedbackRequest request) {
        Feedback feedback = sendFeedback.send(request);
        notifyWaStaff.notify(feedback);
        notifyWaEmployee.notify(feedback);
    }


}
