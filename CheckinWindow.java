import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class CheckinWindow extends JFrame {
	public CheckinWindow() {
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		
		JPanel p = new JPanel(new FlowLayout());
		JLabel label = new JLabel("Student ID");
		Font font = new Font("Plain", Font.PLAIN, 20);
		label.setFont(font);
		JTextField input = new JTextField(25);
		input.setFont(new Font("Plain", Font.PLAIN, 15));
		input.setBorder(new LineBorder(Color.BLACK));
		p.add(label);
		p.add(input);
		
		JPanel button_panel = new JPanel(new FlowLayout());
		JButton checkin = new JButton("Check-in");
		checkin.setSelected(true);
		checkin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int data = Integer.parseInt(input.getText().trim());
				DataManager dm = DataManager.getInstance();
				Student s = dm.checkStudent(data);
				if(s == null) {
					JOptionPane.showMessageDialog(null, "Invalid ID");
				}
				else {
					String name = s.getLast() + ", " + s.getFirst();
					int i = JOptionPane.showConfirmDialog(null, name, "confirmation", JOptionPane.OK_CANCEL_OPTION);
					if(i == 0){
						dm.update(s);
					}
				}

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
		button_panel.add(checkin);
		button_panel.add(cancel);
		
		main.add(p);
		main.add(button_panel);
		
		this.setTitle("Check-in");
		this.add(main);
		this.setSize(400, 200);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(0);
	}
}
