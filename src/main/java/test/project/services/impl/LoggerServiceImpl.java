package test.project.services.impl;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.project.controllers.MainController;
import test.project.models.RequestDTO;
import test.project.models.ResponseDTO;
import test.project.services.CryptService;
import test.project.services.LoggerService;

@Service
public class LoggerServiceImpl implements LoggerService {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private final CryptService cryptService;

    public LoggerServiceImpl(CryptService cryptService) {
        this.cryptService = cryptService;
    }

    @Override
    public void logMainController(RequestDTO request, ResponseDTO response) {
        Gson gson = new Gson();
        String requestToString = gson.toJson(request);
        String responseToString = gson.toJson(response);
        String requestEncrypt = cryptService.encryptMessage(requestToString);
        String responseEncrypt = cryptService.encryptMessage(responseToString);
        logger.info("Request: " + requestToString);
        logger.info("=== encryption: " + requestEncrypt);
        logger.info("=== decryption: " + cryptService.decryptMessage(requestEncrypt));
        logger.info("Response: " + responseToString);
        logger.info("=== encryption: " + responseEncrypt);
        logger.info("=== decryption: " + cryptService.decryptMessage(responseEncrypt));
    }
}
