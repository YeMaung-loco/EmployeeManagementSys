package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.View_Brand;
import View.View_Category;
import View.View_Employee;
import View.View_Main;
import View.inputform;

public class Main_Controller implements ActionListener ,MouseListener{
	View_Main vMain;
	View_Employee vEmployee;
	inputform inputform;
	View_Brand vBrand;
	View_Category vCategory;
	

	public Main_Controller() {
		dependencyInjection();
		initController();
		
	}
	
	private void dependencyInjection() {
		vMain = new View_Main();
		inputform=new inputform(vMain.getFrame());
		//vMain.getFrame().add(inputform);
		
	}

	private void initController() {
		vMain.getbtnEmployee().addActionListener(this);
		vMain.getbtnBrand().addActionListener(this);
		vMain.getbtnCategory().addActionListener(this);
		vMain.getbtnClose().addActionListener(this);
		
		vMain.getPanel_btnEmployee().addMouseListener(this);
		vMain.getPanel_btnBrand().addMouseListener(this);
		vMain.getPanel_btnCategory().addMouseListener(this);
		
		//////
		inputform.getBtnMinimize().addActionListener(this);
		inputform.getBtnMaximize().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vMain.getbtnEmployee())) {
			EmployeeController employeeController=new EmployeeController();
	        vMain.getFrame().dispose();
		}
		if (e.getSource().equals(vMain.getbtnBrand())) {
			BrandController brandController=new BrandController();
			vMain.getFrame().dispose();
		}
		if (e.getSource().equals(vMain.getbtnCategory())) {
			CategoryController categoryController=new CategoryController();
			vMain.getFrame().dispose();
		}
		if (e.getSource().equals(vMain.getbtnClose())) {
			vMain.getFrame().dispose();
		}
		
		if(e.getSource().equals(inputform.getBtnMinimize())) {
			System.out.println("collapse");
			collapseInputForm(true);
		}
		
		if(e.getSource().equals(inputform.getBtnMaximize())) {
			System.out.println("expand");
			collapseInputForm(false);
		}
	}

	private void collapseInputForm(boolean collapse) {
		if(collapse) {
		System.out.println("collapse");
		inputform.getPanel_inptForm().setBounds(180,34, 1144, 50);
		//panel.setBounds(180, 34, 1144, 370);
		}
		else {
			System.out.println("expand");
			inputform.getPanel_inptForm().setBounds(180,34, 1144, 370);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(vMain.getPanel_btnEmployee())) {
			EmployeeController employeeController=new EmployeeController();
	        vMain.getFrame().dispose();
		}
		
		if (e.getSource().equals(vMain.getPanel_btnBrand())) {
			BrandController brandController=new BrandController();
			vMain.getFrame().dispose();
		}
		if (e.getSource().equals(vMain.getPanel_btnCategory())) {
			//inputform inputformPanel= new inputform(vMain.getFrame());
			//View_Main view_Main=new View_Main(inputformPanel);
			//panel_inputForm.add(inputformPanel);
			//frame.pack();
			vMain.getFrame().add(inputform);
			//CategoryController categoryController=new CategoryController();
			//vMain.getFrame().dispose();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
