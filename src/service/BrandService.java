package service;

import config.DBConfig;
import javax.swing.*;
import Exception.AppException;
import Model.Brand;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandService {
	private final DBConfig dbConfig = new DBConfig();
	//private ProductRepo productRepo;
	/*
	 * public void setProductRepo(ProductRepo productRepo) { this.productRepo =
	 * productRepo; }
	 */
	public int saveBrand(Brand brand) {
		int status=0;
		try {
			PreparedStatement ps = this.dbConfig.getConnection()
					.prepareStatement("INSERT INTO pos_2022.brand (brandName) VALUES (?);");

			ps.setString(1, brand.getName());
			status=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateBrand(String id, Brand brand) {
		int status=0;
		try {
			PreparedStatement ps = this.dbConfig.getConnection()
					.prepareStatement("UPDATE pos_2022.brand SET brandName = ? WHERE brand_id = ?");

			ps.setString(1, brand.getName());
			ps.setString(2, id);
			status=ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public List<Brand> findAllBrands() {
		List<Brand> brandList = new ArrayList<>();

		try (Statement st = this.dbConfig.getConnection().createStatement()) {

			String query = "SELECT * FROM pos_2022.brand order by brandName";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Brand brand = new Brand();
				brand.setId(rs.getInt("brand_id"));
				brand.setName(rs.getString("brandName"));
				brandList.add(brand);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return brandList;
	}

	public Brand findById(String id) {
		Brand brand = new Brand();

		try (Statement st = this.dbConfig.getConnection().createStatement()) {

			String query = "SELECT * FROM pos_2022.brand WHERE brand_id = " + id + ";";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				brand.setId(rs.getInt("brand_id"));
				brand.setName(rs.getString("brandName"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return brand;
	}

	public int delete(String id) {
		int status=0; 
		try {
		//	List<Product> productsByCategoryId = this.productRepo.findProductsByBrandId(id);
		/*
		 * if (productsByCategoryId.size() > 0) { throw new
		 * AppException("This brand cannot be deleted"); }
		 */
			String query = "DELETE FROM pos_2022.brand WHERE brand_id = ?";
			PreparedStatement ps = this.dbConfig.getConnection().prepareStatement(query);
			ps.setString(1, id);
			status=ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			if (e instanceof AppException)
				JOptionPane.showMessageDialog(null, e.getMessage());
			else
				e.printStackTrace();
		}
		
		return status;
	}
}
