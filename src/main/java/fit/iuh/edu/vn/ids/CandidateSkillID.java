package fit.iuh.edu.vn.ids;


import fit.iuh.edu.vn.entities.Candidate;
import fit.iuh.edu.vn.entities.Skill;

import java.io.Serializable;

public class CandidateSkillID implements Serializable {

    private Skill skill;
    private Candidate candidate;
}
