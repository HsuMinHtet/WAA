package miu.edu.waa.Jun_2023.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;

    private String country;
    private String city;
    private String state;
    private String zipCode;

    private CoodinatorDTO coodinatorDTO;
}
