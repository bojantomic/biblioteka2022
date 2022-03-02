package biblioteka.interfejs;

import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

public interface BibliotekaInterfejs {
	
	public void dodajKnjigu(Knjiga knjiga);
	
	public void obrisiKnjigu(Knjiga knjiga);
	
	public List<Knjiga> vratiSveKnjige();
	
	public List<Knjiga> pronadjiKnjigu(Autor autor,
			long isbn, String naslov, String izdavac);

}
