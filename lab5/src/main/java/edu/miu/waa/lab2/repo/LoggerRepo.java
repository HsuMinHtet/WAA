package edu.miu.waa.lab2.repo;

import edu.miu.waa.lab2.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger, Long> {
}
