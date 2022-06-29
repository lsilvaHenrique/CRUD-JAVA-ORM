package application.model.builder;

import application.model.Imovel;

public class ImovelBuilder {
	private Imovel imovel;
	
	public ImovelBuilder() {
		this.imovel = new Imovel();
	}
	
	public static ImovelBuilder builder() {
		return new ImovelBuilder();
	}
	
	public ImovelBuilder addCodigo(int codigo) {
		this.imovel.setCodigo(codigo);
		
		return this;
	}
	
	public ImovelBuilder addEndereco(String endereco) {
		this.imovel.setEndereco(endereco);
		
		return this;
	}
	
	public ImovelBuilder addBairro(String bairro) {
		this.imovel.setBairro(bairro);
		
		return this;
	}
	
	public ImovelBuilder addCep(String cep) {
		this.imovel.setCep(cep);
		
		return this;
	}
	
	
	public Imovel get() {
		return this.imovel;
	}
}

