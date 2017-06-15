package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.ClasseStandard;


public interface IClasseStandardDao {

		public int addClasseStandard(ClasseStandard cs);
		public List<ClasseStandard> getAllClasseStandard();
		public int updateClasseStandard(ClasseStandard cs);
		public int deleteClasseStandard(int code);
		public ClasseStandard getByIdClasseStandard(int code);
	

}
