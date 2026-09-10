package MTZ.Material_Program.service;

import MTZ.Material_Program.Worker;
import MTZ.Material_Program.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository){
        this.workerRepository = workerRepository;
    }

    public List<Worker> getAllWorkers(){
        return workerRepository.findAll();
    }

    public Optional<Worker> getWorkerById(Long id){
        return workerRepository.findById(id);
    }

    public Worker createWorker(Worker worker){
        return workerRepository.save(worker);
    }

    public Optional<Worker> updateWorker(Long id, Worker workerDetails){
        return workerRepository.findById(id)
                .map(existingWorker -> {
                    existingWorker.setName(workerDetails.getName());
                    existingWorker.setEmployeeId(workerDetails.getEmployeeId());

                    return workerRepository.save(existingWorker);
                });
    }

    public boolean deleteWorker(Long id){
        if (!workerRepository.existsById(id)){
            return false;
        }

        workerRepository.deleteById(id);
        return true;
    }

    
}
