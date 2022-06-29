package application.controller;

import java.sql.SQLException;

public interface ICorretorController {
	public void saveCorretor  () throws SQLException;
	public void updateCorretor() throws SQLException;
	public void deleteCorretor() throws SQLException;
	public void findCorretor () throws SQLException;
	public void findAllCorretor () throws SQLException;

}
