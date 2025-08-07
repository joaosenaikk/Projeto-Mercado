package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectionFactory.ConnectionDatabase;
import model.Venda;

public class VendaDAO {

	public void create(Venda venda) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO Venda (dataVenda, precoTotal, formaPagamento, quantidadeTotal) "
					+ "VALUES (?, ?, ?, ?)");
			stmt.setString(1, venda.getDataVenda());
			stmt.setDouble(2, venda.getPrecoTotal());
			stmt.setString(3, venda.getFormaPag());
			stmt.setInt(4, venda.getQuantTotal());

			stmt.execute();
			System.out.println("Venda registrada!");

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao registrar venda!", e);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}

	public ArrayList<Venda> search(String pesquisarData) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		pesquisarData = "%" + pesquisarData + "%";
		ArrayList<Venda> vendas = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Venda WHERE dataVenda LIKE ?");
			stmt.setString(1, pesquisarData);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Venda venda = new Venda();
				venda.setIdVenda(rs.getString("idVenda"));
				venda.setDataVenda(rs.getString("dataVenda"));
				venda.setPrecoTotal(rs.getDouble("precoTotal"));
				venda.setFormaPag(rs.getString("formaPagamento"));
				venda.setQuantTotal(rs.getInt("quantidadeTotal"));

				vendas.add(venda);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar vendas!", e);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return vendas;
	}
}
