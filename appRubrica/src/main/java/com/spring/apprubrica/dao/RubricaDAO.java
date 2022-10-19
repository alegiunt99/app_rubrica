package com.spring.apprubrica.dao;

import java.util.List;

import com.spring.apprubrica.entity.Rubrica;

public interface RubricaDAO {
	
	public boolean insertRubrica(Rubrica r);
	
	public Rubrica selectRubrica(int id);
	
	public boolean deleteRubrica(int id);
	
	public Rubrica selectRubricaByProprietario(String proprietario);
	
	public List<Rubrica> selectRubricheByDataCreazione(String proprietario);
}
