package hw8_vuquangmanh_20000250;

import javax.swing.*;

import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUI extends JFrame {

	public StartGUI() {
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Welcome!!!");
		createUI(this);
		setVisible(true);
	}

	public static void createUI(JFrame frame) {
		// panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// create start button
		JButton startButton = new JButton("START");
		panel.add(startButton);
		startButton.setBackground(Color.GREEN);
		startButton.setHorizontalTextPosition(JButton.CENTER);
		startButton.setVerticalTextPosition(JButton.CENTER);

		// set layout and background color for frame
		LayoutManager gridBaglayout = new GridBagLayout();
		frame.setLayout(gridBaglayout);
		frame.add(panel, new GridBagConstraints());
		frame.getContentPane().setBackground(Color.ORANGE);
		
		// set size for button
		Dimension d = new Dimension(100, 50);
		startButton.setPreferredSize(d);

		// create empty border
		Border emptyBorder = BorderFactory.createEmptyBorder();
		startButton.setBorder(emptyBorder);
		panel.setBorder(emptyBorder);

		
		// add action for start button
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InputGUI();
			}

		});

	}

	public static void main(String[] args) {
		new StartGUI();
	}
}
