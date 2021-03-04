package test.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.project.models.RequestDTO;
import test.project.models.ResponseDTO;
import test.project.services.LoggerService;
import test.project.services.UserService;

@RestController()
@RequestMapping()
public class MainController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final LoggerService loggerService;

    public MainController(UserService userService, LoggerService loggerService) {
        this.userService = userService;
        this.loggerService = loggerService;
    }

    @PostMapping(path = "fio/",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO findFioById(@RequestBody RequestDTO request) {
        ResponseDTO response = userService.findUserById(request);
        loggerService.logMainController(request, response);
        return response;
    }
}
