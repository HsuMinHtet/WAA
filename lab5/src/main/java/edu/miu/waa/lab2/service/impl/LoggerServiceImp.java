package edu.miu.waa.lab2.service.impl;

import edu.miu.waa.lab2.domain.Exceptions;
import edu.miu.waa.lab2.domain.Logger;
import edu.miu.waa.lab2.repo.ExceptionEntityRepo;
import edu.miu.waa.lab2.repo.LoggerRepo;
import edu.miu.waa.lab2.service.LoggerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@Transactional
@RequiredArgsConstructor
public class LoggerServiceImp implements LoggerService {

    private final LoggerRepo loggerRepo;
    private final ExceptionEntityRepo exceptionEntityRepo;

    @Override
    public void logOperation(String principle, String operation, LocalDate date, LocalTime time) {
        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        logger.setPrinciple(principle);
        logger.setOperation(operation);
        loggerRepo.save(logger);
    }

    @Override
    @Transactional
    public void logException(String principle, String operation, String type, LocalDate date, LocalTime time) {
        Exceptions exceptions = new Exceptions();
        exceptions.setDate(LocalDate.now());
        exceptions.setTime(LocalTime.now());
        exceptions.setPrinciple(principle);
        exceptions.setOperation(operation);
        exceptions.setType(type);
        System.out.println("<<<<Exception>>>>Before Repo" + exceptions);
        exceptionEntityRepo.save(exceptions);
    }

}
