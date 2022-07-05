package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import config.DBConfig;

public class CategoryService {

	private final DBConfig dbConfig = new DBConfig();

	public int saveCategory(Model.Category category) {
		int status=0;
		try {

			PreparedStatement ps = this.dbConfig.getConnection()
					.prepareStatement("INSERT INTO pos_2022.Category (categoryName)  VALUES (?);");

			ps.setString(1, category.getName());
			status=ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateCategory(String id, Model.Category category) {
		int status=0;
		try {

			PreparedStatement ps = this.dbConfig.getConnection()
					.prepareStatement("UPDATE pos_2022.Category SET categoryName = ? WHERE category_id = ?");

			ps.setString(1, category.getName());
			ps.setString(2, id);
			status=ps.executeUpdate();

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Model.Category> findAllCategories() {

		List<Model.Category> categoryList = new ArrayList<>();
		try (Statement st = this.dbConfig.getConnection().createStatement()) {

			String query = "SELECT * FROM pos_2022.Category";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Model.Category c = new Model.Category();
				c.setId((rs.getInt("category_id")));
				c.setName(rs.getString("categoryName"));
				categoryList.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categoryList;
	}

	public Model.Category findById(String id) {
		Model.Category category = new Model.Category();

		try (Statement st = this.dbConfig.getConnection().createStatement()) {

			String query = "SELECT * FROM pos_2022.Category WHERE category_id = " + id + ";";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("categoryName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return category;
	}

	public int deleteCategory(String id) {
		int status = 0;
		try {

			// List<Product> productsByCategoryId =
			// this.productRepo.findProductsByCategoryId(id);

			/*
			 * if (productsByCategoryId.size() > 0) { throw new
			 * AppException("This category cannot be deleted"); }
			 */

			String query = "DELETE FROM pos_2022.Category WHERE category_id= ?;";

			PreparedStatement ps = this.dbConfig.getConnection().prepareStatement(query);

			ps.setString(1, id);
			status = ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
