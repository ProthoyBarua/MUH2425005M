
class Assignment {
    String title;

    public Assignment(String title) {
        this.title = title;
    }

    public void show() {
        System.out.println("  Assignment: " + title);
    }
}


class Grade {
    private String value;

    public void set(String value) {
        this.value = value;
    }

    public String get() {
    if (value != null) {
        return value;
    } else {
        return "Not graded yet";
    }
}
}


abstract class Course {
    String courseName;
    Assignment assignment;

    public Course(String courseName) {
        this.courseName = courseName;
    }


    public abstract void submitAssignment();

    public void showCourseInfo() {
        System.out.println("  Course: " + courseName + " [" + getType() + "]");
    }


    public abstract String getType();
}


class OnlineCourse extends Course {

    public OnlineCourse(String name) {
        super(name);
    }

    public String getType() {
        return "Online";
    }

    public void submitAssignment() {
        System.out.println("  [" + courseName + "] Assignment submitted via ONLINE portal");
    }
}


class OfflineCourse extends Course {

    public OfflineCourse(String name) {
        super(name);
    }

    public String getType() {
        return "Offline";
    }

    public void submitAssignment() {
        System.out.println("  [" + courseName + "] Assignment submitted in CLASSROOM");
    }
}


class Student {
    String name;
    Grade grade = new Grade();
    Course[] enrolledCourses = new Course[5];
    int courseCount = 0;

    public Student(String name) {
        this.name = name;
    }

    public void enroll(Course c) {
        enrolledCourses[courseCount] = c;
        courseCount++;
        System.out.println("  " + name + " enrolled in: " + c.courseName);
    }

    public void submitAll() {
        System.out.println("  " + name + " is submitting assignments:");
        for (int i = 0; i < courseCount; i++) {
            enrolledCourses[i].submitAssignment();
        }
    }

    public void viewGrade() {
        System.out.println("  " + name + "'s Grade: " + grade.get());
    }

    public void showProfile() {
        System.out.println("  Student : " + name);
        System.out.println("  Courses :");
        for (int i = 0; i < courseCount; i++) {
            enrolledCourses[i].showCourseInfo();
        }
    }
}


class Professor {
    String name;

    public Professor(String name) {
        this.name = name;
    }

    public void assignGrade(Student s, String g) {
        s.grade.set(g);
        System.out.println("  Prof. " + name + " gave '" + g + "' to " + s.name);
    }
}


public class UniversitySystem {
    public static void main(String[] args) {

        // ─── Courses তৈরি ───
        System.out.println("============================");
        System.out.println("       COURSES CREATED      ");
        System.out.println("============================");
        Course c1 = new OnlineCourse("Java Programming");
        Course c2 = new OfflineCourse("C Programming");
        c1.showCourseInfo();
        c2.showCourseInfo();

        // ─── Student তৈরি ও Enroll ───
        System.out.println("\n============================");
        System.out.println("     STUDENT ENROLLMENT     ");
        System.out.println("============================");
        Student s1 = new Student("Ali");
        s1.enroll(c1);
        s1.enroll(c2);

        // ─── Profile দেখো ───
        System.out.println("\n============================");
        System.out.println("      STUDENT PROFILE       ");
        System.out.println("============================");
        s1.showProfile();

        // ─── Assignment Submit ───
        System.out.println("\n============================");
        System.out.println("    ASSIGNMENT SUBMISSION   ");
        System.out.println("============================");
        s1.submitAll();

        // ─── Professor Grade দেয় ───
        System.out.println("\n============================");
        System.out.println("       GRADING SESSION      ");
        System.out.println("============================");
        Professor p1 = new Professor("Dr. Rahman");
        p1.assignGrade(s1, "A+");


        System.out.println("\n============================");
        System.out.println("         FINAL GRADE        ");
        System.out.println("============================");
        s1.viewGrade();
    }
}
