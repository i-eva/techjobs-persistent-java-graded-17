package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	    model.addAttribute("title", "Add Job");
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob, Errors errors, Model model, @RequestParam (required = false) Integer employerId) {
        if (errors.hasErrors()) {
	        model.addAttribute("title", "Add Job");
            return "add";
        } else {
            if (employerId == null) {
                model.addAttribute("title", "All Jobs");
                model.addAttribute("jobs", jobRepository.findAll());
                return "add";
            } else {
                Optional<Employer> optionalEmployer = employerRepository.findById(employerId);
                if (optionalEmployer.isEmpty()) {
                    model.addAttribute("title", "Invalid Employer ID: " + employerId);
                    return "add";
                } else {
                    Employer employer = optionalEmployer.get();
                    model.addAttribute("title", "Jobs at employer: " +employer.getName());
                    model.addAttribute("title", employer.getJobs());
                    newJob.setEmployer(employer);
                    jobRepository.save(newJob);
                }
            }
            return "redirect:";
        }

    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

            return "view";
    }

}
