package application.persistence;

import application.model.Corretor;
import java.sql.SQLException;
import java.util.List;

public interface ICorretorDAO {
	public void insereCorretor(Corretor i) throws SQLException;
	public void atualizaCorretor(Corretor i) throws SQLException;
	public void excluiCorretor(Corretor i) throws SQLException;
	public Corretor buscarCorretor(Corretor i) throws SQLException;
	public List<Corretor> buscarCorretores() throws SQLException;
}
