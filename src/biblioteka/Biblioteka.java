package biblioteka;

import java.util.LinkedList;
import java.util.List;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {
	
	private List<Knjiga> knjige = new LinkedList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn <= 0 && naslov == null && izdavac == null)
			return knjige;
		
		List<Knjiga> rezultat = new LinkedList<Knjiga>();
		
		for (Knjiga k : knjige)
			if (k.getNaslov().toLowerCase().contains(naslov.toLowerCase()))
				rezultat.add(k);
		
		return rezultat;
	}

}
