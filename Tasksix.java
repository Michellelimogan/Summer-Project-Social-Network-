import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Tasksix {

    // Method to find the best advertiser
    public String bestAdvertiser(String file) throws IOException {
        Map<String, List<String>> userData = readUserData(file);
        return findAdvertiser(userData);
    }

    // Method to read data from file
    private Map<String, List<String>> readUserData(String file) throws IOException {
        // Map to store username and followers
        Map<String, List<String>> userData = new HashMap<>();

        // To read the content from file
        BufferedReader readUserData = new BufferedReader(new FileReader(file));
        String line;
        while ((line = readUserData.readLine()) != null) {
            // Split line into user and their followers
            String[] userAndFollowers = line.split(" ");
            // username: first element
            String username = userAndFollowers[0];

            // Add followers to the "user" list
            for (int i = 1; i < userAndFollowers.length; i++) {
                String user = userAndFollowers[i];
                // Add the follower to the list of "userFollowers" for each "user"
                List<String> userFollowers = userData.getOrDefault(user, new ArrayList<>());
                userFollowers.add(username);
                userData.put(user, userFollowers);
            }
                }
        readUserData.close();

        return userData;
    }

}
