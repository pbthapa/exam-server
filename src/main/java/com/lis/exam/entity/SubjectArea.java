package com.lis.exam.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT_AREA")
public class SubjectArea implements Serializable {

	private static final long serialVersionUID = -3484211305983257429L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	@Column(name = "ID")
	private Long id;

	@Column(name="ACTIVE")
	private Boolean active;
	
	private String subject;

	@Column(name = "SUBJECT", nullable = false, length = 50)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "{ id:" + getId() + ", subject: " + getSubject() + ", active: " + getActive() + "}";
	}
}
