package com.lis.exam.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lis.exam.entity.Question;
import com.lis.exam.entity.SubjectArea;
import com.lis.exam.service.QuestionService;
import com.lis.exam.service.SubjectService;
import com.lis.exam.utils.DropdownDto;
import com.lis.exam.utils.SearchCriteria;
import com.lis.exam.utils.TreeviewItem;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private QuestionService questionService;
//	@Autowired
//	private SubjectAreaRedisRepository subjectAreaRedisRepository;

	/**
	 * Get the list of subjects
	 * @return List of Subjects
	 */
	@GetMapping(value = "/all-subject-area")
	public Collection<SubjectArea> getSubjectAreaList() {
		List<SubjectArea> list = subjectService.findAllSubjects();
/*		Map<Long, SubjectArea> subjectMap = subjectAreaRedisRepository.findAll();
		Collection<SubjectArea> subjects = subjectMap.values();
		subjects.addAll(list);*/
		return list;
	}

	@PostMapping(value = "/create-subject-area")
	public String addSubjectArea(@RequestBody SubjectArea subject) {
		subjectService.save(subject);
		return "Subject Saved Successfully";
	}
	
	@PostMapping(value = "/create-question")
	public String addQuestion(@RequestBody Question question) {
		Question questionObject = setQuestionPropeties(question);
		questionService.save(questionObject);
		return "Question Saved Successfully";
	}
	
	@GetMapping(value = "/questions")
	public Collection<Question> getQuestionList() {
		List<Question> list = questionService.findAllQuestions();
		return list;
	}
	
	private Question setQuestionPropeties(final Question question) {
		question.getSubjectArea().setId(question.getSubjectId());
		return question;
	}
	
	@GetMapping(value = "/questions-per-subject/{subjectId}")
	public Collection<Question> getQuestionsBySubjectId(@PathVariable("subjectId") long subjectId) {
		List<Question> list = questionService.getQuestionsBySubjectId(subjectId);
		return list;
	}

	@GetMapping(value = "/select-subjects")
	public Collection<DropdownDto> getSubjectAreaSelectList() {
		List<DropdownDto> list = subjectService.getSubjectDropdownList();
		return list;
	}
	
	@PostMapping(value = "/questions-per-criteria")
	public Collection<Question> getQuestionDetailsByCriteria(@RequestBody SearchCriteria criteria) {
		List<Question> list = questionService.getQuestionDetailsByCriteria(criteria);
		return list;
	}
}
