package edu.miu.waa.lab2.service;

import java.time.LocalDate;
import java.time.LocalTime;

public interface LoggerService {
    void logOperation(String principle, String operation, LocalDate date, LocalTime time);

    void logException(String principle, String operation, String type, LocalDate date, LocalTime time);
}
