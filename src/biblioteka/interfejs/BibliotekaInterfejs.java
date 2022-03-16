package biblioteka.interfejs;

import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

/**
 * Predstavlja biblioteku sa knjigama.
 * 
 * Ima osnovne operacije unosa, brisanja i pretrage biblioteke.
 */
public interface BibliotekaInterfejs {
	
	/**
	 * Dodaje knjigu u biblioteku.
	 * 
	 * Dodaj knjigu u biblioteku samo ako knjiga vec ne postoji u biblioteci i ako nije null.
	 * U principu, nema duplikata u biblioteci.
	 * 
	 * @param knjiga knjiga koju treba dodati u biblioteku
	 * @throws java.lang.NullPointerException ako je uneta knjiga null
	 * @throws java.lang.IllegalArgumentException ako uneta knjiga vec postoji u biblioteci
	 * 
	 * @see <a href = "https://github.com">GutHub sajt</a>
	 * @see biblioteka.Autor
	 */
	public void dodajKnjigu(Knjiga knjiga);
	
	public void obrisiKnjigu(Knjiga knjiga);
	
	public List<Knjiga> vratiSveKnjige();
	
	public List<Knjiga> pronadjiKnjigu(Autor autor,
			long isbn, String naslov, String izdavac);

}
