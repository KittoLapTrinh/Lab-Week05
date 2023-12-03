package fit.iuh.edu.vn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Experience")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;


    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;


    private String company;
    private String role;

    @Column(name = "work_desc")
    private String workDescription;

    public Experience(LocalDate fromDate, LocalDate toDate, Candidate candidate, String companyName, String role, String workDescription) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.candidate = candidate;
        this.company = companyName;
        this.role = role;
        this.workDescription = workDescription;
    }
}
