package com.lista.controller;

import com.lista.model.Contato;
import com.lista.model.Operadora;
import com.lista.repository.ContatoRepository;
import com.lista.repository.OperadoraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by ceb on 30/04/16.
 */
@RestController
@RequestMapping("/listatelefonica")
public class DatabaseController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private OperadoraRepository operadoraRepository;

    @CrossOrigin()
    @RequestMapping(method = RequestMethod.POST)
    public String cadastraMassaDeDados() {
    	
    	Date dateSql = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    	Timestamp date = new Timestamp(dateSql.getTime());
    	


        List<Operadora> operadoras = new ArrayList<Operadora>();
        Operadora embratel = new Operadora (21l, "Embratel");
        operadoras.add(embratel);
        Operadora tim = new Operadora (15l, "TIM");
        operadoras.add(tim);
        Operadora oi= new Operadora (14l, "OI");
        operadoras.add(oi);
        operadoraRepository.save(operadoras);
        embratel.setNome("atualizado");

    	
    	List<Contato> contatos = new ArrayList<Contato>();
        Contato fabio = new Contato("Fabio", date, "98432-6690", embratel , 1);
        
        contatoRepository.save(fabio);

        return "Sucesso na criação da massa de dados\n";
    }

    @CrossOrigin()
    @RequestMapping(method = RequestMethod.POST, value = "/contatos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> cadastrarContato(@RequestBody Contato contato) {
    	
		return new ResponseEntity<>(this.contatoRepository.save(contato), HttpStatus.OK);
	}
    
    @CrossOrigin()
    @RequestMapping(method = RequestMethod.DELETE, value = "/contatos/{id}")
	public ResponseEntity<Contato> excluirContato(@RequestBody Long id) {
    
    	return new ResponseEntity<>(this.contatoRepository.deleteById(id), HttpStatus.OK);
	}
    
    @CrossOrigin()
	@RequestMapping(method = RequestMethod.GET, value = "/contatos/{id}")
	public ResponseEntity<Contato> buscarContato(@PathVariable String id) {
		return new ResponseEntity<>(this.contatoRepository.findById(new Long(id)), HttpStatus.OK);
	}

    @CrossOrigin()
	@RequestMapping(value = "/contatos", method = RequestMethod.GET )
	public ResponseEntity<List<Contato>> buscaContatos() {
		return new ResponseEntity<>(this.contatoRepository.findAll(), HttpStatus.OK);
	}
    
    @CrossOrigin()	
	@RequestMapping(value = "/operadoras", method = RequestMethod.GET)
	public ResponseEntity<List<Operadora>> buscaOperadoras() {
		return new ResponseEntity<>(this.operadoraRepository.findAll() , HttpStatus.OK);
	}
    
}
