package miu.edu.waa.Jun_2023.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private Long id;

    private String country;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Coordinator coordinator;

}
