import java.util.*;
import java.io.*;

public class Tasktwo {
    // declaring method
    public String highestFollowers(String file) throws IOException {
        // Read content from file
        Map<String, List<String>> userData = readUserData(file);
        // Find person with the highest followers
        return findMax(userData);
    }

    private Map<String, List<String>> readUserData(String file) throws IOException {
        // For reading the content from the file
        // Throws IOException = handle error
        Map<String, List<String>> userData = new HashMap<>();
        // To store data

        BufferedReader readUserData = new BufferedReader(new FileReader(file));
        String line;
        while ((line = readUserData.readLine()) != null) {
            String[] userName = line.split(" ");
            String user = userName[0];
            List<String> totalUserFollowing = new ArrayList<>();
            // Arraylist to store the followers of the user
            for (int i = 1; i < userName.length; i++) {
                // Add followers to the list
                totalUserFollowing.add(userName[i]);
            }
            userData.put(user, totalUserFollowing);
            // Store the user and their followers
        }
        readUserData.close();

        return userData;
    }

}