package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.SubjectDAO;
import kr.ac.hansung.model.CreditsPerSemester;
import kr.ac.hansung.model.Subject;

@Service
public class SubjectService {

	@Autowired
	private SubjectDAO subjectDao;

	public List<Subject> getCurrent() {
		return subjectDao.getOffers();
	}
	
	public List<CreditsPerSemester> getCreditsPerSemester() {
		return subjectDao.getCreditsPerSemester();
	}
	
	public boolean insert(Subject subject) {
		return subjectDao.insert(subject);
	}

}
