import java.util.*;

// Student class
class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

// Main class
public class Sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();

        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);
            testCases--;
        }

        // Custom Comparator to sort the list
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                // Compare by CGPA (descending)
                if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0) {
                    return Double.compare(s2.getCgpa(), s1.getCgpa());
                }
                // Compare by name (ascending)
                else if (!s1.getFname().equals(s2.getFname())) {
                    return s1.getFname().compareTo(s2.getFname());
                }
                // Compare by ID (ascending)
                else {
                    return s1.getId() - s2.getId();
                }
            }
        });

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
