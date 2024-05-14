import java.util.*;
import java.io.*;

public class Tasktwo {
    // Method to find the highest followers
    public String highestFollowers(String file) throws IOException {
        // Read content from file
        Map<String, List<String>> userData = readUserData(file);
        // Find person with the highest followers
        return findMax(userData);
    }

    // Method to read data from file
    private Map<String, List<String>> readUserData(String file) throws IOException {
        // Map to store username and followers
        Map<String, List<String>> userData = new HashMap<>();
 

        BufferedReader readUserData = new BufferedReader(new FileReader(file));
        String line;
        while ((line = readUserData.readLine()) != null) {
            String[] userAndFollowers = line.split(" ");
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

    private String findMax(Map<String, List<String>> userData) {
        // Map to store the count of followers for each user
        Map<String, Integer> followerCounts = new HashMap<>();

        // Update the followerCount with new count of followers
        for (List<String> totalUserFollowing : userData.values()) {
            for (String user : totalUserFollowing) {
                followerCounts.put(user, followerCounts.getOrDefault(user, 0) + 1);
            }
        }
        String topUser = "";
        int maxFollowers = 0;
        // Loop for accessing both username and followers count
        for (Map.Entry<String, Integer> entry : followerCounts.entrySet()) {
            String person = entry.getKey();// Gets the username
            int count = entry.getValue();// Gets the followers number
            // For checking if current user has more followers than the current MaxFollowers
            if (count > maxFollowers || (count == maxFollowers && person.compareTo(topUser) < 0)) {
                topUser = person;
                maxFollowers = count;
            }
        }
        return topUser;
    }
}

// person: each individual followers of user
// totalUserFollowing: list of all the following of the user
// topUser:to store the name of the person with the highest followers
// maxFollowers:to store the maximum number of followers encountered