package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStandardDao;
import fr.adaming.model.ClasseStandard;

@Service
@Transactional
public class ClasseStandardServiceImpl implements IClasseStandardService {

	@Autowired
	private IClasseStandardDao classeStandardDao;
	
	public int addClasseStandard(ClasseStandard cs) {

		return classeStandardDao.addClasseStandard(cs);
	}

	public List<ClasseStandard> getAllClasseStandard() {
		
		return classeStandardDao.getAllClasseStandard();
	}

	public int updateClasseStandard(ClasseStandard cs) {
		
		return classeStandardDao.updateClasseStandard(cs);
	}

	public int deleteClasseStandard(int code) {
		
		return classeStandardDao.deleteClasseStandard(code);
	}

	public ClasseStandard getByIdClasseStandard(int code) {
		
		return classeStandardDao.getByIdClasseStandard(code);
	}

}
