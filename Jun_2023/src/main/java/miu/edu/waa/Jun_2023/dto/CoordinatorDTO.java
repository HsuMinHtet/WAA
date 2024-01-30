package miu.edu.waa.Jun_2023.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatorDTO {
    private Long id;
    private String name;
    private String gender;

    private AddressDTO addressDTO;

    private List<EventDTO> eventDTOList= new ArrayList<>();
}
