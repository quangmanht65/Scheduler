package hw8_vuquangmanh_20000250;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class OutputGUI extends JFrame {
    public OutputGUI() {
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Output");
		createOutputUI(this);
		setVisible(true);
		
	}
	
	public static void createOutputUI(JFrame frame) {
		
		// change color
		frame.getContentPane().setBackground(Color.ORANGE);
		JPanel panel = new JPanel();
		
		// JList
		JList listSubject = new JList();
		String[] list = {"MAT 2513", "MAT 3514", "MAT 2416", "MAT 3819"};
		listSubject = new JList(list);
		
		//JLabel
		JLabel scheduleLabel = new JLabel("Schedule: ");
		
		// add into frame
		LayoutManager gridBaglayout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		panel.add(scheduleLabel);
		panel.add(listSubject);
		panel.setBackground(Color.ORANGE);
		frame.setLayout(gridBaglayout);
		frame.add(panel, new GridBagConstraints());	
	}
    
    public static void main(String[] args) {

    }

}
