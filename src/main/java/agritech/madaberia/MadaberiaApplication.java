package agritech.madaberia;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MadaberiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MadaberiaApplication.class, args);
	}
	@Bean
	ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
