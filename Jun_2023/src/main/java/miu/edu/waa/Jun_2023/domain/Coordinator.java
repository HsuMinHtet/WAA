package miu.edu.waa.Jun_2023.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="co_id")
    private Long id;

    private String name;
    private String gender;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="address_id")
    @JsonManagedReference
    private Address address;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="Coordinators_Events",
            joinColumns = {@JoinColumn(name="co_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")}
    )
    @JsonManagedReference
    private List<Event> eventList= new ArrayList<>();
}
