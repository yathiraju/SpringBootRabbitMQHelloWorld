package com.javainuse.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Artist {
	@EmbeddedId
	private ArtistPK key;
}