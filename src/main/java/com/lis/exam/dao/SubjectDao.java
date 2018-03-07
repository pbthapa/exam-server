package com.lis.exam.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lis.exam.entity.SubjectArea;
import com.lis.exam.utils.DropdownDto;
import com.lis.exam.utils.GenericDaoHibernateImpl;

@Repository
public class SubjectDao extends GenericDaoHibernateImpl<SubjectArea, Serializable>{

	public List<SubjectArea> findAllSubjects() {
		final String hql = "from SubjectArea a";
		Query query = currentSession().createQuery(hql);
		return query.list();
	}

	public List<DropdownDto> getSubjectDropdownList() {
		final String hql = "select new com.lis.exam.utils.DropdownDto(a.id, a.subject, false) from SubjectArea a where a.active = true";
		Query query = currentSession().createQuery(hql);
		return query.list();
	}

}
