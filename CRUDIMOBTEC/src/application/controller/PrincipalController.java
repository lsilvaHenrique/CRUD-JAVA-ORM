package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import application.persistence.CorretorDAO;
import application.persistence.ImovelDAO;
import application.util.HibernateUtil;

import java.sql.SQLException;

import org.hibernate.SessionFactory;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class PrincipalController {
	@FXML
	private TextField tfidImovel;
	@FXML
	private TextField tfEnderecoImov;
	@FXML
	private Button btnInserirImovel;
	@FXML
	private Button btnBuscarImovel;
	@FXML
	private Button btnAtualizarImovel;
	@FXML
	private Button btnExcluirImovel;
	@FXML
	private Button btnListarImovel;
	@FXML
	private TextArea taListaImoveis;
	@FXML
	private TextField tfBairro;
	@FXML
	private TextField tfCEP;
	@FXML
	private TextField tfidCorretor;
	@FXML
	private TextField tfNomeCorretor;
	@FXML
	private Button btnInserirCorretor;
	@FXML
	private Button btnBuscarCorretor;
	@FXML
	private Button btnAtualizarCorretor;
	@FXML
	private Button btnExcluirCorretor;
	@FXML
	private Button btnListarCorretor;
	@FXML
	private TextArea taListaCorretor;
	@FXML
	private TextField tfRegiaoCorretor;
	@FXML
	private TextField tfTelefoneCorretor;
	@FXML
	private TextField tfCodImovel;

	@FXML
	public void acaoImovel(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd); 
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		ImovelDAO iDao = new ImovelDAO(sf);
		
		IImovelController iCont = 
				new ImovelController(iDao,tfidImovel, tfEnderecoImov,
						 tfBairro, tfCEP, taListaImoveis, cmd); 
		try {
			if (cmd.contains("Inserir")) {
				iCont.saveImovel();
			}
			if (cmd.contains("Atualizar")) {
				iCont.updateImovel();
			}
			if (cmd.contains("Excluir")) {
				iCont.deleteImovel();
			}
			if (cmd.contains("Buscar")) {
				iCont.findImovel();
			}
			if (cmd.contains("Listar")) {
				iCont.findAllImovel();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@FXML
	public void acaoCorretor(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd); 
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		CorretorDAO cDao = new CorretorDAO(sf);
		ICorretorController cCont = 
				new CorretorController(cDao, tfidCorretor, tfNomeCorretor, 
				tfRegiaoCorretor, tfTelefoneCorretor, tfCodImovel, taListaCorretor, cmd);
		try {
			if (cmd.contains("Inserir")) {
				cCont.saveCorretor();
			}
			if (cmd.contains("Atualizar")) {
				cCont.updateCorretor();
			}
			if (cmd.contains("Excluir")) {
				cCont.deleteCorretor();
			}
			if (cmd.contains("Buscar")) {
				cCont.findCorretor();
			}
			if (cmd.contains("Listar")) {
				cCont.findAllCorretor();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
}
