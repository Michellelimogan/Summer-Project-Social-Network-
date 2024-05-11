import java.io.IOException; // For try catch

public class Main {

    public static void main(String[] args) {
        String file = "social-network2.txt";
        // To access input file
        try {
            //For running task one 
            double density = Taskone.countDensity(file);
            System.out.println("Task 1: " + density);
            

        } catch (IOException e) {
            System.out.println("File could not be read: " + e.getMessage());
        }
    }
}