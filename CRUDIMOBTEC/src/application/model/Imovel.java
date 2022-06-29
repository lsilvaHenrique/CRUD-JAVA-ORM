package application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "imovel")
public class Imovel {

	@Id
	@Column(name = "codigo")
	@NotNull
	private int codigo;
	
	@Column(name = "endereco", length = 100)
	@NotNull
	private String endereco;
	
	@Column(name = "bairro", length = 50)
	@NotNull
	private String bairro;
	
	@Column(name = "cep", length = 50)
	@NotNull
	private String cep;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Imovel [codigo=" + codigo + ", nome=" + endereco + ", bairro=" 
				+ bairro + ", cep=" + cep + "]";
	}
	
}
