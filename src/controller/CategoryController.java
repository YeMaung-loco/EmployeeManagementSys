package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import Model.Category;
import TableModel.tableModel_Category;
import View.View_Category;
import service.CategoryService;

public class CategoryController implements ActionListener, ListSelectionListener {
	private View_Category vCategory;
	private CategoryService categoryService;
	private Category category;
	static String temp_id;
	//static int temp_id;

	public CategoryController() {
		dependencyInjection();
		initController();
		dataToView(category);
	}

	private void dependencyInjection() {
		this.categoryService = new CategoryService();
		this.vCategory = new View_Category();
	}

	private void initController() {
		vCategory.getbtnSave().addActionListener(this);
		vCategory.getbtnClear().addActionListener(this);
		vCategory.getbtnShow().addActionListener(this);
		vCategory.getbtnClose().addActionListener(this);
		vCategory.getbtnUpdate().addActionListener(this);
		vCategory.getbtnDelete().addActionListener(this);
		vCategory.getbtnEdit().addActionListener(this);
		vCategory.getTable().getSelectionModel().addListSelectionListener(this);
	}

	private void dataToView(Category category) {
		vCategory.getTxtName().setText(category == null ? "" : category.getName());
	}

	private void save() {
		category = new Category();
		category.setName(vCategory.getTxtName().getText());

		int status = categoryService.saveCategory(category);
		if (status > 0) {
			alert("Successfully Saved!");

		} else {
			alert("Failed Save!");

		}
		category = null;
		dataToView(category);
	}

	private void show() {
		List<Category> empList = new ArrayList<Category>();
		empList = categoryService.findAllCategories();
		AbstractTableModel model = new tableModel_Category(empList);
		vCategory.getTable().setModel(model);
	}

	private void delete() {
		int status = categoryService.deleteCategory(temp_id);
		if (status > 0) {
			alert("Successfully Deleted!");

		} else {
			alert("Delete Failed!");
		}

	}

	private void edit() {
		Category category = new Category();
		category = categoryService.findById(temp_id);
		dataToView(category);
	}

	private void update() {
		category = new Category();
		category.setName(vCategory.getTxtName().getText());
		int status = categoryService.updateCategory(temp_id, category);
		if (status > 0) {
			alert("Successfully Updated!");

		} else {
			alert("Failed update!");

		}
		category = null;
		dataToView(category);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vCategory.getbtnSave())) {
			save();
		}

		if (e.getSource().equals(vCategory.getbtnClear())) {
			category = null;
			dataToView(category);
		}

		if (e.getSource().equals(vCategory.getbtnShow())) {
			show();
		}
		if (e.getSource().equals(vCategory.getbtnClose())) {
			vCategory.getFrame().dispose();
			Main_Controller main_Controller = new Main_Controller();
			//System.exit(0);
		}

		if (e.getSource().equals(vCategory.getbtnDelete())) {
			delete();
		}
		if (e.getSource().equals(vCategory.getbtnEdit())) {
			vCategory.getbtnSave().setVisible(false);
			vCategory.getbtnUpdate().setVisible(true);
			edit();
		}
		if (e.getSource().equals(vCategory.getbtnUpdate())) {
			vCategory.getbtnSave().setVisible(true);
			vCategory.getbtnUpdate().setVisible(false);
			update();
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		if (!vCategory.getTable().getSelectionModel().isSelectionEmpty()) {
			//temp_id = Integer.parseInt(vCategory.getTable().getValueAt(vCategory.getTable().getSelectedRow(), 0).toString());
			temp_id = vCategory.getTable().getValueAt(vCategory.getTable().getSelectedRow(), 0).toString();
		} else {
			System.out.println("Empty");
		}

	}

	private void alert(String msg) {
		JOptionPane.showMessageDialog(vCategory.getFrame(), msg);
	}

}
