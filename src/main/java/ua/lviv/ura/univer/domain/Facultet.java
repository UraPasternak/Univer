package ua.lviv.ura.univer.domain;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "faculty")
public class Facultet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Column
	private Integer numberOfStudents;

	@ElementCollection(targetClass = Predmet.class)
	@CollectionTable(name = "Predmet", joinColumns = @JoinColumn(name = "FACULTY_ID"))
	@Column(name = "Predmet", nullable = false)
	private List<Predmet> predmets;

public Facultet() {}

public Facultet(String name, Integer numberOfStudents, List<Predmet> predmets) {
	super();
	this.name = name;
	this.numberOfStudents = numberOfStudents;
	this.predmets = predmets;
}

public Facultet(Integer id, String name, Integer numberOfStudents, List<Predmet> predmets) {
	super();
	this.id = id;
	this.name = name;
	this.numberOfStudents = numberOfStudents;
	this.predmets = predmets;
}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(Integer numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public List<Predmet> getPredmets() {
		return predmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numberOfStudents == null) ? 0 : numberOfStudents.hashCode());
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
		Facultet other = (Facultet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfStudents == null) {
			if (other.numberOfStudents != null)
				return false;
		} else if (!numberOfStudents.equals(other.numberOfStudents))
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
		return "Facultet [id=" + id + ", name=" + name + ", numberOfStudents=" + numberOfStudents + ", predmets="
				+ predmets + "]";
	}

}