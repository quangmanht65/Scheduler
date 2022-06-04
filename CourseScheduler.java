package hw8_vuquangmanh_20000250;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseScheduler {
    public static void main(String[] args) {
        GraphAdjacencyList graph = readFile("C:\\Users\\admin\\IdeaProjects\\des\\src\\hw8_vuquangmanh_20000250\\Subjects.txt");
        System.out.println("Graph: ");
        graph.printGraph();
        System.out.println("\n--------------------------------------------------------");
        System.out.println("Relations: ");
        graph.printRelations();
    }

    public static ArrayList<Subject> schedule(GraphAdjacencyList graph) {
        int length = graph.numSubjects();
        int[] order = new int[length];
        boolean[] visited = new boolean[length];

        // chọn 1 môn bất kỳ
        // dfs(subject)
        // if (visited(subject))

        // dfs { dfs }

        return null;
    }

    private static int dfs(int index, int at, boolean[] visited, int[] order, GraphAdjacencyList graph) {
        return index - 1;
    }

    public static GraphAdjacencyList readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
//            ArrayList<Subject> subject = new ArrayList<>();
            String line = reader.readLine();
//            List<Subject> prerequisite;
            Subject prerequisite;
            GraphAdjacencyList graph = new GraphAdjacencyList();
            ArrayList<String> leftSubject = new ArrayList<>();

            try {
                while (line != null) {
                    // split by comma, as well as trimming all excessive spaces
                    String[] list = line.split(",|\s+");
                    Subject subject = new Subject(list[0], Integer.parseInt(list[1]));  // new Subject(id, credit)
                    graph.insertSubject(subject);

                    if (!leftSubject.isEmpty() && leftSubject.contains(subject.getId())) {
                        addAllLeft(graph, leftSubject, subject.getId());
                    }

                    // list.length by default > 0, since line != null
                    if (list.length >= 3) {
                        for (int i = 2; i < list.length; i++) {
                            prerequisite = graph.getSubject(list[i]);
                            if (prerequisite == null) {
                                leftSubject.add(list[i]);
                            } else {
                                graph.insertRelation(prerequisite, subject);
                            }
                        }
                    }
                    line = reader.readLine();

                }
            } finally {
                reader.close();
            }

            return graph;
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            return null;
        }
    }

    public static void outputFile(String fileName) {}

    private static void addAllLeft(GraphAdjacencyList graph, ArrayList<String> leftSubjects, String id) {
        int index = leftSubjects.indexOf(id);
        Subject prerequisite = graph.getSubject(leftSubjects.remove(index));

        for (Subject subject : graph.subjectSet()) {
            List<Subject> list = graph.get(subject);

            if (list.contains(prerequisite)) graph.insertRelation(prerequisite, subject);
        }
    }

    private static void trimInput(String line) {
        line = line.trim();
        String[] list = line.split(",");
        for (int i = 0; i < list.length; i++) {
            list[i] = list[i].trim();
        }
    }
}
