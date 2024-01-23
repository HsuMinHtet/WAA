package miu.edu.waa.Jun_2023.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.waa.Jun_2023.domain.Coordinator;
import miu.edu.waa.Jun_2023.domain.Task;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private Long id;

    private String title;

    private String state;

    private List<CoodinatorDTO> coodinatorDTOList= new ArrayList<>();

    private List<TaskDTO> taskDTOList;
}
