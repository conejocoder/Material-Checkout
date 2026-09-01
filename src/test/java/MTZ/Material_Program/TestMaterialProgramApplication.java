package MTZ.Material_Program;

import org.springframework.boot.SpringApplication;

public class TestMaterialProgramApplication {

	public static void main(String[] args) {
		SpringApplication.from(MaterialProgramApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
