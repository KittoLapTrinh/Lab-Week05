package fit.iuh.edu.vn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name="job")
@NoArgsConstructor
@AllArgsConstructor

public class Job {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private long id;


    @ManyToOne
    @JoinColumn(name = "com_id")
    private Company company;

    private String job_desc;

    private String job_name;




    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<JobSkill> jobSkills;

    public Job(Company company, String job_desc, String job_name, List<JobSkill> jobSkills) {
        this.company = company;
        this.job_desc = job_desc;
        this.job_name = job_name;
        this.jobSkills = jobSkills;
    }

    public Job(Company company, String job_desc, String job_name) {
        this.company = company;
        this.job_desc = job_desc;
        this.job_name = job_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJob_desc() {
        return job_desc;
    }

    public void setJob_desc(String job_desc) {
        this.job_desc = job_desc;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public List<JobSkill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<JobSkill> jobSkills) {
        this.jobSkills = jobSkills;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", company=" + company +
                ", job_desc='" + job_desc + '\'' +
                ", job_name='" + job_name + '\'' +
                ", jobSkills=" + jobSkills +
                '}';
    }
}
