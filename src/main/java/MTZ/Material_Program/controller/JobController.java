package MTZ.Material_Program.controller;

import MTZ.Material_Program.Job;
import MTZ.Material_Program.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/jobs")
public class JobController {

    private final MTZ.Material_Program.repository.JobRepository jobRepository;
    private final JobService jobService;

    public JobController(JobService jobService, MTZ.Material_Program.repository.JobRepository jobRepository){
        this.jobService = jobService;
        this.jobRepository = jobRepository;
    }

    @GetMapping
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        return jobService.getJobById(id)
    }
    



    
}
