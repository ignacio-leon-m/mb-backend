package com.igleon.mbback;

import com.igleon.mbback.model.Bicicleta;
import com.igleon.mbback.repository.BicicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MbBackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MbBackApplication.class, args);
	}

	@Autowired
	private BicicletaRepository bicicletaRepository;

	@Override
	public void run(String... args) throws Exception {
		Bicicleta bicicleta1 = new Bicicleta();
		bicicleta1.setMarca("Trek");
		bicicleta1.setModelo("Marlin 5");
		bicicleta1.setAro(29);
		bicicleta1.setTipo("Montaña");
		bicicleta1.setColor("Rojo");
		bicicleta1.setEstado("Disponible");
		bicicleta1.setPrecioArr("10000");
		bicicletaRepository.save(bicicleta1);

		Bicicleta bicicleta2 = new Bicicleta();
		bicicleta2.setMarca("Scott");
		bicicleta2.setModelo("Aspect 950");
		bicicleta2.setAro(29);
		bicicleta2.setTipo("Montaña");
		bicicleta2.setColor("Negro");
		bicicleta2.setEstado("Disponible");
		bicicleta2.setPrecioArr("15000");
		bicicletaRepository.save(bicicleta2);
	}
}

