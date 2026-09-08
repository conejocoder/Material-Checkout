package MTZ.Material_Program.controller;

import MTZ.Material_Program.Job;
import MTZ.Material_Program.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;





@RestController
@RequestMapping("/api/jobs")
public class JobController {


    private final JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Job> getJobById(@PathVariable Long id){
        return jobService.getJobById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Job createJob(@RequestBody Job job){

        return jobService.createJob(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job jobDetails){


        return jobService.updateJob(id, jobDetails)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteJob(@PathVariable Long id){
        if (!jobService.deleteJob(id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();

    }
}
