package biblioteka;

/**
 * Predstavlja autora knjige.
 * Svaki autor moze biti autor vise knjiga.
 * @author bojantomic
 * @version 1.0
 *
 */
public class Autor {
	
	/**
	 * Ime autora
	 */
	private String ime;
	
	/**
	 * Prezime autora
	 */
	private String prezime;
	
	/**
	 * Postavlja ime i prezime na null
	 */
	public Autor() {
		ime = null;
		prezime = null;
	}

	/**
	 * Postavlja ime i prezime na unete vrednosti
	 * 
	 * @param ime novo ime autora
	 * @param prezime novo prezime autora
	 */
	public Autor(String ime, String prezime) {
		super();
		setIme(ime);
		setPrezime(prezime);
	}

	/**
	 * Vraca ime autora
	 * 
	 * @return ime autora kao String
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Postavlja novu vrednost za atribut ime
	 * 
	 * @param ime novo ime autora
	 * @throws java.lang.NullPointerException ako je uneto ime null
	 * @throws java.lang.IllegalArgumentException ako je uneto ime prazan String
	 */
	public void setIme(String ime) {
		if (ime == null)
			throw new NullPointerException("Ime ne sme biti null");
		
		if (ime.isEmpty())
			throw new IllegalArgumentException("Ime ne sme biti prazan string");
		
		this.ime = ime;
	}

	/**
	 * Vraca prezime autora
	 * 
	 * @return prezime autora kao String
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Postavlja novu vrednost za atribut prezime
	 * 
	 * @param prezime novo prezime autora
	 * @throws java.lang.NullPointerException ako je uneto prezime null
	 * @throws java.lang.IllegalArgumentException ako je uneto prezime prazan String
	 */
	public void setPrezime(String prezime) {
		if (prezime == null)
			throw new NullPointerException("Prezime ne sme biti null");
		
		if (prezime.isEmpty())
			throw new IllegalArgumentException("Prezime ne sme biti prazan string");
		
		this.prezime = prezime;
	}

	/**
	 * Vraca sve podatke o autoru u jednom String-u.
	 * 
	 * @return String sa svim podacima o autoru
	 */
	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		return result;
	}

	/**
	 * Poredi dva autora po imenu i prezimenu
	 * 
	 * @return
	 * <ul>
	 * <li>true - ako su i ime i prezime isti kod oba autora</li>
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
		Autor other = (Autor) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}

}
