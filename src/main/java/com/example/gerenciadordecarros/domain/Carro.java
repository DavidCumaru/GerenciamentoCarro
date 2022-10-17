package com.example.gerenciadordecarros.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "carros")
public class Carro implements Serializable {

    private static final long serialVersionUID = 1848135320742265025L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modelo;

    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;
    
    @OneToOne
    @JoinColumn(name = "id_documento")
    private Documento documento;
    
    @OneToOne
    @JoinColumn(name = "id_chave")
    private Chave chave;
    
    @ManyToMany
    @JoinTable(name = "carro_acessorio", joinColumns = { @JoinColumn(name = "carro_id") }, inverseJoinColumns = { @JoinColumn(name = "acessorio_id") })
    private List<Acessorio> acessorios;

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
}
