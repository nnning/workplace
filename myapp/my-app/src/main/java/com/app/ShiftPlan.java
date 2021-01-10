package com.app;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShiftPlan extends JPanel {

	String[] userName = { "Ning", "Lucie", "Lukáš", "Jakub", "Zoe" };

	public ShiftPlan() {
		super(new GridLayout(1, 0));

		Object[] columnNames = { "W18", 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
				17, 18, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, "9-17.30" };

		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		JTable table = new JTable(model);

		Object[] data = null;

		for (String name : userName) {
			try {
				data = new ShiftReader().read(new File("my-app\\files\\Shiftsplan_W18.xls"), name);
				model.addRow(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		JScrollPane scrollPane = new JScrollPane(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(800);
		add(scrollPane);

	}
}