package miu.edu.waa.midTerm.Jan2023.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
    private String city;
    private String state;
    private String zipCode;
    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Employee employee;
}

