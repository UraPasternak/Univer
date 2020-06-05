package ua.lviv.ura.univer.domain;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="atestat")
public class Atestat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Integer userId;
	
	@ElementCollection(targetClass = Predmet.class)
	@Enumerated(EnumType.STRING) 
	@Column( name="Predmet") 
	private Map<Predmet, Integer> otsinky;
	
	public Atestat() {}

	public Atestat(Map<Predmet, Integer> otsinky) {
		this.otsinky = otsinky;
	}

	public Atestat(Integer userId, Map<Predmet, Integer> otsinky) {
		
		this.userId = userId;
		this.otsinky = otsinky;
	}

	public Atestat(Integer id, Integer userId, Map<Predmet, Integer> otsinky) {
		super();
		this.id = id;
		this.userId = userId;
		this.otsinky = otsinky;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Map<Predmet, Integer> getOtsinky() {
		return otsinky;
	}

	public void setOtsinky(Map<Predmet, Integer> otsinky) {
		this.otsinky = otsinky;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((otsinky == null) ? 0 : otsinky.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Atestat other = (Atestat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (otsinky == null) {
			if (other.otsinky != null)
				return false;
		} else if (!otsinky.equals(other.otsinky))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atestat [id=" + id + ", userId=" + userId + ", otsinky=" + otsinky + "]";
	}
		
}
