package com.lis.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lis.exam.dao.SubjectDao;
import com.lis.exam.entity.SubjectArea;
import com.lis.exam.utils.DropdownDto;

@Service
@Transactional
public class SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;

	public List<SubjectArea> findAllSubjects() {
		return subjectDao.findAllSubjects();
	}

	public void save(SubjectArea subject) {
		subjectDao.save(subject);
	}

	public List<DropdownDto> getSubjectDropdownList() {
		return subjectDao.getSubjectDropdownList();
	}

}
