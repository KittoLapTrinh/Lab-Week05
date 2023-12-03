package fit.iuh.edu.vn.entities;



import fit.iuh.edu.vn.emums.SkillLevel;
import fit.iuh.edu.vn.ids.JobSkillID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_skill")
@IdClass(value = JobSkillID.class)
@NoArgsConstructor
public class JobSkill {

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;



    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;


    @Column(name = "skill_level")
    private SkillLevel SkllLevel;

    @Column(name = "more_infos")
    private String moreInfor;

    public JobSkill(Skill skill) {
        this.skill = skill;
    }

    public JobSkill(Skill skill, SkillLevel skllLevel, String moreInfor) {
        this.skill = skill;
        SkllLevel = skllLevel;
        this.moreInfor = moreInfor;
    }

    public JobSkill(Job job, Skill skill, SkillLevel skllLevel, String moreInfor) {
        this.job = job;
        this.skill = skill;
        SkllLevel = skllLevel;
        this.moreInfor = moreInfor;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public SkillLevel getSkllLevel() {
        return SkllLevel;
    }

    public void setSkllLevel(SkillLevel skllLevel) {
        SkllLevel = skllLevel;
    }

    public String getMoreInfor() {
        return moreInfor;
    }

    public void setMoreInfor(String moreInfor) {
        this.moreInfor = moreInfor;
    }
}
