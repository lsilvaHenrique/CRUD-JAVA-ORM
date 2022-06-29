package application.persistence;

import application.model.Imovel;
import java.sql.SQLException;
import java.util.List;

public interface IImovelDAO {
	public void insereImovel(Imovel i) throws SQLException;
	public void atualizaImovel(Imovel i) throws SQLException;
	public void excluiImovel(Imovel i) throws SQLException;
	public Imovel buscarImovel(Imovel i) throws SQLException;
	public List<Imovel> buscarImoveis() throws SQLException;
}
