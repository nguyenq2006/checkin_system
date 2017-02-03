import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InitialScreen extends JFrame{
	public InitialScreen(){
		JLabel text = new JLabel("Welcome to CS 46A Session");
		text.setHorizontalAlignment(JLabel.CENTER);
		Font boldItalicFont = new Font("Serif", Font.BOLD+Font.ITALIC, 24);
		text.setFont(boldItalicFont);
		JButton check_in = new JButton("Check-in");
		check_in.setSelected(true);
		check_in.setPreferredSize(new Dimension(100, 75));
		check_in.setAlignmentX(CENTER_ALIGNMENT);
		check_in.setSize(200, 100);
		check_in.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				CheckinWindow check = new CheckinWindow();
			}
		});
		JButton first_time = new JButton("First Time");
		first_time.setSize(200, 100);
		first_time.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				NewStudentWindow newS = new NewStudentWindow();
			}
		});
		first_time.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(check_in);
		panel.add(first_time);
		
		JPanel main = new JPanel(new BorderLayout());
		main.add(text, BorderLayout.NORTH);
		main.add(panel, BorderLayout.SOUTH);
		
//		this.setResizable(false);
		this.setSize(400,200);
		this.setTitle("SI Session Check-in");
		this.add(main);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

}
