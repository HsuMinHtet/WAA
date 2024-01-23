package miu.edu.waa.Jun_2023.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="Coordinators_Events",
            joinColumns = {@JoinColumn(name="co_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")}
    )
    private List<Event> eventList= new ArrayList<>();
}
