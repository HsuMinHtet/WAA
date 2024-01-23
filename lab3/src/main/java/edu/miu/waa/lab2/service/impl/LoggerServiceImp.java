package edu.miu.waa.lab2.service.impl;

import edu.miu.waa.lab2.domain.ExceptionsTable;
import edu.miu.waa.lab2.domain.Logger;
import edu.miu.waa.lab2.repo.ExceptionsTableRepo;
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
    private final ExceptionsTableRepo exceptionsRepo;

    @Override
    public void logOperation(String principle, String operation,LocalDate date, LocalTime time) {
        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        logger.setPrinciple(principle);
        logger.setOperation(operation);
        System.out.println("<<<<for Logger"+ logger);
        loggerRepo.save(logger);
    }

    @Override
    public void logException(String principle, String operation, String type, LocalDate date, LocalTime time) {
        ExceptionsTable exceptions = new ExceptionsTable();
        exceptions.setDate(LocalDate.now());
        exceptions.setTime(LocalTime.now());
        exceptions.setPrinciple(principle);
        exceptions.setOperation(operation);
        exceptions.setType(type);
        System.out.println("<<<<<Before ExceptionEntityRepo :"+ exceptions);
        ExceptionsTable e= exceptionsRepo.save(exceptions);
        System.out.println("result: "+ e);
    }

}
