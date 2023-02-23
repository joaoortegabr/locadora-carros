package edu.sinqia.joaoortegabr.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_locacao")
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data", nullable = false)
	private LocalDate data;
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "carro_id", nullable = false)
	private Carro carro;
	@Column(nullable = false)
	private Double kmRodados;
	@ManyToOne
	@JoinColumn(name = "retirada_loja_id", nullable = false)
	private Loja retiradoNaLoja;
	@ManyToOne
	@JoinColumn(name = "entrega_loja_id", nullable = false)
	private Loja entregueNaLoja;
	
	public Locacao() {
	}

	public Locacao(Long id, LocalDate data, Carro carro, Cliente cliente, Double kmRodados, Loja retiradoNaLoja, Loja entregueNaLoja) {
		this.id = id;
		this.data = data;
		this.carro = carro;
		this.cliente = cliente;
		this.kmRodados = kmRodados;
		this.retiradoNaLoja = retiradoNaLoja;
		this.entregueNaLoja = entregueNaLoja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getKmRodados() {
		return kmRodados;
	}

	public void setKmRodados(Double kmRodados) {
		this.kmRodados = kmRodados;
	}

	public Loja getRetiradoNaLoja() {
		return retiradoNaLoja;
	}

	public void setRetiradoNaLoja(Loja retiradoNaLoja) {
		this.retiradoNaLoja = retiradoNaLoja;
	}

	public Loja getEntregueNaLoja() {
		return entregueNaLoja;
	}

	public void setEntregueNaLoja(Loja entregueNaLoja) {
		this.entregueNaLoja = entregueNaLoja;
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
		Locacao other = (Locacao) obj;
		return Objects.equals(id, other.id);
	}
	
}
