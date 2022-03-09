package biblioteka;

import java.util.LinkedList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {
	
	private List<Knjiga> knjige = new LinkedList<Knjiga>();

	//privatni komentar
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
