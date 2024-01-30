package miu.edu.waa.Jun_2023.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatorRequest {
    private Long id;
    private String name;
    private String gender;
}
