package application.controller;

import java.sql.SQLException;
import java.util.List;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import application.model.Imovel;
import application.persistence.ImovelDAO;



public class ImovelController implements IImovelController{
	
	private ImovelDAO iDao;
	private TextField tfidImovel;
	private TextField tfEnderecoImov;
	private TextField tfBairro;
	private TextField tfCEP;
	private TextArea taListaImoveis;
	private String cmd;
	
	public ImovelController(ImovelDAO iDao,TextField tfidImovel, TextField tfEnderecoImov,
			TextField tfBairro,TextField tfCEP, TextArea taListaImoveis, String cmd) {
		this.iDao = iDao;
		this.tfidImovel = tfidImovel;
		this.tfEnderecoImov = tfEnderecoImov;
		this.taListaImoveis = taListaImoveis;
		this.tfBairro = tfBairro;
		this.tfCEP = tfCEP;
		this.cmd = cmd;
	}
	
	@Override
	public void saveImovel() throws SQLException {
		Imovel i = createImovel(cmd);
		iDao.insereImovel(i);
		clean();
	}

	@Override
	public void updateImovel() throws SQLException {
		Imovel i = createImovel(cmd);
		iDao.atualizaImovel(i);
		clean();
	}

	@Override
	public void deleteImovel() throws SQLException {
		Imovel i = createImovel(cmd);
		iDao.excluiImovel(i);
		clean();
	}

	@Override
	public void findImovel() throws SQLException {
		Imovel i = createImovel(cmd);
		i = iDao.buscarImovel(i);
		tfidImovel.setText(String.valueOf(i.getCodigo()));
		tfEnderecoImov.setText(i.getEndereco());
		tfBairro.setText(i.getBairro());
		tfCEP.setText(i.getCep());
		
	}

	@Override
	public void findAllImovel() throws SQLException {
		clean();
		List<Imovel> consultaImoveis = iDao.buscarImoveis();
		StringBuffer buffer = new StringBuffer();
		for (Imovel i : consultaImoveis) {
			buffer.append(i+"\n");
		}
		
		taListaImoveis.setText(buffer.toString());
	}
	
	private Imovel createImovel(String cmd) {
		Imovel c = new Imovel();
		if (cmd.contains("Inserir") || cmd.contains("Atualizar")) {
			c.setCodigo(Integer.parseInt(tfidImovel.getText()));
			c.setEndereco(tfEnderecoImov.getText());
			c.setBairro(tfBairro.getText());
			c.setCep(tfCEP.getText());
		}
		if (cmd.contains("Excluir") || cmd.contains("Buscar")) {
			c.setCodigo(Integer.parseInt(tfidImovel.getText()));
		}
		return c;
	}
	
	private void clean() {
		tfidImovel.setText("");
		tfEnderecoImov.setText("");
		tfBairro.setText("");
		tfCEP.setText("");
		taListaImoveis.setText("");
	}
	
}
