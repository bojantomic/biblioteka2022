package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import biblioteka.Autor;
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
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");

		biblioteka.dodajKnjigu(k);

		Knjiga k2 = new Knjiga();
		k2.setIsbn(9864);
		k2.setNaslov("Naslov 2");

		biblioteka.dodajKnjigu(k2);
		
		biblioteka.obrisiKnjigu(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size());
		assertTrue(biblioteka.vratiSveKnjige().contains(k2));		
	}

	@Test
	void testObrisiKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> biblioteka.obrisiKnjigu(null) );				
	}
	
	
	@Test
	void testVratiSveKnjige() {
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");

		biblioteka.dodajKnjigu(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size());
		assertTrue(biblioteka.vratiSveKnjige().contains(k));
	}

	@Test
	void testPronadjiKnjiguJedanRezultatPretragaISBN() {
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");

		biblioteka.dodajKnjigu(k);

		Knjiga k2 = new Knjiga();
		k2.setIsbn(9864);
		k2.setNaslov("Naslov 2");

		biblioteka.dodajKnjigu(k2);

		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(null, 9864, null, null);
		
		assertEquals(1, rezultat.size());
		assertTrue(rezultat.contains(k2));
	}
	
	@Test
	void testPronadjiKnjiguJedanRezultatPretragaNaslov() {
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");

		biblioteka.dodajKnjigu(k);

		Knjiga k2 = new Knjiga();
		k2.setIsbn(9864);
		k2.setNaslov("Naslov 2");

		biblioteka.dodajKnjigu(k2);

		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(null, 0, "1", null);
		
		assertEquals(1, rezultat.size());
		assertTrue(rezultat.contains(k));
	}
	
	@Test
	void testPronadjiKnjiguJedanRezultatPretragaIzdavac() {
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");
		k.setIzdavac("Vulkan");

		biblioteka.dodajKnjigu(k);

		Knjiga k2 = new Knjiga();
		k2.setIsbn(9864);
		k2.setNaslov("Naslov 2");
		k2.setIzdavac("Delfi");

		biblioteka.dodajKnjigu(k2);

		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(null, 0, null, "del");
		
		assertEquals(1, rezultat.size());
		assertTrue(rezultat.contains(k2));
	}
	
	@Test
	void testPronadjiKnjiguJedanRezultatPretragaAutor() {
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");
		k.setIzdavac("Vulkan");

		Autor a1 = new Autor("Pera", "Peric");
		Autor a2 = new Autor("Mika", "Mikic");
		
		LinkedList<Autor> autori = new LinkedList<Autor>();
		autori.add(a1);
		autori.add(a2);
		
		k.setAutori(autori);

		biblioteka.dodajKnjigu(k);

		Knjiga k2 = new Knjiga();
		k2.setIsbn(9864);
		k2.setNaslov("Naslov 2");
		k2.setIzdavac("Delfi");

		biblioteka.dodajKnjigu(k2);

		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(a2, 0, null, null);
		
		assertEquals(1, rezultat.size());
		assertTrue(rezultat.contains(k));
	}
	
	@Test
	void testPronadjiKnjiguJedanRezultatPretragaSviParametri() {
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");
		k.setIzdavac("Vulkan");

		Autor a1 = new Autor("Pera", "Peric");
		Autor a2 = new Autor("Mika", "Mikic");
		
		LinkedList<Autor> autori = new LinkedList<Autor>();
		autori.add(a1);
		autori.add(a2);
		
		k.setAutori(autori);

		biblioteka.dodajKnjigu(k);

		Knjiga k2 = new Knjiga();
		k2.setIsbn(9864);
		k2.setNaslov("Naslov 2");
		k2.setIzdavac("Delfi");

		biblioteka.dodajKnjigu(k2);

		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(a2, 1234, "Nas", "ulk");
		
		assertEquals(1, rezultat.size());
		assertTrue(rezultat.contains(k));
	}
	
	@Test
	void testPronadjiKnjiguViseRezultataSviParametri() {
		Knjiga k = new Knjiga();
		k.setIsbn(1234);
		k.setNaslov("Naslov 1");
		k.setIzdavac("Vulkan");

		Autor a1 = new Autor("Pera", "Peric");
		Autor a2 = new Autor("Mika", "Mikic");
		
		LinkedList<Autor> autori = new LinkedList<Autor>();
		autori.add(a1);
		autori.add(a2);
		
		k.setAutori(autori);

		biblioteka.dodajKnjigu(k);

		Knjiga k2 = new Knjiga();
		k2.setIsbn(9864);
		k2.setNaslov("Naslov 2");
		k2.setIzdavac("Delfi");

		Autor a3 = new Autor("Pera", "Peric");
		Autor a4 = new Autor("Zika", "Lazic");
		
		LinkedList<Autor> autori2 = new LinkedList<Autor>();
		autori2.add(a3);
		autori2.add(a4);
		
		k2.setAutori(autori2);
		biblioteka.dodajKnjigu(k2);

		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(a3, 0, "Nas", null);
		
		assertEquals(2, rezultat.size());
		assertTrue(rezultat.contains(k));
		assertTrue(rezultat.contains(k2));
	}
	
	@Test
	void testPronadjiKnjiguNisuUnetiParametri() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> biblioteka.pronadjiKnjigu(null, 0, null, null) );
	}

}
