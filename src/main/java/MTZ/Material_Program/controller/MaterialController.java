package MTZ.Material_Program.controller;


import MTZ.Material_Program.dto.CalculationRequest;
import MTZ.Material_Program.dto.CalculationResult;
import MTZ.Material_Program.service.MaterialService;
import org.springframework.web.bind.annotation.*;
import MTZ.Material_Program.Checkout;
import MTZ.Material_Program.Material;
import org.springframework.http.ResponseEntity;
import java.util.List;




@RestController
@RequestMapping("/api/materials")
public class MaterialController {

     private final MaterialService materialService;

     public MaterialController(MaterialService materialService){
        this.materialService = materialService;
     }

     @PostMapping("/calculate")
     public CalculationResult calculate (@RequestBody CalculationRequest request) {
        return materialService.calculate(request);
     }

     @PostMapping("/checkout")
     public Checkout saveCheckout(@RequestBody Checkout checkout){
        return materialService.saveCheckout(checkout);
     }

     @PostMapping
     public Material createMaterial(@RequestBody Material material){
        return materialService.saveMaterial(material);
     }

     @GetMapping ("/checkout/worker/{workerId}")
     public List<Checkout> getByWorker(@PathVariable Long workerId) {
        return materialService.getCheckoutsByWorker(workerId);
     }

     @GetMapping ("/checkout/job/{jobId}")
     public List<Checkout> getByJob(@PathVariable Long jobId){
        return materialService.getCheckoutsByJob(jobId);
     }

     @GetMapping ("/checkout/worker/{workerId}/job/{jobId}")
     public List<Checkout> getByWorkerAndJob(@PathVariable Long workerId, @PathVariable Long jobId){
        return materialService.getCheckoutsByWorkerAndJob(workerId, jobId);
     }

     @GetMapping ("/checkout")
     public List<Checkout> getAllCheckouts(){
        return materialService.getAllCheckouts();
     }

     @GetMapping
     public List<Material> getAllMaterials(){
        return materialService.getAllMaterials();
     }

     @GetMapping("/{id}")
     public ResponseEntity<Material> getMaterialById(@PathVariable Long id){
        return materialService.getMaterialById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
     }



}
