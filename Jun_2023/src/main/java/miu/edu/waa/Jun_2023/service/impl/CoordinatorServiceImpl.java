package miu.edu.waa.Jun_2023.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import miu.edu.waa.Jun_2023.domain.Coordinator;
import miu.edu.waa.Jun_2023.domain.Event;
import miu.edu.waa.Jun_2023.domain.Task;
import miu.edu.waa.Jun_2023.dto.CoordinatorDTO;
import miu.edu.waa.Jun_2023.repo.CoordinatorRepo;
import miu.edu.waa.Jun_2023.service.CoordinatorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CoordinatorServiceImpl implements CoordinatorService {

    private final ModelMapper modelMapper;

    private final CoordinatorRepo coordinatorRepo;

    @Override
    @Transactional
    public void createCoordinator(CoordinatorDTO coordinatorDTO) {
        coordinatorRepo.save(modelMapper.map(coordinatorDTO,Coordinator.class));
    }

    @Override
    public List<Coordinator> findAll() {
        return coordinatorRepo.findAll();
    }

    @Override
    public Coordinator findById(Long id) {
        return coordinatorRepo.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        coordinatorRepo.deleteById(id);
    }

    @Override
    public void updateById(Long id, Coordinator coordinator) {
        coordinator.setId(id);
        coordinatorRepo.save(coordinator);
    }

    @Override
    public List<Event> searchEventByCoordinator(Long id) {
        return coordinatorRepo.searchEventByCoordinator(id);
    }

    @Override
    public List<Task> searchTaskByCoordinator(Long id) {
        List<Task> task = coordinatorRepo.searchTaskByCoordinator(id);
        return coordinatorRepo.searchTaskByCoordinator(id);
    }

    @Override
    public List<Coordinator> searchCoordinatorsEventOutOfState() {
        return coordinatorRepo.searchCoordinatorsEventOutOfState();
    }

    @Override
    public List<Coordinator> searchCoordinatorsByNameANDGender(String name, String gender) {
        return coordinatorRepo.searchCoordinatorsByNameANDGender(name,gender);
    }

    @Override
    public List<Coordinator> searchCoordinatorsByNameORGender(String name, String gender) {
        return coordinatorRepo.searchCoordinatorsByNameORGender(name,gender);
    }


}
