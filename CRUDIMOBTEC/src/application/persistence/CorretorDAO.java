package application.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import application.model.Corretor;
import application.model.Imovel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;


public class CorretorDAO implements ICorretorDAO {
    
	private SessionFactory sf;
    
    public CorretorDAO(SessionFactory sf) {
    	this.sf = sf;
    }
	
    @Override
	public void insereCorretor(Corretor c) throws SQLException {
    	EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(c);
		transaction.commit();
	}
	
	@Override
	public void atualizaCorretor(Corretor c) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(c);
		transaction.commit();
	}
	@Override
	public void excluiCorretor(Corretor c) throws SQLException {
		String sql = "DELETE FROM corretor WHERE creci = ?";
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, c.getCreci());
		query.executeUpdate();
		transaction.commit();
	}
	@Override
	public Corretor buscarCorretor(Corretor c) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		c = entityManager.find(Corretor.class, c.getCreci());
		return c;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Corretor> buscarCorretores() throws SQLException {
		List<Corretor> corretores = new ArrayList<Corretor>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.creci, c.nome, c.regiao, c.telefone, ");
		sql.append("i.codigo, i.endereco, i.bairro, i.cep ");
		sql.append("FROM corretor c, imovel i ");
		sql.append("WHERE c.codigo = i.codigo");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> listCorretores = query.getResultList();
		for (Object[] linha : listCorretores) {
			Corretor c = new Corretor();
			c.setCreci(linha[0].toString());
			c.setNome(linha[1].toString());
			c.setRegiao(linha[2].toString());
			c.setTelefone(linha[3].toString());
			
			Imovel i = new Imovel();
			i.setCodigo((int) linha[4]);
			i.setEndereco(linha[5].toString());
			i.setBairro(linha[6].toString());
			i.setCep(linha[7].toString());
			
	
			c.setImovel(i);
			
			corretores.add(c);
		}
		return corretores;
	}
}


