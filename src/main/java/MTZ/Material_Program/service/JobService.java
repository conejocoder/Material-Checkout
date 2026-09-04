package MTZ.Material_Program.service;

import MTZ.Material_Program.Job;
import MTZ.Material_Program.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class JobService {

    private JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(Long id){
        return jobRepository.findById(id);
    }

    public Job createJob(Job job){
        return jobRepository.save(job);
    }

    public Optional<Job> updateJob(Long id, Job jobDetails){
        return jobRepository.findById(id)
        .map(existingJob ->{
            existingJob.setJobNumber(jobDetails.getJobNumber());
            existingJob.setName(jobDetails.getName());
            existingJob.setAddress(jobDetails.getAddress());
            existingJob.setSquareFootage(jobDetails.getSquareFootage());

            return jobRepository.save(existingJob);
        });
    }

       public boolean deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            return false;
        }

        jobRepository.deleteById(id);
        return true;
    }
    
}
