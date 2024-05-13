import java.util.*;
import java.io.*;

public class TaskFive {
    // Method to find the highest followers
    public String highestFollowers(String file) throws IOException {
        Map<String, List<String>> userData = readUserData(file);
        return median(userData);
    }
    // For reading the content from the file
    private Map<String, List<String>> readUserData(String file) throws IOException {
        //Map to store data
        Map<String, List<String>> userData = new HashMap<>();

        BufferedReader readUserData = new BufferedReader(new FileReader(file));
        String line;
        while ((line = readUserData.readLine()) != null) {
            // Split line into user and their followers
            String[] userAndFollowers = line.split(" ");
            // username: first element
            String username = userAndFollowers[0];
            // Arraylist to store the followers of the user
            List<String> totalUserFollowing = new ArrayList<>();
            // Add followers to the list
            for (int i = 1; i < userAndFollowers.length; i++) {
                totalUserFollowing.add(userAndFollowers[i]);
            }
            // Store the user and their followers
            userData.put(username, totalUserFollowing);
        }
        readUserData.close();
        return userData;
    }
}