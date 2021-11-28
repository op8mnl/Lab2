import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Vector;

public class FelixCatriona_SortNameAndGrade {
    public static void main(String[] args) {
        printHeader();
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26)};
        Vector<StudentGrade> sg = new Vector(fnArray.length);
        for(int i=0; i<fnArray.length; i++){
            StudentGrade student = new StudentGrade(fnArray[i], lnArray[i], grd[i]);
            sg.add(student);
        }
        System.out.println("The Unsorted Array ................");
        for (int i = 0; i < fnArray.length; i++) {
            System.out.println(sg.elementAt(i).toString());
        }
        Collections.sort(sg);
        System.out.println("\nSorted by Grades ................");
        for (int i = 0; i < fnArray.length; i++) {
            System.out.println(sg.elementAt(i).toString());
        }
        StudentGrade[] arr = new StudentGrade[fnArray.length];
        sg.copyInto(arr);
        insertionSort(arr, 1);

        System.out.println("\nSorted by FirstName ................");
        for (int i = 0; i < fnArray.length; i++) {
            System.out.println(arr[i].toString());
        }
        insertionSort(arr,2);
        System.out.println("\nSorted by LastName ................");
        for (int i = 0; i < fnArray.length; i++) {
            System.out.println(arr[i].toString());
        }
        printFooter();

    }
    public static void insertionSort(StudentGrade[] a, int key) {
        if (key == 1) {
            for (int i = 1; i < a.length; i++) {
                String fName = a[i].getFirstName();
                for (int j = i - 1; j >= 0 && a[j].getFirstName().compareTo(fName) > 0; j--) {
                    StudentGrade temp = a[j+1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }else if (key == 2){
                for (int i = 1; i < a.length; i++) {
                    String lName = a[i].getLastName();
                    for (int j = i - 1; j >= 0 && a[j].getLastName().compareTo(lName) > 0; j--) {
                        StudentGrade temp = a[j+1];
                        a[j + 1] = a[j];
                        a[j] = temp;
                    }
                }
        }else{
            System.out.println("Invalid Key.");
        }

    }
    public static void printHeader (){
        System.out.println("\n*******************************************************\n" +
                "Names: Felix Zheng and Catriona Chan.\n"+
                "Student Numbers: 251167970 and 251135537\n" +
                "Goal of this project: Use the comparable interface to help sort StudentGrade objects "+
                "\n*******************************************************\n");
    }

    //when called will print the footer message
    public static void printFooter () {
        // prints the following when called
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime today = LocalTime.now();
        String timeString = today.format(formatter);
        System.out.println("\n******************************************************* \n" +
                "This is " + timeString + " on " + java.time.LocalDate.now() +
                ".\nCompletion of Lab Assignment 2 is successful!\n" +
                "Good bye! Catriona Chan and Felix Zheng." +
                "\n*******************************************************");
    }
}
