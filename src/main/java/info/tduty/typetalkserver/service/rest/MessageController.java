package info.tduty.typetalkserver.service.rest;

import info.tduty.typetalkserver.data.dto.MessageDTO;
import info.tduty.typetalkserver.domain.interactor.HistoryInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class MessageController {

    private HistoryInteractor historyInteractor;

    @Autowired
    public MessageController(HistoryInteractor historyInteractor) {
        this.historyInteractor = historyInteractor;
    }

    @GetMapping(value = "/history")
    public List<MessageDTO> getAll(Principal principal) {
        return historyInteractor.getAll(principal.getName());
    }

    @GetMapping(value = "/history/{chatId}")
    public List<MessageDTO> getByChatId(@PathVariable String chatId) {
        return historyInteractor.get(chatId);
    }
}
