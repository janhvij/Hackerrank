import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */
 import java.util.*;

// Student class
class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

// Priorities class to handle the events
class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<Student>(11, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                if (Double.compare(s2.getCGPA(), s1.getCGPA()) != 0) {
                    return Double.compare(s2.getCGPA(), s1.getCGPA());
                }
                int nameCmp = s1.getName().compareTo(s2.getName());
                if (nameCmp != 0) {
                    return nameCmp;
                }
                return Integer.compare(s1.getID(), s2.getID());
            }
        });

        for (String event : events) {
            String[] parts = event.split("\\s+");
            String command = parts[0];

            if (command.equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                Student student = new Student(id, name, cgpa);
                pq.add(student);
            } else if (command.equals("SERVED")) {
                if (!pq.isEmpty()) {
                    pq.poll();
                }
            }
        }

        List<Student> result = new ArrayList<Student>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}



public class priorityqueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}