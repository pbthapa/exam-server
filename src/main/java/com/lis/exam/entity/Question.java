package com.lis.exam.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "QUESTION")
public class Question implements Serializable {

	private static final long serialVersionUID = -1912910627698708721L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ACTIVE")
	private Boolean active;

	@Column(name = "QUESTION", nullable = false)
	private String question;
	@Column(name = "OPTION_A", nullable = false)
	private String optionA;
	@Column(name = "OPTION_B", nullable = false)
	private String optionB;
	@Column(name = "OPTION_C", nullable = false)
	private String optionC;
	@Column(name = "OPTION_D", nullable = false)
	private String optionD;
	@Column(name = "CORRECT_OPTION", nullable = false, length = 10)
	private String correctOption;
	@Column(name = "LEVEL", nullable = false)
	private Integer level;
//	@Column(name = "WEIGHTAGE", nullable = false)
//	private Integer weightage;
	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID", nullable = false)
	private SubjectArea subjectArea;
	
	@Transient
	private Long subjectId;

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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

//	public Integer getWeightage() {
//		return weightage;
//	}
//
//	public void setWeightage(Integer weightage) {
//		this.weightage = weightage;
//	}

	public SubjectArea getSubjectArea() {
		if (subjectArea == null) {
			subjectArea = new SubjectArea();
		}
		return subjectArea;
	}

	public void setSubjectArea(SubjectArea subjectArea) {
		this.subjectArea = subjectArea;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
}
