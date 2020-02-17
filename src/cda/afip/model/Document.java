package cda.afip.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documents database table.
 * 
 */
@Entity
@Table(name="documents")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=25)
	private String name;

	@Column(nullable=false, length=150)
	private String path;

	@Column(nullable=false)
	private byte type;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user", nullable=false)
	private User user;

	public Document() {
	}
	

	public Document(int id, String name, String path, byte type, User user) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.type = type;
		this.user = user;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "[id=" + id + "] " + name + " (" + user+")";
	}
	
}