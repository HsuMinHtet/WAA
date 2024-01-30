package miu.edu.waa.Jun_2023.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id")
    private Long id;

    private String title;

    private String state;

    @ManyToMany(mappedBy = "eventList")
    @JsonBackReference
    private List<Coordinator> coordinatorList= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
   // @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name ="event_id" )
    @BatchSize(size = 2)
    @JsonManagedReference
    private List<Task> taskList= new ArrayList<>();
}
