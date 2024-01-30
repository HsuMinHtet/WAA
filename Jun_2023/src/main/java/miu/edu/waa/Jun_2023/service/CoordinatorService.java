package miu.edu.waa.Jun_2023.service;

import miu.edu.waa.Jun_2023.domain.Coordinator;
import miu.edu.waa.Jun_2023.domain.Event;
import miu.edu.waa.Jun_2023.domain.Task;
import miu.edu.waa.Jun_2023.dto.CoordinatorDTO;

import java.util.List;


public interface CoordinatorService {
    void createCoordinator(CoordinatorDTO coordinatorDTO);

    List<Coordinator> findAll();

    Coordinator findById(Long id);

    void deleteById(Long id);

    void updateById(Long id, Coordinator coordinator);

    List<Event> searchEventByCoordinator(Long id);

    List<Task> searchTaskByCoordinator(Long id);

    List<Coordinator> searchCoordinatorsEventOutOfState();

    List<Coordinator> searchCoordinatorsByNameANDGender(String name, String gender);

    List<Coordinator> searchCoordinatorsByNameORGender(String name, String gender);
}
