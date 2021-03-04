package test.project.services;

import test.project.models.RequestDTO;
import test.project.models.ResponseDTO;

public interface LoggerService {
    void logMainController(RequestDTO request, ResponseDTO response);
}
