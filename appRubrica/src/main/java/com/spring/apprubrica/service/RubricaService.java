package com.spring.apprubrica.service;

import java.util.List;

import com.spring.apprubrica.dto.ContattoDTO;
import com.spring.apprubrica.dto.RubricaDTO;
import com.spring.apprubrica.entity.Contatto;
import com.spring.apprubrica.entity.IndirizzoContatto;
import com.spring.apprubrica.entity.Rubrica;

public interface RubricaService {
	
	public boolean creaRubrica(Rubrica r);
	
	public Rubrica stampaRubrica(int id);
	
	public boolean creaContatto(Contatto c, int idRubrica);
	
	public boolean modificaContatto(int idContatto, Contatto newContatto, int idRubrica);

	public boolean eliminaContatto(int idContatto, int idRubrica);

	public List<Contatto> stampaTuttiContatti(int idRubrica);
	
	public int contaTuttiContatti(int idRubrica);

	public Contatto cercaContattoByNomeCognome(String nome, String cognome, int idRubrica);

	public Contatto cercaContattoByNumero(String numeroC, int idRubrica);

	public List<ContattoDTO> cercaNomeCognomeByGruppo(String gruppo, int idRubrica);

	public int contaContattiByGruppo(String gruppo, int idRubrica);
	
	public boolean modificaGruppo(String vecchioGruppo, String nuovoGruppo, int idRubrica);
	
	public boolean eliminaGruppo(String gruppo, int idRubrica);
	
	public boolean setContattoPreferito(int idContatto, int idRubrica);
	
	public List<Contatto> selectAllPreferiti(int idRubrica);
	
	public boolean modificaProprietario(String nuovoProp, String vecchioProp, int idRubrica);

	boolean modificaDataCreazione(int nuovaData, int vecchiaData, int idRubrica);
	
	public boolean cancellaRubrica(int idRubrica);
	
	public RubricaDTO stampaRubricaCensurata(int idRubrica);
	
	public boolean aggiungiIndirizzo(IndirizzoContatto indirizzo, int idContatto, int idRubrica);

	public boolean modificaIndirizzo(IndirizzoContatto indirizzo, int idContatto, int idRubrica);
	
//	public Rubrica cercaRubricaByProprietario(String proprietario);
//	
//	public Rubrica cercaRubricaByAnnoCreazione(int anno);

	
	
}
