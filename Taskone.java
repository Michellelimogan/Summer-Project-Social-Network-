import java.io.BufferedReader; //Read text from char input
import java.io.FileReader; // Read char from file
import java.io.IOException;// // For try catch

public class Taskone {

    public static double countDensity(String file) throws IOException {
        int persons = 0;
        int followers = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
            // To read each line from file 
                persons++; 
                String[] name = line.split(" "); 
                // Spliting the line using whitespace to get people's name
                followers += name.length - 1; 
                // Number of followers for each user
            }
        }
        int edges = persons * (persons - 1);

        if (edges == 0) {
            return 0;
        }

        double density = (double) followers/ edges;
        // Count density

        density = Double.parseDouble(String.format("%.8f", density));

        return density;
    }
}

