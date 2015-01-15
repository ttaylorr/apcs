import java.util.*;

public class StudentSeatingChart {
    protected Student[][] seats;

    public StudentSeatingChart(List<Student> students, int rows, int cols) {
        // Initialize the instance variable "seats" to be a new array with length rows and height cols
        this.seats = new Student[rows][cols];

        // Iterate through every index in the newly created array.  First we'll iterate on the
        // y-axis, then on the x-axis.
        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {
                // From these two numbers (x,y) we'll calculate the index of the ArrayList
                // that we want to pull the student from
                int studentIndex = i * rows + j;

                // We'll check that it's in bounds
                if (studentIndex < students.size()) {
                    // Then we'll place them in the array.
                    this.seats[i][j] = students.get(studentIndex);
                }
            }
        }
    }

    /**
     * This method is supposed to remove all students in the seating chart who have a
     * number of abscences greater than the parameter "allowedAbsences".
     *
     * @param allowedAbsences The maximum number of abscenses allowed per student.
     */
    public void removeAbsentStudents(int allowedAbsences) {
        // Iterate through every single element in the 2-D array
        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {
                // Store off the student that we are currently looking at in a variable
                // of type Student with name "s".
                Student s = this.seats[i][j];

                // Compare their abscense count to the maximum allowed
                if (s.getAbscenceCount() > allowedAbsences) {
                    // If they have too many, simply set their location in the array to "null"
                    this.seats[i][j] = null;
                }
            }
        }
    }
}