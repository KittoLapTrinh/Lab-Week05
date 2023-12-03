package fit.iuh.edu.vn.controllers;

import fit.iuh.edu.vn.emums.SkillLevel;
import fit.iuh.edu.vn.emums.SkillType;
import fit.iuh.edu.vn.entities.*;
import fit.iuh.edu.vn.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class Allcontroller {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SkillRepository skillRepository;


    @Autowired
    private JobSkillRepository jobSkillRepository;

    @Autowired
    private CandidateRepository candidateRepository;
    @GetMapping("/getCompany")
    public String allCompany(Model model) {
        model.addAttribute("companies",companyRepository.findAll());
        return "company/companies";
    }

    @GetMapping("/getcandidate")

    public String JobCandidate( Model model ){

        model.addAttribute("companies",companyRepository.findAll());
        model.addAttribute("candidate",candidateRepository.findById(1L).get());

        return "candidate/apply";
    }


    @GetMapping("/getcandidate/{id}")

    public String showJobForCandidateBySkill(@PathVariable("id") long id, Model model ){

        Candidate candidate = candidateRepository.findById(id).get();
        List<Company> companies = companyRepository.findAll();
        List<Company> companiesByJob  = new ArrayList<>();
        for (Company company:companies) {
            ArrayList<Job> newJob  =new ArrayList<>();
            List<Job> jobs = company.getJobs();
            for (Job  job:jobs) {
                List<JobSkill> jobSkills =job.getJobSkills();
                for (JobSkill jobSkill:jobSkills) {
                    for (CandidateSkill candidateSkill:candidate.getCandidateSkills()) {
                            if(candidateSkill.getSkill().getId()==jobSkill.getSkill().getId())
                            {
                                System.out.println("al0:"+candidateSkill.getSkill().getSkill_name());
                                 newJob.add(job);

                            }
                    }
                }

            }
            company.setJobs(newJob);
            companiesByJob.add(company);
        }

        model.addAttribute("companies",companies);
        model.addAttribute("candidate",candidateRepository.findById(1L).get());

        return "candidate/applyJobSkill";
    }
    @GetMapping("/companyrecruitment/{id}")

    public String companyrecruitment( @PathVariable("id") long id, Model model,Job job,Skill skill) {
        System.out.println(companyRepository.findById(id));
        model.addAttribute("company",companyRepository.findById(id).get());
        model.addAttribute("skills",skillRepository.findAll());
        System.out.println(jobRepository.findAll().get(0).getJobSkills().get(0).getSkill().getSkill_name());
        return "company/post";
    }

    @PostMapping("/job/company/{id}")
    public String addJob( @RequestParam("skills") long skillID,@ModelAttribute Job job, @PathVariable("id") long id, Model model) {
        Optional<Company> optionalCompany = companyRepository.findById(id);

              System.out.println(skillID);
            Company company = optionalCompany.get();

            job.setCompany(company); // Associate the job with the company


           Job jobNew= jobRepository.save(new Job(company,job.getJob_desc(),job.getJob_name()));
            jobSkillRepository.save(new JobSkill(jobNew,skillRepository.findById(skillID).get(), SkillLevel.ADVANCED,"NEW job"+jobNew.getId()));
            return "redirect:"+"/companyrecruitment/"+id;


    }
    @PostMapping("/job/company/skill/{id}")
    public String addSkill(@RequestParam("typeSkill") int valueType,@PathVariable("id") long id,@ModelAttribute Skill skill ,Model model) {


        SkillType skillType;
        System.out.println(valueType);
        if(valueType==0)
        {
            skillType=SkillType.TECHNICAL_SKILL;
        }else if(valueType==1)
        {
            skillType=SkillType.UNSPECIFC;
        }else {
            skillType=SkillType.SOFT_SKILL;
        }
        skillRepository.save(new Skill(skill.getSkill_name(),skill.getSkill_desc(),skillType));
        return "redirect:"+"/companyrecruitment/"+id;
    }
}

