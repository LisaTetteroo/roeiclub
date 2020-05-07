package nl.lisa.roeiclub;

import nl.lisa.roeiclub.domein.Boot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class RoeiclubApplicationTests {

	@Test
	void contextLoads() {
		Boot b = new Boot();
		b.setNaam("Dwars");
		assertEquals("Dwars",b.getNaam());
		b.setNaam(null);
		assertThrows(Exception.class, () -> {});

	}

}
