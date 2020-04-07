package info.tduty.typetalkserver.service.rest;

import info.tduty.typetalkserver.data.dto.LessonDTO;
import info.tduty.typetalkserver.domain.interactor.LessonInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class LessonController {

    public LessonInteractor lessonInteractor;

    @Autowired
    public LessonController(LessonInteractor lessonInteractor) {
        this.lessonInteractor = lessonInteractor;
    }

    @GetMapping("/lessons")
    public List<LessonDTO> get(Principal principal) {
        return lessonInteractor.getLessons(principal.getName());
    }

    @GetMapping("/lessons/{uuid}")
    public LessonDTO getByLessonId(@PathVariable String uuid, Principal principal) {
        return lessonInteractor.getLessonById(principal.getName(), uuid);
    }
}
