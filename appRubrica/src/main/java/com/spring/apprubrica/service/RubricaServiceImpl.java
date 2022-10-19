package com.spring.apprubrica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.apprubrica.dao.RubricaDAO;
import com.spring.apprubrica.dto.ContattoDTO;
import com.spring.apprubrica.dto.RubricaDTO;
import com.spring.apprubrica.entity.Contatto;
import com.spring.apprubrica.entity.IndirizzoContatto;
import com.spring.apprubrica.entity.Rubrica;

@Service
@Transactional
public class RubricaServiceImpl implements RubricaService {
	
	@Autowired
	private RubricaDAO daoR;
	
	@Override
	public boolean creaRubrica(Rubrica r) {
		
		return daoR.insertRubrica(r);
	}

	@Override
	public Rubrica stampaRubrica(int id) {
		
		return daoR.selectRubrica(id);
	}

	@Override
	public boolean creaContatto(Contatto c, int idRubrica) {
		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		r.inserisciContatto(c);
		
		return true;
	}

	@Override
	public boolean modificaContatto(int idContatto, Contatto newContatto, int idRubrica) {
		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		r.modificaContatto(newContatto);
		
		return true;
	}

	@Override
	public boolean eliminaContatto(int idContatto, int idRubrica) {
		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		r.cancellaContatto(idContatto);
		
		return true;
	}

	@Override
	public List<Contatto> stampaTuttiContatti(int idRubrica) {
		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		
		
		return r.ricercaTuttiContatti();
	}

	@Override
	public int contaTuttiContatti(int idRubrica) {

		Rubrica r = daoR.selectRubrica(idRubrica);
		
		return r.calcolaQuantiContatti();
	}

	@Override
	public Contatto cercaContattoByNomeCognome(String nome, String cognome, int idRubrica) {

		Rubrica r = daoR.selectRubrica(idRubrica);
		
		
		return r.cercaContattoByNomeCongome(nome, cognome);
	}

	@Override
	public Contatto cercaContattoByNumero(String numero, int idRubrica) {

		Rubrica r = daoR.selectRubrica(idRubrica);
		
		return r.cercaContattoByNumero(numero);
	}

	@Override
	public List<ContattoDTO> cercaNomeCognomeByGruppo(String gruppo, int idRubrica) {
		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		return r.cercaNomeCognomeByGruppo(gruppo);
	}

	@Override
	public int contaContattiByGruppo(String gruppo, int idRubrica) {
		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		return r.cercaQuantiContattiByGruppo(gruppo);
	}

	@Override
	public boolean modificaGruppo(String vecchioGruppo, String nuovoGruppo, int idRubrica) {

		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		return r.modificaNomeGruppo(vecchioGruppo, nuovoGruppo);
	}

	@Override
	public boolean eliminaGruppo(String gruppo, int idRubrica) {
		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		return r.deleteGruppo(gruppo);
	}

	@Override
	public boolean setContattoPreferito(int idContatto, int idRubrica) {
		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		r.setContattoPreferito(idContatto);
		
		return true; 
	}

	@Override
	public List<Contatto> selectAllPreferiti(int idRubrica) {
		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		return r.findAllPreferiti();
	}

	@Override
	public boolean modificaProprietario(String nuovoProp, String vecchioProp, int idRubrica) {
		

		Rubrica r = daoR.selectRubrica(idRubrica);
		
		if(r.getProprietario().equals(vecchioProp)) {
			

			r.setProprietario(nuovoProp);
			return true;
			
		}
		
		
		return false;
	}

	
	@Override
	public boolean cancellaRubrica(int idRubrica) {
		
		return daoR.deleteRubrica(idRubrica);
	}

	@Override
	public RubricaDTO stampaRubricaCensurata(int idRubrica) {
		
		Rubrica r = daoR.selectRubrica(idRubrica);
		
		RubricaDTO rubricaC = new RubricaDTO();
		rubricaC.setNome(r.getProprietario());
		rubricaC.setAnnoCreazione(r.getAnnoCreazione());
		rubricaC.setQuantiContatti(r.calcolaQuantiContatti());
		
		return rubricaC;
	}

//	
//	@Override
//	public Rubrica cercaRubricaByAnnoCreazione(int anno) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean modificaDataCreazione(int nuovaData, int vecchiaData, int idRubrica) {
		

		Rubrica r = daoR.selectRubrica(idRubrica);
		
		if(r.getAnnoCreazione() == vecchiaData) {
			
			r.setAnnoCreazione(nuovaData);
			
			return true;
		}
		
		
		return false;
	}

	@Override
	public boolean aggiungiIndirizzo(IndirizzoContatto indirizzo, int idContatto, int idRubrica) {


		Rubrica r = daoR.selectRubrica(idRubrica);
		
		for(Contatto c : r.getContatti()) {
			
			if (c.getId() == idContatto) {
				
				c.getIndirizzi().add(indirizzo);
				
				return true;
			}
			
		}
		
		return false;
	}

	@Override
	public boolean modificaIndirizzo(IndirizzoContatto indirizzo, int idContatto, int idRubrica) {
		
Rubrica r = daoR.selectRubrica(idRubrica);
		
		for(Contatto c : r.getContatti()) {
			
			if (c.getId() == idContatto) {
				
				c.modificaIndirizzo(indirizzo);
				
				return true;
			}
			
		}
		
		return false;
		
	}
	
	

}
