package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStandard;

public interface IClasseStandardService {

	public int addClasseStandard(ClasseStandard cs);
	public List<ClasseStandard> getAllClasseStandard();
	public int updateClasseStandard(ClasseStandard cs);
	public int deleteClasseStandard(int code);
	public ClasseStandard getByIdClasseStandard(int code);

}
