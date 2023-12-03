package fit.iuh.edu.vn;

import fit.iuh.edu.vn.emums.CountryCode;
import fit.iuh.edu.vn.entities.Address;
import fit.iuh.edu.vn.entities.Candidate;
import fit.iuh.edu.vn.repositories.AddressRepository;
import fit.iuh.edu.vn.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private AddressRepository addressRepository;
//	@Bean
	CommandLineRunner initData(){
		return args -> {
			Random rnd =new Random();
			for (int i = 1; i < 1000; i++) {
				Address add = new Address("HCM","NguyenHong",rnd.nextInt(1,1000)+"",rnd.nextInt(1000,2000)+"", CountryCode.VN );
				addressRepository.save(add);
			}
		};
	}
}
