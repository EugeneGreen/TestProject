package test.project.services;

import test.project.models.RequestDTO;
import test.project.models.ResponseDTO;

public interface UserService {
    ResponseDTO findUserById(RequestDTO request);
}
