import java.io.IOException; // For try catch

public class Main {

    public static void main(String[] args) {
        String file = "social-network1.txt";
        // To access input file
        try {
            //Running task one 
            double density = Taskone.countDensity(file);
            System.out.println("Task 1: " + density);
            
            //Running task two
            Tasktwo taskTwo = new Tasktwo();
            String result = taskTwo.highestFollowers(file);
            System.out.println("Task 2: " + result);
            
            //Running task five
            TaskFive taskFive = new TaskFive();
            String mid = taskFive.findMedian(file);
            System.out.println("Task 5: " + mid);

            //Running task six
            Tasksix taskSix = new Tasksix();
            String advertize = taskSix.bestAdvertiser(file);
            System.out.println("Task 6: " + advertize);
        } catch (IOException e) {
            System.out.println("File could not be read: " + e.getMessage());
        }
    }
}