package fit.iuh.edu.vn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Candidate")
@EqualsAndHashCode(of={"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "can_id")

    private long id;
    private String phone;
    private LocalDate dod;
    private String email;

    @Column(name = "full_name")
    private String fullname;

    @OneToOne
    @JoinColumn(name = "add_id")
    private Address address;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CandidateSkill> candidateSkills;

    public Candidate(String phone, LocalDate dod, String email, String fullname, Address address, List<Experience> experiences) {
        this.phone = phone;
        this.dod = dod;
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.experiences = experiences;
    }

    public Candidate(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<CandidateSkill> getCandidateSkills() {
        return candidateSkills;
    }

    public void setCandidateSkills(List<CandidateSkill> candidateSkills) {
        this.candidateSkills = candidateSkills;
    }
}
