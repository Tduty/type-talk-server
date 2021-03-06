package info.tduty.typetalkserver.service.rest;

import info.tduty.typetalkserver.data.dto.ChatDTO;
import info.tduty.typetalkserver.domain.interactor.ChatInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private ChatInteractor chatInteractor;

    @Autowired
    public ChatController(ChatInteractor chatInteractor) {
        this.chatInteractor = chatInteractor;
    }

    @GetMapping(value = "/")
    public List<ChatDTO> getAll(Principal principal) {
        return chatInteractor.getChats(principal.getName());
    }

    @GetMapping(value = "/teacher")
    public ChatDTO getTeacher(Principal principal) {
        return chatInteractor.getTeacherChat(principal.getName());
    }

    @GetMapping(value = "/class")
    public ChatDTO getClass(Principal principal) {
        return chatInteractor.getClassChat(principal.getName());
    }

    @GetMapping(value = "/lesson/{lesson_id}")
    public List<ChatDTO> getByTaskId(Principal principal,
                                     @PathVariable("lesson_id") String lessonId,
                                     @RequestParam(name = "task_id") String taskId) {
        return chatInteractor.getChatsByTaskId(principal.getName(), lessonId, taskId);
    }
}
