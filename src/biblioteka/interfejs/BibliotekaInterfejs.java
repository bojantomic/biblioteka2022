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
	 * @see biblioteka.Knjiga
	 */
	public void dodajKnjigu(Knjiga knjiga);
	
	/**
	 * Brise knjigu iz biblioteke.
	 * 
	 * @param knjiga knjiga koju treba obrisati iz biblioteke
	 * @throws java.lang.NullPointerException ako je uneta knjiga null
	 */
	public void obrisiKnjigu(Knjiga knjiga);
	
	/**
	 * Vraca sve knjige iz biblioteke
	 *  
	 * @return Lista sa svim knjigama iz biblioteke
	 */
	public List<Knjiga> vratiSveKnjige();
	
	/**
	 * Pronalazi i vraca listu sa svim knjigama iz biblioteke koji zadovoljavaju uslove pretrage.
	 * 
	 * Nije potrebno uneti sve parametre pretrage, pretraga se vrsi prema parametrima koji su uneti
	 * odnosno nisu null i veci su od nule (ISBN). Pretraga se vrsi prema delu naslov, odnosno delu
	 * naziva izdavaca, nije neophodno uneti tacan naziv. Ova pretraga nije osetljiva na velika i
	 * mala slova. Pretraga po ISBN broju je tacna.
	 * 
	 * @param autor autor knjige.
	 * @param isbn ISBN broj knjige
	 * @param naslov deo naslova knjige ili tacan naslov
	 * @param izdavac deo naziva izdavaca knjige
	 * 
	 * @return Lista koja sadrzi sve knjige koji odgovaraju uslovima pretrage.
	 */
	public List<Knjiga> pronadjiKnjigu(Autor autor,
			long isbn, String naslov, String izdavac);

}
