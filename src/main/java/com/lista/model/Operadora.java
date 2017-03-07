package com.lista.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * Created by ceb on 30/04/16.
 */
@Entity
@Table(name = "OPERADORA")
public class Operadora {

    @Id
    private Integer codigo;

    
    @NotNull
    @Column(name="NOME")
    private String nome;

    
    Operadora() {
        // default constructor
    }

    public Operadora(Integer codigo, String nome) {
		//super();
		this.codigo = codigo;
		this.nome = nome;
	}
    
    public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
