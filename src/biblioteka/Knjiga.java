package biblioteka;

import java.util.List;

/**
 * Predstavlja knjigu koja ima naslov, isbn, autore, izdavaca i izdanje.
 * 
 * @author bojantomic
 *
 */
public class Knjiga {
	
	/**
	 * Naslov knjige
	 */
	private String naslov;
	
	/**
	 * ISBN identifikator knjige
	 * 
	 * ISBN brojevi su 13-cifreni identifikatori za knjige i pisana dela.
	 *  
	 * @see <a href="https://en.wikipedia.org/wiki/International_Standard_Book_Number">Wikipedia - ISBN</a>
	 */
	private long isbn;
	
	/**
	 * Lista autora knjige.
	 */
	private List<Autor> autori;
	
	/**
	 * Naziv izdavacke kuce za tu knjigu
	 */
	private String izdavac;
	
	/**
	 * Redni broj izdanja knjige
	 */
	private int izdanje;

	/**
	 * Vraca naslov knjige
	 * 
	 * @return naslov knjige kao String
	 */
	public String getNaslov() {
		return naslov;
	}

	/**
	 * Postavlja naslov knjige
	 * 
	 * @param naslov nov naslov knjige
	 * @throws java.lang.NullPointerException ako je uneti naslov null
	 * @throws java.lang.IllegalArgumentException ako je uneti naslov prazan String
	 */
	public void setNaslov(String naslov) {
		if (naslov == null)
			throw new NullPointerException("Naslov ne sme biti null");
		
		if (naslov.isEmpty())
			throw new IllegalArgumentException("Naslov ne sme biti prazan string");
		
		this.naslov = naslov;
	}

	/**
	 * Vraca ISBN knjige 
	 * 
	 * @return ISBN knjige kao ceo broj tipa long
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * Postavlja ISBN broj knjige
	 * 
	 * @param isbn nov isbn broj knjige
	 * @throws java.lang.IllegalArgumentException ako je uneti ISBN broj nula ili manji od nule
	 */
	public void setIsbn(long isbn) {
		if (isbn <= 0)
			throw new IllegalArgumentException("ISBN broj mora bii veci od nule");
		
		this.isbn = isbn;
	}

	/**
	 * Vraca naziv izdavaca knjige
	 * 
	 * @return naziv izdavaca knjige kao String
	 */
	public String getIzdavac() {
		return izdavac;
	}

	/**
	 * Vraca sve autore knjige
	 * 
	 * @return Lista sa svim autorima knjige 
	 */
	public List<Autor> getAutori() {
		return autori;
	}
	
	/**
	 * Postavlja autore knjige
	 * 
	 * @param autori svi autori knjige uneti u jednu listu
	 */

	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}

	/**
	 * Postavlja naziv izdavaca knjige
	 * 
	 * @param izdavac nov naziv izdavaca knjige
	 * @throws java.lang.NullPointerException ako je uneti naziv izdavaca null
	 * @throws java.lang.IllegalArgumentException ako je uneti naziv izdavaca prazan String
	 */
	public void setIzdavac(String izdavac) {
		if (izdavac == null)
			throw new NullPointerException("Naziv izdavaca ne sme biti null");
		
		if (izdavac.isEmpty())
			throw new IllegalArgumentException("Naziv izdavaca ne sme biti prazan string");

		this.izdavac = izdavac;
	}

	/**
	 * Vraca izdanje knjige
	 * 
	 * @return izdanje knjige kao ceo broj
	 */
	public int getIzdanje() {
		return izdanje;
	}

	/**
	 * Postavlja broj izdanja knjige
	 * 
	 * @param izdanje nov broj izdanja knjige
	 * @throws java.lang.IllegalArgumentException ako je uneti broj izdanja nula ili manji od nule
	 */
	public void setIzdanje(int izdanje) {
		if (izdanje <= 0)
			throw new IllegalArgumentException("Broj izdanja mora bii veci od nule");
		
		this.izdanje = izdanje;
	}
	
	/**
	 * Vraca String sa svim podacima o knjizi
	 * 
	 * @return String sa svim podacima o knjizi
	 */
	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", isbn=" + isbn + ", autori=" + autori + ", izdavac=" + izdavac
				+ ", izdanje=" + izdanje + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
		return result;
	}

	/**
	 * Poredi dve knjige po ISBN broju
	 * 
	 * @return
	 * <ul>
	 * <li>true - ako je ISBN broj isti kod obe knjige</li>
	 * <li>false - ako to nije slucaj</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		if (isbn != other.isbn)
			return false;
		return true;
	}

}
