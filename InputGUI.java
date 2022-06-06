package hw8_vuquangmanh_20000250;

//JComponent

import javax.swing.*;

import java.awt.*;

import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InputGUI extends JFrame {
	public static void main(String[] args) {
		new InputGUI();

	}

	public InputGUI() {
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Browse from device or enter it by keyboard");
		createInputUI(this);
		setVisible(true);
	}

	public static void createInputUI(JFrame frame) {

		// button and label
		JButton browseButton = new JButton("Browse from device");
		JButton enterButton = new JButton("Enter from keyborad");
		JLabel optionLabel = new JLabel("Click to continue: ");

		JPanel panel = new JPanel();
		frame.add(panel);

		// change background color
		browseButton.setBackground(Color.GREEN);
		enterButton.setBackground(Color.GREEN);
		frame.getContentPane().setBackground(Color.GRAY);
		panel.setBackground(Color.ORANGE);

		Border emptyBorder = BorderFactory.createEmptyBorder();
		panel.setBorder(emptyBorder);

		// Gridbag layout
		LayoutManager gridBaglayout = new GridBagLayout();
		panel.setLayout(gridBaglayout);
		GridBagConstraints gbc = new GridBagConstraints();
		// create space
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(optionLabel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(browseButton, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;

		panel.add(enterButton, gbc);

		// action of browse button
		browseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				final JFileChooser fileDialog = new JFileChooser();
				JLabel statusLabel = new JLabel("", JLabel.CENTER);
				int returnVal = fileDialog.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					java.io.File file = fileDialog.getSelectedFile();
					statusLabel.setText("File Selected :" + file.getName());
					
				} else {
					statusLabel.setText("Open command cancelled by user.");
				}
				System.out.println(statusLabel.getText());
				

				// input into graph here

				createDialog();

			}

		});

		// action of enter button
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// create label and text area
				JLabel enterLabel = new JLabel("Enter here: ");
				JTextArea textArea = new JTextArea();
				textArea.setPreferredSize(new Dimension(200, 80));
				String eg = "Input your data here (e.g: \r\n" + "2\r\n" + "MAT1234, 5\r\n" + "MAT5678,3, MAT1234\r\n"
						+ ")";
				textArea.setText(eg);

				// create clear button
				JButton clearButton = new JButton("Clear");
				Dimension d = new Dimension(70, 25);
				clearButton.setPreferredSize(d);
				clearButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						textArea.setText("");
					}

				});

				JPanel enterPanel = new JPanel();
				enterPanel.add(clearButton);
				enterPanel.add(enterLabel);
				enterPanel.add(textArea);

				int result = JOptionPane.showConfirmDialog(null, enterPanel, "Please enter from your keyboard",
						JOptionPane.OK_CANCEL_OPTION);
				String getText = textArea.getText();
				if (result == JOptionPane.OK_OPTION) {
					System.out.println(getText);

					// input into graph here

					createDialog();

				}

			}

		});

	}

	// create option dialog: choose subject or credit
	public static void createDialog() {
		// create Dialog
		JDialog dialog = new JDialog();
		dialog.setSize(400, 300);
		dialog.setVisible(true);

		// button
		JButton subjectButton = new JButton("Subject");
		JButton creditButton = new JButton("Credit");
		subjectButton.setBackground(Color.GREEN);
		creditButton.setBackground(Color.GREEN);

		JLabel optionLabel = new JLabel("Choose: ");
		// panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		LayoutManager gridBaglayout = new GridBagLayout();
		panel.setLayout(gridBaglayout);
		GridBagConstraints gbc = new GridBagConstraints();
		// create space
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(optionLabel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(subjectButton, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;

		panel.add(creditButton, gbc);
		dialog.add(panel);

		subjectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JPanel enterPanel = new JPanel();
				JLabel numSubLabel = new JLabel("Enter number of subjects that you want in 1 semester: ");
				JTextField tfnumSub = new JTextField(5);
				tfnumSub.setText("0");
				enterPanel.add(numSubLabel);
				enterPanel.add(tfnumSub);
				
				int result = JOptionPane.showConfirmDialog(null, enterPanel, "Enter: ",
						JOptionPane.OK_CANCEL_OPTION);
				int subpersem  = Integer.parseInt(tfnumSub.getText());
				if (result == JOptionPane.OK_OPTION) {
					//System.out.println(subpersem);
				}

						
				
				// graph.sortbySubject();
				new OutputGUI();
			}

		});

		creditButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel enterPanel = new JPanel();
				JLabel numCreLabel = new JLabel("Enter number of credits that you want in 1 semester: ");
				JTextField tfnumCre = new JTextField(5);
				tfnumCre.setText("0");
				enterPanel.add(numCreLabel);
				enterPanel.add(tfnumCre);
				
				int result = JOptionPane.showConfirmDialog(null, enterPanel, "Enter: ",
						JOptionPane.OK_CANCEL_OPTION);
				int  crepersem  = Integer.parseInt(tfnumCre.getText());
				if (result == JOptionPane.OK_OPTION) {
					//System.out.println(crepersem);
				}

						
				
				// graph.sortbySubject();
				new OutputGUI();
				
			}

		});
	}
}
