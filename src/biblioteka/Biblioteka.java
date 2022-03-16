package biblioteka;

import java.util.LinkedList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterfejs;

/**
 * Predstavlja implementaciju biblioteke sa knjigama.
 * 
 * Ima osnovne operacije unosa, brisanja i pretrage biblioteke.
 */
public class Biblioteka implements BibliotekaInterfejs {
	
	/**
	 * Lista sa svim knjigama u biblioteci. Inicijalozovana kao LinkedList
	 */
	private List<Knjiga> knjige = new LinkedList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (knjige.contains(knjiga))
			throw new IllegalArgumentException("Ista knjiga vec postoji u biblioteci");
		
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn <= 0 && naslov == null && izdavac == null)
			throw new IllegalArgumentException("Morate uneti bar jedan kriterijum");
		
		List<Knjiga> rezultat = new LinkedList<Knjiga>();
		
		for (Knjiga k : knjige)
			if (k.getNaslov().toLowerCase().contains(naslov.toLowerCase()))
				rezultat.add(k);
		
		return rezultat;
	}

}
