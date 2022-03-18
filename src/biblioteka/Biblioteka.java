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
		
		for (Knjiga k : knjige) {
			boolean nadjeno = true;
			
			if (naslov!=null)
				if (k.getNaslov() != null && k.getNaslov().toLowerCase().contains(naslov.toLowerCase()))
					nadjeno = nadjeno && true;
				else
					nadjeno = false;
			
			
			if (isbn > 0)
				if (k.getIsbn() == isbn) 
					nadjeno = nadjeno && true;
				else
					nadjeno = false;
			
			
			if (autor != null)
				if (k.getAutori() != null && k.getAutori().contains(autor)) 
					nadjeno = nadjeno && true;
				else
					nadjeno = false;

			if (izdavac!=null)
				if (k.getIzdavac() != null && k.getIzdavac().toLowerCase().contains(izdavac.toLowerCase()))
					nadjeno = nadjeno && true;
				else
					nadjeno = false;
			
			if (nadjeno)
				rezultat.add(k);
		}
		
		return rezultat;
	}

}
