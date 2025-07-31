package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectionFactory.ConnectionDatabase;
import model.Funcionario;

public class FuncionarioDAO {

	public void create(Funcionario funcionario) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE Funcionario SET nomeFuncionario = ?, cpfFuncionario = ?, dataNasc = ?, "
					+ "telefone = ?, endereco = ?, email = ?, cargo = ?, nivel = ? WHERE cpfFuncionario = ?");
			stmt.setString(1, funcionario.getNomeFuncionario());
			stmt.setString(2, funcionario.getCpfFuncionario());
			stmt.setString(3, funcionario.getDataNasc());
			stmt.setString(4, funcionario.getTelefone());
			stmt.setString(5, funcionario.getEndereco());
			stmt.setString(6, funcionario.getEmail());
			stmt.setString(7, funcionario.getCargo());
			stmt.setString(8, funcionario.getNivel());
			stmt.setString(9, funcionario.getCpfFuncionario());

			stmt.execute();
			System.out.println("Funcionário cadastrado!");

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao cadastrar funcionário!", e);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}

	public ArrayList<Funcionario> search(String pesquisar) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		pesquisar = "%" + pesquisar + "%";
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Funcionario WHERE nomeFuncionario LIKE ? OR cpfFuncionario LIKE ?");
			stmt.setString(1, pesquisar);
			stmt.setString(2, pesquisar);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getString("idFuncionario"));
				funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));
				funcionario.setCpfFuncionario(rs.getString("cpfFuncionario"));
				funcionario.setDataNasc(rs.getString("dataNasc"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setEndereco(rs.getString("endereco"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setCargo(rs.getString("cargo"));
				funcionario.setNivel(rs.getString("nivel"));

				funcionarios.add(funcionario);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar funcionários!", e);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return funcionarios;
	}
}
