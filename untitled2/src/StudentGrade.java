import java.util.*;

public class StudentGrade implements Comparable<StudentGrade> {
    private String firstName;
    private String lastName;
    private int grade;
    public StudentGrade(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }
    public StudentGrade(){

    }
    public int getGrade() {
        return grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String toString(){
        return String.format("%9s %-9s: \t %d", getFirstName(), getLastName(), getGrade());
    }
    public int compareTo(StudentGrade student ) {
        int grade = student.getGrade();
        if (getGrade()> grade){
            return 1;
        } else if (getGrade()==grade){
            return 0;
        }else {
            return -1;
        }
    }

}
