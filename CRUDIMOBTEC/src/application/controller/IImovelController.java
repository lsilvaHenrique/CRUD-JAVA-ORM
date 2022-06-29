package application.controller;

import java.sql.SQLException;

public interface IImovelController {
	public void saveImovel  () throws SQLException;
	public void updateImovel() throws SQLException;
	public void deleteImovel() throws SQLException;
	public void findImovel () throws SQLException;
	public void findAllImovel () throws SQLException;
}
