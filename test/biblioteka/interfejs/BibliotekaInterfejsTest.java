package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;

public abstract class BibliotekaInterfejsTest {

	protected BibliotekaInterfejs biblioteka;
	
	@Test
	void testDodajKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");
		
		biblioteka.dodajKnjigu(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size() );
		assertEquals(k, biblioteka.vratiSveKnjige().get(0) );
	}
	
	@Test
	void testDodajKnjiguViseKnjiga() {
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");

		Knjiga k2 = new Knjiga();
		k2.setIsbn(9876);
		k2.setNaslov("Naslov 2");

		biblioteka.dodajKnjigu(k);
		biblioteka.dodajKnjigu(k2);
		
		assertEquals(2, biblioteka.vratiSveKnjige().size() );
		assertTrue(biblioteka.vratiSveKnjige().contains(k));
		assertTrue(biblioteka.vratiSveKnjige().contains(k2));
	}
	
	@Test
	void testDodajKnjiguDuplikat() {
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");

		Knjiga k2 = new Knjiga();
		k2.setIsbn(1234);
		k2.setNaslov("Naslov 1");

		biblioteka.dodajKnjigu(k);
		
		Exception e = assertThrows(java.lang.IllegalArgumentException.class,
				() -> biblioteka.dodajKnjigu(k2) );
		
		assertEquals("Ista knjiga vec postoji u biblioteci", e.getMessage());
	}
	
	@Test
	void testDodajKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> biblioteka.dodajKnjigu(null) );
	}

	@Test
	void testObrisiKnjigu() {
		fail("Not yet implemented");
	}

	@Test
	void testVratiSveKnjige() {
		fail("Not yet implemented");
	}

	@Test
	void testPronadjiKnjigu() {
		fail("Not yet implemented");
	}

}
