package hw8_vuquangmanh_20000250;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class OutputGUI extends JFrame {
    public OutputGUI(GraphAdjacencyList graph) {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Output");
        createOutputUI(this, graph);
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    public static void createOutputUI(JFrame frame, GraphAdjacencyList graph) {

        JPanel enterPanel = new JPanel();
        JLabel numSubLabel = new JLabel("Enter number of subjects per semester: ");
        JTextField subjectNum = new JTextField(5);
        subjectNum.setText("0");
        enterPanel.add(numSubLabel);
        enterPanel.add(subjectNum);

        int result = JOptionPane.showConfirmDialog(null, enterPanel, "Enter: ",
                JOptionPane.OK_CANCEL_OPTION);
        int subjectPerSemester = Integer.parseInt(subjectNum.getText());
        if (result == JOptionPane.OK_OPTION) {
            //System.out.println(subjectPerSemester);
        }

        JPanel panel = new JPanel();
        JList listSubject;
        java.util.List<Subject> course = CourseScheduler.courseSchedule(graph);
        java.util.List<Subject> courseString;


        int numSemester = (int) Math.ceil((double) graph.numSubjects() / subjectPerSemester);

        int index = 0;

//        for (Subject subject : course) {
//            courseString = new ArrayList<>();
//
//            courseString.add(subject);
//            index++;
//
//            if(index == 4){
//            listSubject = new JList(courseString.toArray());
//            panel.add(listSubject);
//            index = 0;
//            courseString = new ArrayList<>();
//
//            }
//        }

        for (int i = 0; i < numSemester; i++) {
            courseString = new ArrayList<>();
            for (int j = 0; j < subjectPerSemester; j++) {
                // Array index out of bound
                if (i * subjectPerSemester + j == graph.numSubjects()) break;
                courseString.add((course.get(i * subjectPerSemester + j)));
            }
            listSubject = new JList(courseString.toArray());
            panel.add(listSubject);
        }

        // graph.sortbySubject();

        // change color
        frame.getContentPane().setBackground(Color.ORANGE);


        //JLabel
        JLabel scheduleLabel = new JLabel("Schedule: ");

        // add into frame
        LayoutManager gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBackground(Color.ORANGE);
        gbc.insets = new Insets(5, 5, 5, 5);
        frame.setLayout(gridBagLayout);
        frame.add(panel, gbc);


    }

    public static void main(String[] args) {

    }

}
