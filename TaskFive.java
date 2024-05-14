import java.util.*;
import java.io.*;

public class TaskFive {
    // Method to find the highest followers
    public String findMedian(String file) throws IOException {
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
    private String median(Map<String, List<String>> userData) {
        // Map to store the count of followers for each user
        Map<String, Integer> followerCounts = new HashMap<>();
        
        // Update the followerCount with new count of followers
        for (List<String> totalUserFollowing : userData.values()) {
            for (String user : totalUserFollowing) {
                followerCounts.put(user, followerCounts.getOrDefault(user, 0) + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(followerCounts.values());
        Collections.sort(list);
        int n = list.size();
        boolean isEven = (n % 2 == 0);
        if (isEven) {
            int mid1 = list.get(n / 2 - 1);
            int mid2 = list.get(n / 2);
            // If the number of elements is even, average the two middle values
            return String.valueOf((mid1 + mid2) / 2);
        } else {
            // If the number of elements is odd, return the middle value
            return String.valueOf(list.get(n / 2));
        }
    }
}