package MTZ.Material_Program.controller;


import MTZ.Material_Program.Worker;
import MTZ.Material_Program.service.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService){
        this.workerService = workerService;
    }
    
    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
        return workerService.getWorkerById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Worker createWorker(@RequestBody Worker worker) {
        return workerService.createWorker(worker);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable Long id, @RequestBody Worker workerDetails){

        return workerService.updateWorker(id, workerDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        if (!workerService.deleteWorker(id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
