package com.qa.choonz.persistence.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	private String name;

	@NotNull
	@Size(max = 250)
	@Column(unique = true)
	private String description;

	@OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Track> tracks;

	public Genre(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Genre(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Genre [id=").append(id).append(", name=").append(name).append(", description=")
//                .append(description).append("]");
//        return builder.toString();
//    }
//
//    //.append(", albums=").append(albums)
//    
//    @Override
//    public int hashCode() {
//        return Objects.hash(description, id, name);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Genre)) {
//            return false;
//        }
//        Genre other = (Genre) obj;
//        return Objects.equals(description, other.description) && id == other.id
//                && Objects.equals(name, other.name);
//    }
//    //Objects.equals(albums, other.albums) && 
}
