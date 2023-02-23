package edu.sinqia.joaoortegabr.entities;

import java.io.Serializable;
import java.util.Objects;

import edu.sinqia.joaoortegabr.enums.Cor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carro")
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String modelo;
	@ManyToOne
	@JoinColumn(name = "montadora_id", nullable = false)
	private Montadora montadora;
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Cor cor;
	private Double kmAtual;
	private Boolean isAlugado;
	@ManyToOne
	@JoinColumn(name = "loja_atual", nullable = false)
	private Loja lojaAtual;
	
	public Carro() {
	}

	public Carro(Long id, String modelo, Montadora montadora, Categoria categoria, Cor cor, Loja lojaAtual) {
		this.id = id;
		this.modelo = modelo;
		this.montadora = montadora;
		this.categoria = categoria;
		this.cor = cor;
		this.kmAtual = 0.0;
		this.isAlugado = false;
		this.lojaAtual = lojaAtual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Montadora getMontadora() {
		return montadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Double getKmAtual() {
		return kmAtual;
	}

	public void setKmAtual(Double kmAtual) {
		this.kmAtual = kmAtual;
	}
	
	public Boolean getIsAlugado() {
		return isAlugado;
	}

	public void setIsAlugado(Boolean isAlugado) {
		this.isAlugado = isAlugado;
	}

	public Loja getLojaAtual() {
		return lojaAtual;
	}

	public void setLojaAtual(Loja lojaAtual) {
		this.lojaAtual = lojaAtual;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}	
	
}
