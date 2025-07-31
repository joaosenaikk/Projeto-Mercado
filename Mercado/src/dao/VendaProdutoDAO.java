package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectionFactory.ConnectionDatabase;
import model.VendaProduto;

public class VendaProdutoDAO {

	public void create(VendaProduto vp) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO VendaProduto (idVenda, idProduto, quantidade, valorTotal) "
					+ "VALUES (?, ?, ?, ?)");
			stmt.setString(1, vp.getIdVenda());
			stmt.setString(2, vp.getIdProduto());
			stmt.setInt(3, vp.getQuantidade());
			stmt.setDouble(4, vp.getValorTotal());

			stmt.execute();
			System.out.println("Item da venda registrado!");

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao registrar produto da venda!", e);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}

	public ArrayList<VendaProduto> search(String idVenda) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<VendaProduto> itens = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM VendaProduto WHERE idVenda = ?");
			stmt.setString(1, idVenda);

			rs = stmt.executeQuery();

			while (rs.next()) {
				VendaProduto vp = new VendaProduto();
				vp.setIdVenda(rs.getString("idVenda"));
				vp.setIdProduto(rs.getString("idProduto"));
				vp.setQuantidade(rs.getInt("quantidade"));
				vp.setValorTotal(rs.getDouble("valorTotal"));

				itens.add(vp);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar itens da venda!", e);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return itens;
	}
}
