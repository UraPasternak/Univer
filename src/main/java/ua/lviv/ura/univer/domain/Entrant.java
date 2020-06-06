package ua.lviv.ura.univer.domain;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrant")
public class Entrant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String firstName;
	private String lastName;
	
	 @ManyToOne()
	 @JoinColumn(name = "fk_faculty")
	private Facultet facultet;
	
	@ElementCollection(targetClass = Predmet.class)
	@CollectionTable(name="EntrantPredmets", joinColumns = @JoinColumn(name="ENTRANT_ID") ) 
	@Column( name="Predmets", nullable=false ) 
	private List<Predmet> predmets;

	public Entrant() {
		super();
	}

	public Entrant(Integer id, String firstName, String lastName, Facultet facultet, List<Predmet> predmets) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.facultet = facultet;
		this.predmets = predmets;
	}

	public Entrant(String firstName, String lastName, Facultet facultet, List<Predmet> predmets) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.facultet = facultet;
		this.predmets = predmets;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Facultet getFacultet() {
		return facultet;
	}

	public void setFacultet(Facultet facultet) {
		this.facultet = facultet;
	}

	public List<Predmet> getPredmets() {
		return predmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facultet == null) ? 0 : facultet.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((predmets == null) ? 0 : predmets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrant other = (Entrant) obj;
		if (facultet == null) {
			if (other.facultet != null)
				return false;
		} else if (!facultet.equals(other.facultet))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (predmets == null) {
			if (other.predmets != null)
				return false;
		} else if (!predmets.equals(other.predmets))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entrant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", facultet=" + facultet
				+ ", predmets=" + predmets + "]";
	}

}
