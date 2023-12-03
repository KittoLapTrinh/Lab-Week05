package fit.iuh.edu.vn.repositories;

import fit.iuh.edu.vn.entities.JobSkill;
import fit.iuh.edu.vn.ids.JobSkillID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillID> {
}