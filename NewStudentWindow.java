import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NewStudentWindow extends JFrame{
	public NewStudentWindow() {
		//panel for the user to enter ID
		JPanel idPanel = new JPanel(new FlowLayout());
		JLabel id = new JLabel("ID");
		JTextField idInput = new JTextField(20);
		Font font = new Font("Plain", Font.PLAIN, 20);
		idInput.setFont(new Font("Plain", Font.PLAIN, 15));
		id.setFont(font);
		idPanel.add(id);
		idPanel.add(idInput);
		
		//panel for user to enter last name
		JPanel lNamePanel = new JPanel(new FlowLayout());
		JLabel last = new JLabel("Last Name");
		last.setFont(font);
		JTextField lastInput = new JTextField(20);
		lastInput.setFont(new Font("Plain", Font.PLAIN, 15));
		lNamePanel.add(last);
		lNamePanel.add(lastInput);
		
		//panel for the user to enter first name
		JPanel fNamePanel = new JPanel(new FlowLayout());
		JLabel first = new JLabel("First Name");
		first.setFont(font);
		JTextField firstInput = new JTextField(20);
		firstInput.setFont(new Font("Plain", Font.PLAIN, 15));
		fNamePanel.add(first);
		fNamePanel.add(firstInput);
		
		//Panel for button
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(idInput.getText().trim());
				String lastN = lastInput.getText().trim();
				String firstN = firstInput.getText().trim();
				Student s = new Student(id, lastN, firstN, 1);
				DataManager dm = DataManager.getInstance();
				dm.update(s);
				dispose();
				InitialScreen sc = new InitialScreen();
			}
		});
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				InitialScreen sc = new InitialScreen();
			}
		});
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(confirm);
		buttons.add(cancel);
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(idPanel);
		main.add(lNamePanel);
		main.add(fNamePanel);
		main.add(buttons);
	
		this.add(main);
		this.setSize(500, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(0);
	}

}
