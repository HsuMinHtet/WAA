package miu.edu.waa.Jun_2023.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.waa.Jun_2023.domain.Coordinator;
import miu.edu.waa.Jun_2023.domain.Event;
import miu.edu.waa.Jun_2023.domain.Task;
import miu.edu.waa.Jun_2023.dto.CoordinatorDTO;
import miu.edu.waa.Jun_2023.service.CoordinatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/coordinators")
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    @PostMapping
    private void createCoordinator(@RequestBody CoordinatorDTO
                                           coordinatorDTO) {
        coordinatorService.createCoordinator(coordinatorDTO);
    }

    @GetMapping
    private List<Coordinator> findAll() {
        return coordinatorService.findAll();
    }

    @GetMapping("/{id}")
    private Coordinator findById(@PathVariable Long id) {
        return coordinatorService.findById(id);
    }

    @DeleteMapping("/{id}")
    private void deleteById(@PathVariable Long id) {
        coordinatorService.deleteById(id);
    }

    @PutMapping("/{id}")
    private void updateById(@PathVariable Long id, @RequestBody Coordinator coordinator) {
        coordinatorService.updateById(id, coordinator);
    }

    @GetMapping("/{id}/events")
    private List<Event> searchEventByCoordinator(@PathVariable Long id) {
        return coordinatorService.searchEventByCoordinator(id);
    }

    @GetMapping("/{id}/tasks")
    private List<Task> searchTaskByCoordinator(@PathVariable Long id) {
        return coordinatorService.searchTaskByCoordinator(id);
    }

    @GetMapping("/event-out-state")
    private List<Coordinator> searchCoordinatorsEventOutOfState() {
        return coordinatorService.searchCoordinatorsEventOutOfState();
    }

    @GetMapping("/filter/")
    private List<Coordinator> searchCoordinatorsByCriteria(@RequestParam(value = "name", required = false) String name,
                                                           @RequestParam(value = "gender", required = false) String gender) {
        List<Coordinator> coordinators;
        if (!name.isEmpty() && !gender.isEmpty()) {
            System.out.println("AND Check" + name + "and" + gender);
            coordinators = coordinatorService.searchCoordinatorsByNameANDGender(name, gender);
        } else {
            System.out.println("OR Check" + name + "and" + gender);
            coordinators = coordinatorService.searchCoordinatorsByNameORGender(name, gender);
        }
        return coordinators;
    }


}

