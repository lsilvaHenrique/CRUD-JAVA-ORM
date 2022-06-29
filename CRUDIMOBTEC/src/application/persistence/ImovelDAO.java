package application.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import application.model.Imovel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class ImovelDAO implements IImovelDAO {

	private SessionFactory sf;
    
    public ImovelDAO(SessionFactory sf) {
    	this.sf = sf;
    }
	
    @Override
	public void insereImovel(Imovel i) throws SQLException {
    	EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(i);
		transaction.commit();
	}
	
	@Override
	public void atualizaImovel(Imovel i) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(i);
		transaction.commit();
	}
	@Override
	public void excluiImovel(Imovel i) throws SQLException {
		//String sql = "DELETE FROM imovel WHERE codigo = ?";
		//EntityManager entityManager = sf.createEntityManager();
		//EntityTransaction transaction = entityManager.getTransaction();
		//transaction.begin();
		//Query query = entityManager.createNativeQuery(sql);
		//query.setParameter(1, i.getCodigo());
		//query.executeUpdate();
		//transaction.commit();;
		EntityManager entityManager = sf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(i);
		entityManager.getTransaction().commit();
	}
	@Override
	public Imovel buscarImovel(Imovel i) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		i = entityManager.find(Imovel.class, i.getCodigo());
		return i;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Imovel> buscarImoveis() throws SQLException {
		List<Imovel> imoveis = new ArrayList<Imovel>();
		String sql = "SELECT codigo, endereco, bairro, cep FROM imovel";
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> listImoveis = query.getResultList();
		for (Object[] linha : listImoveis) {
			Imovel i = new Imovel();
			i.setCodigo((int) linha[0]);
			i.setEndereco(linha[1].toString());
			i.setBairro(linha[2].toString());
			i.setCep(linha[3].toString());
			
			imoveis.add(i);
		}
		return imoveis;
	}	
}


