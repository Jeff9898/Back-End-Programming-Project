package com.example.d288_backend.bootstrap;

import com.example.d288_backend.dao.CustomerRepository;
import com.example.d288_backend.dao.DivisionRepository;
import com.example.d288_backend.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Find all customers in db
        List<Customer> customerList = customerRepository.findAll();

        //Delete all customers in the db except John Doe
        /*
        customerList.stream()
                .filter(customer -> !(customer.getFirstName().equalsIgnoreCase("John") &&
                        customer.getLastName().equalsIgnoreCase("Doe")))
                .forEach(customerRepository::delete);
        */

        //John Doe already in database
        if(customerRepository.count() == 1) {

            Customer customer1 = new Customer();
            customer1.setFirstName("Michael");
            customer1.setLastName("Scott");
            customer1.setAddress("43 Stitious Rd..");
            customer1.setDivision(divisionRepository.findAll().get(37));
            customer1.setPostal_code("18503");
            customer1.setPhone("570-319-4963");

            customerRepository.save(customer1);


            Customer customer2 = new Customer();
            customer2.setFirstName("Jim");
            customer2.setLastName("Halpert");
            customer2.setAddress("12 Sports St.");
            customer2.setDivision(divisionRepository.findAll().get(7));
            customer2.setPostal_code("93494");
            customer2.setPhone("382-097-0032");

            customerRepository.save(customer2);


            Customer customer3 = new Customer();
            customer3.setFirstName("Pam");
            customer3.setLastName("Beesly");
            customer3.setAddress("36 Art Ave.");
            customer3.setDivision(divisionRepository.findAll().get(3));
            customer3.setPostal_code("11630");
            customer3.setPhone("623-493-2838");

            customerRepository.save(customer3);


            Customer customer4 = new Customer();
            customer4.setFirstName("Dwight");
            customer4.setLastName("Schrute");
            customer4.setAddress("92 Beets Rd.");
            customer4.setDivision(divisionRepository.findAll().get(1));
            customer4.setPostal_code("73826");
            customer4.setPhone("223-928-1002");

            customerRepository.save(customer4);


            Customer customer5 = new Customer();
            customer5.setFirstName("Angela");
            customer5.setLastName("Martin");
            customer5.setAddress("72 Kitten Ave.");
            customer5.setDivision(divisionRepository.findAll().get(8));
            customer5.setPostal_code("92830");
            customer5.setPhone("281-293-0936");

            customerRepository.save(customer5);

        }
    }
}
