package MTZ.Material_Program.service;

import MTZ.Material_Program.Checkout;
import MTZ.Material_Program.repository.CheckoutRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service 
public class CheckoutService{
    private final CheckoutRepository checkoutRepository;
    public CheckoutService(CheckoutRepository checkoutRepository){
        this.checkoutRepository = checkoutRepository;
    }

    public List<Checkout> getAllCheckouts(){
        return checkoutRepository.findAll();
    }

    public Optional<Checkout> getCheckoutById(long id){
        return checkoutRepository.findById(id);
    }

    public Checkout createCheckout(Checkout checkout){
        if (checkout.getIssuedAt() == null){
            checkout.setIssuedAt(Instant.now());
        }
        return checkoutRepository.save(checkout);  
    }

    public Optional <Checkout> updateCheckout(Long id, Checkout checkoutDetails){

        return checkoutRepository.findById(id)
        .map(existingCheckout -> {
            existingCheckout.setWorkerId(checkoutDetails.getWorkerId());
            existingCheckout.setJobId(checkoutDetails.getJobId());
            existingCheckout.setMaterialId(checkoutDetails.getMaterialId());
            existingCheckout.setQuantity(checkoutDetails.getQuantity());
            existingCheckout.setUsedQuantity(checkoutDetails.getUsedQuantity());
            existingCheckout.setReturnedQuantity(checkoutDetails.getReturnedQuantity());
            existingCheckout.setIssuedAt(checkoutDetails.getIssuedAt());

            return checkoutRepository.save(existingCheckout);
        });
    }


    public boolean deleteCheckout(Long id){
        if (!checkoutRepository.existsById(id)){
            return false;
        }

        checkoutRepository.deleteById(id);
            return true;
    }
}