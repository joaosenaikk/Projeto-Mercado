package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectionFactory.ConnectionDatabase;
import model.Produto;

public class ProdutoDAO {

	public void create(Produto produto) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE Produto SET nomeProduto = ?, codBarra = ?, tipoUn = ?, "
					+ "dataFab = ?, dataVal = ?, precoUn = ?, estoque = ? WHERE codBarra = ?");
			stmt.setString(1, produto.getNomeProduto());
			stmt.setString(2, produto.getCodBarra());
			stmt.setString(3, produto.getTipoUn());
			stmt.setString(4, produto.getDataFab());
			stmt.setString(5, produto.getDataVal());
			stmt.setDouble(6, produto.getPrecoUn());
			stmt.setInt(7, produto.getEstoque());
			stmt.setString(8, produto.getCodBarra());

			stmt.execute();
			System.out.println("Produto cadastrado!");

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao cadastrar produto!", e);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}

	public ArrayList<Produto> search(String pesquisar) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		pesquisar = "%" + pesquisar + "%";
		ArrayList<Produto> produtos = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Produto WHERE nomeProduto LIKE ? OR codBarra LIKE ?");
			stmt.setString(1, pesquisar);
			stmt.setString(2, pesquisar);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setIdProduto(rs.getString("idProduto"));
				produto.setNomeProduto(rs.getString("nomeProduto"));
				produto.setCodBarra(rs.getString("codBarra"));
				produto.setTipoUn(rs.getString("tipoUn"));
				produto.setDataFab(rs.getString("dataFab"));
				produto.setDataVal(rs.getString("dataVal"));
				produto.setPrecoUn(rs.getDouble("precoUn"));
				produto.setEstoque(rs.getInt("estoque"));

				produtos.add(produto);
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar produtos!", e);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return produtos;
	}
}
