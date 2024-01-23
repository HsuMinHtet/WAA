package edu.miu.waa.lab2.repo;

import edu.miu.waa.lab2.domain.ExceptionsTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ExceptionsTableRepo extends JpaRepository<ExceptionsTable,Long> {
//    @Modifying
//    @Query(value = "INSERT INTO exceptions_table (date, time, principle, operation, type) " +
//            "VALUES (:date, :time, :principle, :operation, :type)", nativeQuery = true)
//    void insertExceptions(@Param("date") LocalDate date,
//                          @Param("time") LocalTime time,
//                          @Param("principle") String principle,
//                          @Param("operation") String operation,
//                          @Param("type") String type);
}
