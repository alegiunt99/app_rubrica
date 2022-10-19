package com.spring.apprubrica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.spring.apprubrica.entity.Rubrica;

@Repository
public class RubricaDAOImp implements RubricaDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean insertRubrica(Rubrica r) {
		
		manager.persist(r);
		
		return true;
	}

	@Override
	public Rubrica selectRubrica(int id) {
		
		Rubrica r = manager.find(Rubrica.class, id);
		
		return r;
	}

	@Override
	public boolean deleteRubrica(int id) {
		
		Rubrica r = manager.find(Rubrica.class, id);
		
		manager.remove(r);
		
		return true;
	}

	@Override
	public Rubrica selectRubricaByProprietario(String proprietario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rubrica> selectRubricheByDataCreazione(String proprietario) {
		// TODO Auto-generated method stub
		return null;
	}

}
