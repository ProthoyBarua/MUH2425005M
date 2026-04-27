
class Assignment {
    String title;

    public Assignment(String title) {
        this.title = title;
    }
}


class Grade {
    private String grade;

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}


class Course {
    String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void submitAssignment() {
        System.out.println("Assignment submitted in Course");
    }
}


class OnlineCourse extends Course {

    public OnlineCourse(String name) {
        super(name);
    }

    public void submitAssignment() {
        System.out.println("Assignment submitted ONLINE via portal");
    }
}


class OfflineCourse extends Course {

    public OfflineCourse(String name) {
        super(name);
    }

    public void submitAssignment() {
        System.out.println("Assignment submitted in CLASSROOM");
    }
}


class Student {
    String name;
    Grade grade = new Grade();

    public Student(String name) {
        this.name = name;
    }

    public void viewGrade() {
        System.out.println(name + "'s Grade: " + grade.getGrade());
    }
}


class Professor {

    public void assignGrade(Student s, String g) {
        s.grade.setGrade(g);
        System.out.println("Grade assigned by Professor");
    }
}


public class UniversitySystem {
    public static void main(String[] args) {


        Course c1 = new OnlineCourse("Java");
        Course c2 = new OfflineCourse("C Programming");

        c1.submitAssignment();
        c2.submitAssignment();



        Student s1 = new Student("Ali");
        Professor p1 = new Professor();


        p1.assignGrade(s1, "A+");

        
        s1.viewGrade();
    }
}