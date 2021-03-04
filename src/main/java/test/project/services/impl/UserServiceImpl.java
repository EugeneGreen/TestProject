package test.project.services.impl;

import org.springframework.stereotype.Service;
import test.project.models.RequestDTO;
import test.project.models.ResponseDTO;
import test.project.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private static ResponseDTO response = new ResponseDTO("Test Testov");

    @Override
    public ResponseDTO findUserById(RequestDTO request) {
        if (request.getId() == 1) return response;
        return null;
    }
}
