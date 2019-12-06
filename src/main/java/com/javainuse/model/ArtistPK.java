package com.javainuse.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ArtistPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id1;
	private Long id2;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id1 == null) ? 0 : id1.hashCode());
		result = prime * result + ((id2 == null) ? 0 : id2.hashCode());
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
		ArtistPK other = (ArtistPK) obj;
		if (id1 == null) {
			if (other.id1 != null)
				return false;
		} else if (!id1.equals(other.id1))
			return false;
		if (id2 == null) {
			if (other.id2 != null)
				return false;
		} else if (!id2.equals(other.id2))
			return false;
		return true;
	}

}