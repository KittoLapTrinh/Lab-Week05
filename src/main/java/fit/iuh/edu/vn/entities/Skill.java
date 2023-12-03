package fit.iuh.edu.vn.entities;


import fit.iuh.edu.vn.emums.SkillType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@EqualsAndHashCode(of={"id"})
@Table(name="skill")
@NoArgsConstructor
@AllArgsConstructor
public class Skill {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long id;

    private String skill_name;

    private String skill_desc;

    private SkillType type;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<JobSkill> jobSkills;

    public Skill(long id) {
        this.id = id;
    }

//constructor


    public Skill(String skill_name, String skill_desc, SkillType type) {
        this.skill_name = skill_name;
        this.skill_desc = skill_desc;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getSkill_desc() {
        return skill_desc;
    }

    public void setSkill_desc(String skill_desc) {
        this.skill_desc = skill_desc;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public List<JobSkill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<JobSkill> jobSkills) {
        this.jobSkills = jobSkills;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skill_name='" + skill_name + '\'' +
                ", skill_desc='" + skill_desc + '\'' +
                ", type=" + type +
                ", jobSkills=" + jobSkills +
                '}';
    }
}
