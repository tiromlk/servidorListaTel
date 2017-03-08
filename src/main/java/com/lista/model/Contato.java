package com.lista.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by ceb on 30/04/16.
 */
@Entity
@Table(name = "CONTATO")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@NotNull
    @Column(name="SERIAL")
    private String serial;
    
    @NotNull
    @Column(name="NOME")
    private String nome;

    @NotNull
    @Column(name="DATA")
    private Timestamp data;
    
    @NotNull
    @Column(name="TELEFONE")
    private String telefone;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Operadora operadora;
    
    // @JoinColumns({@JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = true)})
    

    Contato() {
        // default constructor
    }

    public Contato(String nome, Timestamp data, String telefone, Operadora operadora, Integer id) {
    	//this.id = id;
        this.nome = nome;
        this.data = data;
        this.operadora = operadora;
        this.telefone = telefone;
    }

   
    
    public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Operadora getOperadora() {
		return this.operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}
}
