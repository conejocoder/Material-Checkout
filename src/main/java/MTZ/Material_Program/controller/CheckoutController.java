package MTZ.Material_Program.controller;

import MTZ.Material_Program.Checkout;
import MTZ.Material_Program.service.CheckoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping 
@RestController
public class CheckoutController {


    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }


    @GetMapping
    public List <Checkout> getAllCheckouts(){
        return checkoutService.getAllCheckouts();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Checkout> getCheckoutById(@PathVariable Long id){
        return checkoutService.getCheckoutById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Checkout createCheckout(@RequestBody Checkout checkout){
        return checkoutService.createCheckout(checkout);
    }

    @PutMapping("path/{id}")
    public ResponseEntity <Checkout> updateCheckout(@PathVariable long id, @RequestBody Checkout checkoutDetails){
        return checkoutService.updateCheckout(id, checkoutDetails)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Checkout> deleteCheckout(@PathVariable long id){
        if (!checkoutService.deleteCheckout(id)){
            return ResponseEntity.notFound().build();
        }
         return ResponseEntity.noContent().build();
    }

    
    






    
}
