
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
    } //get grade value

    public String getFirstName() {
        return firstName;
    } //gets firstName value

    public String getLastName() {
        return lastName;
    } // get lastName Value

    public void setGrade(int grade) {
        this.grade = grade;
    } //sets grade value

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }//sets firstName value

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }//sets lastName value
    public String toString(){
        return String.format("%9s %-9s: \t %d", getFirstName(), getLastName(), getGrade());
    } //format string to print
    public int compareTo(StudentGrade student ) {//compares two objects using the grade value
        int grade = student.getGrade();
        if (getGrade()> grade){
            return 1; //return 1 if the grade is higher than the second object
        } else if (getGrade()==grade){
            return 0; //returns zero if the grade is the same
        }else {
            return -1; //returns -1 if the grade is less than the second object
        }
    }

}
