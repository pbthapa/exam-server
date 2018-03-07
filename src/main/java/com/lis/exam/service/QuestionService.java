package com.lis.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lis.exam.dao.QuestionDao;
import com.lis.exam.entity.Question;
import com.lis.exam.utils.SearchCriteria;

@Service
@Transactional
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;

	public void save(Question question) {
		questionDao.save(question);
	}

	public List<Question> findAllQuestions() {
		return questionDao.findAllQuestions();
	}

	public List<Question> getQuestionsBySubjectId(long subjectId) {
		return questionDao.getQuestionsBySubjectId(subjectId);
	}

	public List<Question> getQuestionDetailsByCriteria(SearchCriteria criteria) {
		return questionDao.getQuestionDetailsByCriteria(criteria);
	}
}
