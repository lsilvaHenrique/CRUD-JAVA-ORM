package application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name = "corretor")
@Entity
public class Corretor {
	
	@Id
	@Column(name = "creci")
	@NotNull
	private String creci;

	@Column(name = "nome", length = 100)
	@NotNull
	private String nome;

	@Column(name = "regiao", length = 60)
	@NotNull
	private String regiao;

	@Column(name = "telefone", length = 11)
	@NotNull
	private String telefone;
	
	@ManyToOne(targetEntity = Imovel.class)
	@JoinColumn(name = "codigo")
	@NotNull
	private Imovel imovel;

	public String getCreci() {
		return creci;
	}

	public void setCreci(String creci) {
		this.creci = creci;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	@Override
	public String toString() {
		return "Corretor [creci=" + creci + ", nome=" + nome + ", regiao=" 
			+ regiao + ", telefone=" + telefone + ", imovel=" + imovel + "]";
	}
	
	
}
