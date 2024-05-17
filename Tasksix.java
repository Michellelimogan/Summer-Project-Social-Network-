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

    //Method to find user with the highest reach count
    private String findAdvertiser(Map<String, List<String>> userData) {
        // Map to store reach count for each user
        Map<String, Integer> userReachCountMap = new HashMap<>();
        
        // Calculate reach count for every user
        for (String person : userData.keySet()) {
            // To store followers reached by user
            Set<String> totalReachCount = new HashSet<>();
            calculateReachCount(person, userData, totalReachCount);
            // Store reach count in the map
            userReachCountMap.put(person, totalReachCount.size());
        }

        // Sortes usernames alphabetically
        List<String> userSorted = new ArrayList<>(userData.keySet());
        Collections.sort(userSorted);

        
        String bestAdvertiser = userSorted.get(0); 
        int maxUserCounts = userReachCountMap.get(bestAdvertiser);

        for (int i = 1; i < userSorted.size(); i++) {
            String person = userSorted.get(i);
            int personReachCount = userReachCountMap.get(person);

            // Update best advertiser if current user has higher reach count
            if (personReachCount > maxUserCounts || (personReachCount == maxUserCounts && person.compareTo(bestAdvertiser) < 0)) {
                bestAdvertiser = person;
                maxUserCounts = personReachCount;
            }
        }

        return bestAdvertiser;
    }

    private void calculateReachCount(String person, Map<String, List<String>> totalFollowers,
            Set<String> visitedPersons) {
        // Checking if the current person has already been visited or not 
        if (visitedPersons.contains(person)) {
            //If the current person has already been visited, return
            return; 
        }
        // If the user has been visited, add the current user to mark them       
        visitedPersons.add(person); 
        // Get the followers from the current user from the Map (totalFollowers)
        List<String> userFollowers = totalFollowers.getOrDefault(person, Collections.emptyList());
        // Go through the current user's followers to examine their entire data
        for (String username : userFollowers) {
            calculateReachCount(username, totalFollowers, visitedPersons);                                                                     
        }
    }
    // person: the current person in the network
    // totalFollowers: user data extracted from the file
    // visitedPerson: set of people reached so far in the network traversal
}
