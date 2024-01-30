package miu.edu.waa.Jun_2023.repo;

import miu.edu.waa.Jun_2023.domain.Coordinator;
import miu.edu.waa.Jun_2023.domain.Event;
import miu.edu.waa.Jun_2023.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoordinatorRepo extends JpaRepository<Coordinator,Long> {

    @Query(value = "select c from Coordinator c join c.eventList e where e.state != c.address.state")
    List<Coordinator> searchCoordinatorsEventOutOfState();

    @Query(value="select t from Task t join t.event e join e.coordinatorList c where c.id=:id")
    List<Task> searchTaskByCoordinator(Long id);

    @Query(value = "select e from Event e join e.coordinatorList c where c.id=:id")
    List<Event> searchEventByCoordinator(Long id);

    @Query(value = "select c from Coordinator c where c.name=:name AND c.gender=:gender")
    List<Coordinator> searchCoordinatorsByNameANDGender(String name, String gender);

    @Query(value = "select c from Coordinator c where c.name=:name OR c.gender=:gender")
    List<Coordinator> searchCoordinatorsByNameORGender(String name, String gender);
}
