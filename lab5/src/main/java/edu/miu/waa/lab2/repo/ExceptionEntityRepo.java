package edu.miu.waa.lab2.repo;

import edu.miu.waa.lab2.domain.Exceptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionEntityRepo extends JpaRepository<Exceptions, Long> {
}
