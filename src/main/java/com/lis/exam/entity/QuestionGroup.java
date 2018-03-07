package com.lis.exam.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "QUESTION_GROUP")
public class QuestionGroup implements Serializable {

	private static final long serialVersionUID = -1912910627698708721L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	@Column(name = "ID")
	private Long id;

	@Column(name="ACTIVE")
	private Boolean active;
	
	private String groupName;
	
	private Question question;
	
	@Column(name = "GROUP_NAME", nullable = false, length = 100)
	public String getGroupName() {
		return groupName;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_QUESTION_ID", nullable = false)
	public Question getQuestion() {
		return question;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setQuestion(Question question) {
		this.question = question;
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
}
