package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import Model.Brand;
import TableModel.tableModel_Brand;
import View.View_Brand;

import service.BrandService;

public class BrandController implements ActionListener, ListSelectionListener {
	private View_Brand vBrand;
	private BrandService brandService;
	private Brand brand;
	static String temp_id;
	// static int temp_id;

	public BrandController() {
		dependencyInjection();
		initController();
		dataToView(brand);
	}

	private void dependencyInjection() {
		this.brandService = new BrandService();
		this.vBrand = new View_Brand();
	}

	private void initController() {
		vBrand.getbtnSave().addActionListener(this);
		vBrand.getbtnClear().addActionListener(this);
		vBrand.getbtnShow().addActionListener(this);
		vBrand.getbtnClose().addActionListener(this);
		vBrand.getbtnUpdate().addActionListener(this);
		vBrand.getbtnDelete().addActionListener(this);
		vBrand.getbtnEdit().addActionListener(this);
		vBrand.getTable().getSelectionModel().addListSelectionListener(this);
	}

	private void dataToView(Brand brand) {
		vBrand.getTxtName().setText(brand == null ? "" : brand.getName());
	}

	private void save() {
		brand = new Brand();
		brand.setName(vBrand.getTxtName().getText());

		int status = brandService.saveBrand(brand);
		if (status > 0) {
			alert("Successfully Saved!");
		} else {
			alert("Failed Save!");
		}
		brand = null;
		dataToView(brand);
	}

	private void show() {
		List<Brand> empList = new ArrayList<Brand>();
		empList = brandService.findAllBrands();
		AbstractTableModel model = new tableModel_Brand(empList);
		vBrand.getTable().setModel(model);
	}

	private void delete() {
		int status = brandService.delete(temp_id);
		if (status > 0) {
			alert("Successfully Deleted!");
		} else {
			alert("Delete Failed!");
		}
	}

	private void edit() {
		Brand brand = new Brand();
		brand = brandService.findById(temp_id);
		dataToView(brand);
	}

	private void update() {
		brand = new Brand();
		brand.setName(vBrand.getTxtName().getText());
		int status = brandService.updateBrand(temp_id, brand);
		if (status > 0) {
			alert("Successfully Updated!");
		} else {
			alert("Failed update!");
		}
		brand = null;
		dataToView(brand);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vBrand.getbtnSave())) {
			save();
		}

		if (e.getSource().equals(vBrand.getbtnClear())) {
			brand = null;
			dataToView(brand);
		}

		if (e.getSource().equals(vBrand.getbtnShow())) {
			show();
		}
		if (e.getSource().equals(vBrand.getbtnClose())) {
			System.exit(0);
		}

		if (e.getSource().equals(vBrand.getbtnDelete())) {
			delete();
		}
		if (e.getSource().equals(vBrand.getbtnEdit())) {
			vBrand.getbtnSave().setVisible(false);
			vBrand.getbtnUpdate().setVisible(true);
			edit();
		}
		if (e.getSource().equals(vBrand.getbtnUpdate())) {
			vBrand.getbtnSave().setVisible(true);
			vBrand.getbtnUpdate().setVisible(false);
			update();
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		if (!vBrand.getTable().getSelectionModel().isSelectionEmpty()) {
			temp_id = vBrand.getTable().getValueAt(vBrand.getTable().getSelectedRow(), 0).toString();
		} else {
			System.out.println("Empty");
		}
	}

	private void alert(String msg) {
		JOptionPane.showMessageDialog(vBrand.getFrame(), msg);
	}

}
