package com.spring.apprubrica.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.apprubrica.dto.ContattoDTO;
import com.spring.apprubrica.dto.ErroreDTO;
import com.spring.apprubrica.dto.RubricaDTO;
import com.spring.apprubrica.entity.Contatto;
import com.spring.apprubrica.entity.IndirizzoContatto;
import com.spring.apprubrica.entity.Rubrica;
import com.spring.apprubrica.service.RubricaService;

@RestController
@RequestMapping("/rubrica")
public class RubricaController {
	
	@Autowired
	private RubricaService service;
	
	
	@PostMapping(path = "/insert", consumes = "application/json")
	public boolean creaRubrica(@RequestBody Rubrica r) {
		
		return service.creaRubrica(r);
		
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity stampaRubrica(@PathVariable int id) {
		
		
		
		try {
			
			ResponseEntity<Rubrica> re = new ResponseEntity<Rubrica>(service.stampaRubrica(id), HttpStatus.ACCEPTED);
			
			return re;
			
		} catch (Exception e) {
			
			ErroreDTO error = new ErroreDTO("Non esiste questa rubrica");
			
			ResponseEntity<ErroreDTO> re = new ResponseEntity<ErroreDTO>(error, HttpStatus.ACCEPTED);
			
			return re;
			
		}
		
	}
	
	@PostMapping(path = "/{idRubrica}", consumes = "application/json")
	public boolean creaContatto(@RequestBody Contatto c, @PathVariable int idRubrica){
	
		
		return service.creaContatto(c, idRubrica);
		
	}
	
	@PutMapping(path = "/{idRubrica}/{idContatto}", consumes = "application/json")
	public boolean modificaContatto(@RequestBody Contatto c, @PathVariable int idRubrica, @PathVariable int idContatto){
	
		
		return service.modificaContatto(idContatto, c, idRubrica);
		
	}
	
	@DeleteMapping(path = "/{idRubrica}/{idContatto}", consumes = "application/json")
	public boolean eliminaContatto(@PathVariable int idContatto, @PathVariable int idRubrica){
	
		
		return service.eliminaContatto(idContatto, idRubrica);
		
	}
	

	@GetMapping(path = "/{idRubrica}/contatti", consumes = "application/json")
	public List<Contatto> stampaContatti( @PathVariable int idRubrica){
	
		
		return service.stampaTuttiContatti(idRubrica);
		
	}
	
	@GetMapping(path = "/{idRubrica}/count", consumes = "application/json")
	public int numeroContatti( @PathVariable int idRubrica){
	
		
		return service.contaTuttiContatti(idRubrica);
		
	}
	
	@PostMapping(path = "/{idRubrica}/filterNomeCognome", consumes = "application/json", produces = "application/json")
	public Contatto filterContattoByNomeCognome(@RequestBody ContattoDTO contattonc, @PathVariable int idRubrica){
		
		System.out.println(contattonc.getNome() + " " +  contattonc.getCognome());
		
		
		
		return service.cercaContattoByNomeCognome(contattonc.getNome(), contattonc.getCognome(), idRubrica);
		
	}
	
	@PostMapping(path = "/{idRubrica}/filterNumero", consumes = "application/json", produces = "application/json")
	public Contatto filterContattoByNumero(@RequestBody ContattoDTO contatto, @PathVariable int idRubrica){
		
		System.out.println(contatto.getNumero());
		
		return service.cercaContattoByNumero(contatto.getNumero(), idRubrica);
		
	}
	
	@PostMapping(path = "/{idRubrica}/filterGruppo", produces = "application/json")
	public List<ContattoDTO> filterContattoByGruppo(@RequestParam String gruppo, @PathVariable int idRubrica){
		
		return service.cercaNomeCognomeByGruppo(gruppo, idRubrica);
		
	}
	
	@PostMapping(path = "/{idRubrica}/countGruppo", produces = "application/json")
	public int numeroContattiByGruppo(@RequestParam String gruppo, @PathVariable int idRubrica){
		
		return service.contaContattiByGruppo(gruppo, idRubrica);
		
	}
	
	@PutMapping(path = "/{idRubrica}/editGruppo", produces = "application/json")
	public boolean modificaGruppo(@RequestParam String nomeNuovo, @RequestParam String nomeVecchio, @PathVariable int idRubrica){
		
		return service.modificaGruppo(nomeVecchio, nomeNuovo, idRubrica);
		
	}
	
	@DeleteMapping(path = "/{idRubrica}/deleteGruppo")
	public boolean eliminaGruppo(@RequestParam String gruppo, @PathVariable int idRubrica){
		
		System.out.println(gruppo);
		
		return service.eliminaGruppo(gruppo, idRubrica);
		
	}
	
	
	@PatchMapping(path = "/{idRubrica}/setPreferito/{idContatto}")
	public boolean setPreferito(@PathVariable int idContatto, @PathVariable int idRubrica){
		
		
		return service.setContattoPreferito(idContatto, idRubrica);
		
	}
	
	@GetMapping(path = "/{idRubrica}/allPreferiti")
	public List<Contatto> setPreferito(@PathVariable int idRubrica){
		
		
		return service.selectAllPreferiti(idRubrica);
		
	}
	
	
	@DeleteMapping(path = "/{idRubrica}")
	public boolean eliminaRubrica(@PathVariable int idRubrica){
		
		
		return service.cancellaRubrica(idRubrica);
		
	}
	
	@GetMapping(path = "/censored/{idRubrica}", produces = "application/json")
	public RubricaDTO stampaRubricaCensurata(@PathVariable int idRubrica){
		
		
		return service.stampaRubricaCensurata(idRubrica);
		
	}
	
	@GetMapping(path = "/rubricaByProprietario", produces = "application/json")
	public Rubrica cercaRubricaByProprietario(@RequestParam String proprietario) {
		
		return null;
		
	}
	
	@PatchMapping(path = "/editProprietario/{idRubrica}")
	public boolean modificaProprietario(@RequestParam String vecchioProprietario,@RequestParam String nuovoProprietario, @PathVariable int idRubrica) {
		
		return service.modificaProprietario(nuovoProprietario, vecchioProprietario, idRubrica);
		
	}
	
	@GetMapping(path = "/rubricaByAnno", produces = "application/json")
	public List<Rubrica> cercaRubricheByAnnoCreazione(@RequestParam int anno) {
		
		return null;
		
	}
	
	@PatchMapping(path = "/editAnnoCreazione/{idRubrica}")
	public boolean modificaAnnoCreazione(@RequestParam  int vecchioAnno, @RequestParam  int nuovoAnno, @PathVariable int idRubrica) {
		
		return service.modificaDataCreazione(nuovoAnno, vecchioAnno, idRubrica);
		
	}
	
	@PostMapping(path = "/{idRubrica}/{idContatto}", produces = "application/json")
	public boolean aggiungiIndirizzo(@PathVariable int idRubrica, @PathVariable int idContatto, @RequestBody IndirizzoContatto indirizzo) {
		
		return service.aggiungiIndirizzo(indirizzo, idContatto, idRubrica);
		
	}
	
	@PutMapping(path = "/{idRubrica}/{idContatto}", produces = "application/json")
	public boolean modificaIndirizzo(@PathVariable int idRubrica, @PathVariable int idContatto, @RequestBody IndirizzoContatto indirizzo) {
		
		return service.modificaIndirizzo(indirizzo, idContatto, idRubrica);
		
	}
	
	// *************GESTIONE ERRORI*****************
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErroreDTO> gestoreErrori(Exception exc){
		
		ErroreDTO error = new ErroreDTO("Errore di Alex", "Controller");
		
		ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(error, HttpStatus.BAD_REQUEST);
		
		return response;
	}
	
//	
//	@GetMapping(path = "/{var}")
//	public int metodo(@PathVariable int var){
//		
//		int num = var;
//		
//		return num;
//		
//	}
//	
//	@GetMapping(path = "/leggistringa")
//	public String leggiString(){
//		
//		String mex = "Tutt' a post'";
//		
//		return mex;
//		
//	}
//
//	@GetMapping(path = "/leggiogetto", produces = "application/json")
//	public List<String> leggiOgetto(){
//		
//		List<String> list = new ArrayList<>();
//		
//		list.add("uno");
//		list.add("due");
//		list.add("tre");
//		
//		return list;
//		
//	}
//	
//	
//	@PostMapping(path = "/postogetto", consumes = "application/json")
//	public boolean postOgetto(@RequestBody List<String> lista) {
//		
//		System.out.println("Ogetto arrivato dal client");
//		
//		for(String s : lista) {
//			
//			System.out.println(s);
//			
//		}
//		
//		return true;
//	}
//	
//	@PostMapping(path = "/getpostogetto", consumes = "application/json", produces = "application/json")
//	public List<String> getEPostOgetto(@RequestBody List<String> lista) {
//		
//		List<String> nuovaLista = new ArrayList<>();
//		
//		
//		for(String s : lista) {
//			
//			nuovaLista.add(s.toUpperCase());
//			
//		}
//		
//		return nuovaLista;
//	}
//	
//	@GetMapping(path = "/metodoservice", produces = "application/json")
//	public String serviceMethod1() {
//		return this.service.servizio1();
//	}
//	
//	@PostMapping(path = "/somma", consumes = "application/json", produces = "application/json")
//	public NumberCoupleDTO somma(@RequestBody NumberCoupleDTO numeri) {
//		
//		return this.service.somma(numeri);
//	}
	
}
