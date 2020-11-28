package br.com.gft.wa.manager.service;

import br.com.gft.wa.manager.domain.feedback.Feedback;
import org.springframework.stereotype.Service;

@Service
public class NotifyWaStaff {
    public void notify(Feedback feedback) {
        System.out.println("notificar staff novo WA");
    }
}
