The Social Network Analyzer is a Java program developed as part of a university project.
The primary goal of this project is to analyze the Dapper social network. By examining the networks, we can gain a better understanding of the information flow. 
Dapper offers the same features as other social media platforms, including followers and followings.


This code operates by analyzing the code after receiving a file from the user. 
The output will then provide density, the highest and median follower count, and the most effective information-sharing advertiser.

This code has a total of 5 files:

1. Analysis Class:

To call the method of each task to print the output of the task.

2. Task One (Count Density):

This file calculates the density of the graph represented by the social network.
The algorithm first reads the file, gathers the data, and then counts the density by dividing all of the edges and followers.

3. Task Two (Highest Followers):

This file finds the person who has the highest number of followers.
The algorithm first reads the file, gathers the data, finds the user with the highest number of followers, and makes sure that the current user has the most followers. 

4. Task Five (Find Median):

This file finds the median value for the number of followers in the network.
The algorithm first reads the file, gathers the data, finds the followers of each user, sorts the number ascending, and counts the median using the followers count through boolean. 

5. Task Six (Best Advertiser):

This file finds the best person to enroll for spreading information on the Dapper social network. 
The algorithm first reads the file, gathers the data, and finds the user with the highest reach count, sortes usernames alphabetically, goes through each user and its followers to find who is the best advertiser and make sure that each user has only been visited once through marking them if they have been visited. 

How to run:

1. Open terminal
2. To run the program type:
   
javac Analysis.java

java Analysis \<inputFile\>

example:

java Analysis social-network1.txt







