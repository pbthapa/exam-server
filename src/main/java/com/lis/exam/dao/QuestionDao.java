package com.lis.exam.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lis.exam.entity.Question;
import com.lis.exam.utils.GenericDaoHibernateImpl;
import com.lis.exam.utils.SearchCriteria;

@Repository
public class QuestionDao extends GenericDaoHibernateImpl<Question, Serializable> {

	public List<Question> findAllQuestions() {
		final String hql = "from Question a";
		Query query = currentSession().createQuery(hql);
		return query.list();
	}

	public List<Question> getQuestionsBySubjectId(long subjectId) {
		final String hql = "from Question a where a.subjectArea.id = :subjectId";
		Query query = currentSession().createQuery(hql);
		query.setParameter("subjectId", subjectId);
		return query.list();
	}

	public List<Question> getQuestionDetailsByCriteria(SearchCriteria criteria) {
		if(criteria == null) {
			return new ArrayList<>();
		}
		
		
		System.out.println(criteria.getIds() + ", " + criteria.getDifficultyLevels().length);
		
		final String hql = "from Question a where a.subjectArea.id in :subjectIds "
				+ "and a.level in :levels";
		Query query = currentSession().createQuery(hql);
		query.setParameterList("subjectIds", Arrays.stream(criteria.getIds().split(", ")).map(Long::parseLong).toArray());
		query.setParameterList("levels", criteria.getDifficultyLevels());
		List list = query.list();
		System.out.println("List Size " + list.size());
		return list;
	}

}
