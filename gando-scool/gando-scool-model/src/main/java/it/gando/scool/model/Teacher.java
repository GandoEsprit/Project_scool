package it.gando.scool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "teacher_name")
	private String name;
	
	@Column(name = "teacher_surname")
	private String surname;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name="Teacher_matiere",
		joinColumns = {@JoinColumn(name="teacher_id")},
		inverseJoinColumns = {@JoinColumn(name="matiere_id")}
	)
	private List<Matiere> matiereList = new ArrayList<>();
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="teacherList")
	private List<Classe> classeList = new ArrayList<>();
	
	public Teacher() {}
	
	public Teacher(String name, String surname){
		this.name = name;
		this.surname = surname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Matiere> getMatiereList() {
		return matiereList;
	}

	public void setMatiereList(List<Matiere> matiereList) {
		this.matiereList = matiereList;
	}

}
