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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 40)
	@Column(unique = true)
	private String name;

	@NotNull
	@Size(max = 25)
	@Column(unique = true)
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Playlist> playlists;

	public User(long id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Artist [id=").append(id).append(", name=").append(name).append(", albums=").append(albums)
//                .append("]");
//        return builder.toString();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(albums, id, name);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Artist)) {
//            return false;
//        }
//        Artist other = (Artist) obj;
//        return Objects.equals(albums, other.albums) && id == other.id && Objects.equals(name, other.name);
//    }

}
