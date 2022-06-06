package hw8_vuquangmanh_20000250;

//JComponent

import javax.swing.*;

import java.awt.*;

import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InputGUI extends JFrame {

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
        JButton enterButton = new JButton("Enter from keyboard");
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

        // GridBag layout
        LayoutManager gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
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

                if (returnVal != JFileChooser.APPROVE_OPTION) {
                    /** Tạo 1 Option Pane */
                    statusLabel.setText("Open command cancelled by user.");
                    System.out.println(statusLabel.getText());
                    return;
                }

                File file = fileDialog.getSelectedFile();
                String fileName = file.getAbsolutePath();
                GraphAdjacencyList graph = CourseScheduler.readFile(fileName);
                statusLabel.setText("File Selected :" + file.getName());

                System.out.println(statusLabel.getText());
                new OutputGUI(graph);
                frame.setVisible(false);
            }
            // input into graph here
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

                outputToTxt(getText);

                if (result == JOptionPane.OK_OPTION) {
                    System.out.println(getText);

//                     input into graph here
                GraphAdjacencyList graph = CourseScheduler.readFile("C:\\Users\\admin\\IdeaProjects\\des\\src\\hw8_vuquangmanh_20000250\\input.txt");
                java.util.List<Subject> course = CourseScheduler.courseSchedule(graph);
                System.out.println("Graph: ");
                graph.printGraph();
                System.out.println("------------------------------------------");
                System.out.println("\nRelations: ");
                graph.printRelations();
                    System.out.println("\n------------------------------------------");
                    System.out.println("Roadmap: ");
                    System.out.println(course);
               new OutputGUI(graph);
               frame.setVisible(false);
                }
            }
        });
    }

    private static void outputToTxt(String content) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\admin\\IdeaProjects\\des\\src\\hw8_vuquangmanh_20000250\\input.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(content);
            writer.close();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    // create option dialog: choose subject or credit


    public static void main(String[] args) {
        new InputGUI();

    }

}
