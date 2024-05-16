import java.io.IOException; // For try catch

public class Main {

    public static void main(String[] args) {
        String file = "social-network1.txt";
        // To access input file
        try {
            //Running task one 
            double density = Taskone.countDensity(file);
            System.out.println("The density of the graph represented by the social network is " + density);
            
            //Running task two
            Tasktwo taskTwo = new Tasktwo();
            String result = taskTwo.highestFollowers(file);
            System.out.println("The person who has the highest number of followers is " + result);
            
            //Running task five
            TaskFive taskFive = new TaskFive();
            String mid = taskFive.findMedian(file);
            System.out.println("The median value for the number of followers in the network is " + mid);


        } catch (IOException e) {
            System.out.println("File could not be read: " + e.getMessage());
        }
    }
}