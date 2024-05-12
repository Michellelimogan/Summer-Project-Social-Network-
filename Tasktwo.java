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
    private String findMax(Map<String, List<String>> userData) {
        Map<String, Integer> followerCounts = new HashMap<>();
        // To store the count of followers for each user
        for (List<String> totalUserFollowing : userData.values()) {
            for (String user : totalUserFollowing) {
                followerCounts.put(user, followerCounts.getOrDefault(user, 0) + 1);
                // Update the followerCount with new count of followers
                // getOrDefault() method returns the value of the entry in the map which has a specified key.
            }
        }
        String topUser = "";
        int maxFollowers = 0;
        for (Map.Entry<String, Integer> entry : followerCounts.entrySet()) {
            // Loop for accessing both username and followers count
            String person = entry.getKey();// Gets the username
            int count = entry.getValue();// Gets the followers number
            if (count > maxFollowers || (count == maxFollowers && person.compareTo(topUser) < 0)) {
                // For checking if current user has more followers than the current MaxFollowers
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