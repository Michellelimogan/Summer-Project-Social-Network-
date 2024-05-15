import java.io.BufferedReader; //Read text from char input
import java.io.FileReader; // Read char from file
import java.io.IOException;// // For try catch

public class Taskone {

    // Method to count the density 
    public static double countDensity(String file) throws IOException {
        int persons = 0; // Variable to store the number of persons
        int followers = 0; //  Variable to store the number of followers

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                persons++; 
                String[] name = line.split(" "); 
                // Split the line using whitespace to get people's name
                followers += name.length - 1; 
                // Count the number of followers for each user
            }
        }
        // Calculate the total number of edges 
        int edges = persons * (persons - 1);

        //To handle case if there is no edges
        if (edges == 0) {
            return 0;
        }

        //Calculate the density
        double density = (double) followers/ edges;

        // Format the density to have 8 decimal place
        density = Double.parseDouble(String.format("%.8f", density));

        return density;
    }
}

