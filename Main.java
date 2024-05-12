import java.io.IOException; // For try catch

public class Main {

    public static void main(String[] args) {
        String file = "social-network1.txt";
        // To access input file
        try {
            //For running task one 
            double density = Taskone.countDensity(file);
            System.out.println("Task 1: " + density);
            
            //For running task two
            Tasktwo taskTwo = new Tasktwo();
            String result = taskTwo.highestFollowers(file);
            System.out.println("Task 2: " + result);
            

        } catch (IOException e) {
            System.out.println("File could not be read: " + e.getMessage());
        }
    }
}