package com.usa.edu.co.ciclo4_reto2.service;



import com.usa.edu.co.ciclo4_reto2.model.Laptop;
import com.usa.edu.co.ciclo4_reto2.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Laptop> getAll(){
        return laptopRepository.getAll();
    }
    public Optional<Laptop> getLaptop(int id){
        return laptopRepository.getLaptop(id);
    }

    public Laptop create(Laptop laptop) {
        Optional<Laptop> laptopLastId = laptopRepository.lastUserId();
        if (laptop.getId() == null) {
            if (laptopLastId.isEmpty())
                laptop.setId(1);
            else
                laptop.setId(laptopLastId.get().getId() + 1);

        }

        Optional<Laptop> existLaptop = laptopRepository.getLaptop(laptop.getId());
        if (existLaptop.isEmpty()) {
            return laptopRepository.create(laptop);
        } else {
            return laptop;
        }
    }
    public Laptop update(Laptop laptop){
        if(laptop.getId() !=null) {
            Optional<Laptop> optionalLaptop = laptopRepository.getLaptop(laptop.getId());
            if(!optionalLaptop.isEmpty()){
                if(laptop.getBrand() != null){
                    optionalLaptop.get().setBrand(laptop.getBrand());
                }
                if(laptop.getModel() != null){
                    optionalLaptop.get().setModel(laptop.getModel());
                }
                if(laptop.getProcesor() != null){
                    optionalLaptop.get().setProcesor(laptop.getProcesor());
                }
                if(laptop.getOs() != null){
                    optionalLaptop.get().setOs(laptop.getOs());
                }
                if(laptop.getDescription() != null){
                    optionalLaptop.get().setDescription(laptop.getDescription());
                }
                if(laptop.getMemory() != null){
                    optionalLaptop.get().setMemory(laptop.getMemory());
                }
                if(laptop.getHardDrive() != null){
                    optionalLaptop.get().setHardDrive(laptop.getHardDrive());
                }
                if(laptop.getPrice() != 0.00){
                    optionalLaptop.get().setPrice(laptop.getPrice());
                }
                if(laptop.getQuantity() != 0){
                    optionalLaptop.get().setQuantity(laptop.getQuantity());
                }
                if(laptop.getPhotography() != null){
                    optionalLaptop.get().setPhotography(laptop.getPhotography());
                }
                if(laptop.getPhotography() != null){
                    optionalLaptop.get().setPhotography(laptop.getPhotography());
                }
                optionalLaptop.get().setAvailability(laptop.isAvailability());
                laptopRepository.update(optionalLaptop.get());
                return optionalLaptop.get();
            }else {
                return laptop;
            }
        }else {
            return laptop;
        }
    }
    public boolean delete(int id) {
        Boolean aBoolean = getLaptop(id).map(product -> {
            laptopRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Laptop> laptopsByPrice(double price) {
        return laptopRepository.laptopsByPrice(price);
    }

    //Reto 5
    public List<Laptop> findByDescriptionLike(String description) {
        return laptopRepository.findByDescriptionLike(description);
    }
}
