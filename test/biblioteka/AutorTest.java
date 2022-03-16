package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {

	Autor a;
	
	@BeforeEach
	void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	void testSetIme() {
		a.setIme("Pera");
		
		assertEquals("Pera", a.getIme() );
	}
	
	@Test
	void testSetImePrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setIme("") );
	}
	
	@Test
	void testSetImeNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setIme(null) );
	}

	@Test
	void testSetPrezime() {
		a.setPrezime("Peric");
		
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	void testSetPrezimePrazanString() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setPrezime("") );
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setPrezime(null) );
	}

	@Test
	void testToString() {
		a.setIme("Zika");
		a.setPrezime("Zikic");
		
		String s = a.toString();
		
		assertTrue(s.contains("Zika"));
		assertTrue(s.contains("Zikic"));
	}

	@ParameterizedTest
	@CsvSource({
			"Pera, Peric, Pera, Peric, true",
			"Pera, Peric, Pera, Tomic, false",
			"Pera, Peric, Zika, Peric, false",
			"Pera, Peric, Mika, Mikic, false"
	})
	void testEqualsObject(String ime1, String prezime1,
			String ime2, String prezime2, boolean equals) {
		
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor b = new Autor();
		b.setIme(ime2);
		b.setPrezime(prezime2);
		
		assertEquals(equals, a.equals(b) );		
	}
	
	@Test
	void testAutorStringString() {
		a = new Autor("Laza", "Lazic");
		
		assertEquals("Laza", a.getIme());
		assertEquals("Lazic", a.getPrezime());
	}

}
