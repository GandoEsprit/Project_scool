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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Classe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "classe_name")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name="classe_teacher",
		joinColumns = {@JoinColumn(name="classe_id")},
		inverseJoinColumns = {@JoinColumn(name="teacher_id")}
	)
	private List<Teacher> teacherList = new ArrayList<>();
	
	public Classe() {}
	
	public Classe(String name){
		this.name = name;
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

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

}
