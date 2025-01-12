package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final InhousePartRepository inhousePartRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, InhousePartRepository inhousePartRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.inhousePartRepository = inhousePartRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count() == 0 && inhousePartRepository.count() == 0 && outsourcedPartRepository.count() == 0 && productRepository.count() == 0) {

            List<InhousePart> inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();

            InhousePart frame = new InhousePart();
            frame.setName("Frame");
            frame.setInv(100);
            frame.setPrice(50.0);
            frame.setId(1);
            inhousePartRepository.save(frame);
            InhousePart inPart=null;
            inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
            for(InhousePart part:inhouseParts){
                if(part.getName().equals("Frame"))inPart=part;
            }

            InhousePart buttons = new InhousePart();
            buttons.setName("Buttons");
            buttons.setInv(500);
            buttons.setPrice(30.0);
            buttons.setId(2);
            inhousePartRepository.save(buttons);
            inPart=null;
            inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
            for(InhousePart part:inhouseParts){
                if(part.getName().equals("Buttons"))inPart=part;
            }

            InhousePart thumbsticks = new InhousePart();
            thumbsticks.setName("Thumbsticks");
            thumbsticks.setInv(500);
            thumbsticks.setPrice(10.0);
            thumbsticks.setId(3);
            inhousePartRepository.save(thumbsticks);
            inPart=null;
            inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
            for(InhousePart part:inhouseParts){
                if(part.getName().equals("Thumbsticks"))inPart=part;
            }

            inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
            for(InhousePart part:inhouseParts){
                System.out.println(part.getName() + " " + part.getId());
            }

            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();

            OutsourcedPart circuitBoard = new OutsourcedPart();
            circuitBoard.setCompanyName("Controller Supplies Inc.");
            circuitBoard.setName("Circuit Board");
            circuitBoard.setInv(100);
            circuitBoard.setPrice(60.0);
            circuitBoard.setId(100);
            outsourcedPartRepository.save(circuitBoard);
            OutsourcedPart outPart=null;
            outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                if(part.getName().equals("Circuit Board"))outPart=part;
            }

            System.out.println(outPart.getCompanyName());

            OutsourcedPart chargingCable = new OutsourcedPart();
            chargingCable.setCompanyName("Controller Supplies Inc.");
            chargingCable.setName("Charging Cable");
            chargingCable.setInv(100);
            chargingCable.setPrice(10.0);
            chargingCable.setId(101);
            outsourcedPartRepository.save(chargingCable);
            outPart=null;
            outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                if(part.getName().equals("Charging Cable"))outPart=part;
            }

            System.out.println(outPart.getCompanyName());

            outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            Product switchC = new Product("Switch Controller", 70.0, 50);
            Product xboxC = new Product("Xbox Controller", 70.0, 50);
            Product ps5C = new Product("PS5 Controller", 80.0, 50);
            Product steamC = new Product("Steam Controller", 150.0, 30);
            Product ps4C = new Product("PS4 Controller", 50.0, 25);

            productRepository.save(switchC);
            productRepository.save(xboxC);
            productRepository.save(ps5C);
            productRepository.save(steamC);
            productRepository.save(ps4C);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());
    }
}
