package application.controller;

import java.sql.SQLException;
import java.util.List;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import application.model.Corretor;
import application.model.Imovel;
import application.persistence.CorretorDAO;


public class CorretorController implements ICorretorController{
	
	private CorretorDAO cDao;
	private TextField tfidCorretor;
	private TextField tfNomeCorretor ;
	private TextField tfRegiaoCorretor;
	private TextField tfTelefoneCorretor;
	private TextField tfCodImovel;
	private TextArea taListaCorretor;
	private String cmd;
	
	public CorretorController(CorretorDAO cDao, TextField tfidCorretor, TextField tfNomeCorretor,TextField
			tfRegiaoCorretor,TextField tfTelefoneCorretor,TextField tfCodImovel, TextArea taListaCorretor, String cmd) {
		this.cDao = cDao;
		this.tfidCorretor= tfidCorretor;
		this.tfNomeCorretor = tfNomeCorretor;
		this.tfRegiaoCorretor = tfRegiaoCorretor;
		this.tfTelefoneCorretor = tfTelefoneCorretor;
		this.tfCodImovel = tfCodImovel;
		this.taListaCorretor = taListaCorretor;
		this.cmd = cmd;
	}

	@Override
	public void saveCorretor() throws SQLException {
		Corretor c = createCorretor();
		cDao.insereCorretor(c);
		clean();
	}

	@Override
	public void updateCorretor() throws SQLException {
		Corretor c = createCorretor();
		cDao.atualizaCorretor(c);
		clean();
	}

	@Override
	public void deleteCorretor() throws SQLException {
		Corretor c = createCorretor();
		cDao.excluiCorretor(c);
		clean();
	}

	@Override
	public void findCorretor() throws SQLException {
		Corretor c = createCorretor();
		c = cDao.buscarCorretor(c);
		tfidCorretor.setText(c.getCreci());
		tfNomeCorretor.setText(c.getNome());
		tfRegiaoCorretor.setText(c.getRegiao());
		tfTelefoneCorretor.setText(c.getTelefone());
		tfCodImovel.setText(String.valueOf(c.getImovel().getCodigo()));
	}

	@Override
	public void findAllCorretor() throws SQLException {
		clean();
		List<Corretor> consultaCorretores = cDao.buscarCorretores();
		StringBuffer buffer = new StringBuffer();
		for (Corretor c : consultaCorretores) {
			buffer.append(c+"\n");
	}
		taListaCorretor.setText(buffer.toString());
	}	
	
	private Corretor createCorretor() {
		Corretor c = new Corretor();
		if (cmd.contains("Inserir") || cmd.contains("Atualizar")) {
			c.setCreci(tfidCorretor.getText());
			c.setNome(tfNomeCorretor.getText());
			c.setRegiao(tfRegiaoCorretor.getText());
			c.setTelefone(tfTelefoneCorretor.getText());

			Imovel i = new Imovel();
			i.setCodigo(Integer.parseInt(tfCodImovel.getText()));

			c.setImovel(i);
		}
		if (cmd.contains("Excluir") || cmd.contains("Buscar")) {
			c.setCreci(tfidCorretor.getText());
		}

		return c;
	}
	
	private void clean() {
		tfidCorretor.setText("");
		tfNomeCorretor.setText("");
		tfRegiaoCorretor.setText("");
		tfTelefoneCorretor.setText("");
	}
}
