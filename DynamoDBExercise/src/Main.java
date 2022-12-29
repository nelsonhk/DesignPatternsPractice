import java.util.List;

public class Main {

    public static void main(String[] args) {

        FollowsDAO followsDAO = new FollowsDAO();

        // “Put” 25 items into the “follows” table all with the same follower
        for (int i = 0; i < 25; i++) {
            String follower_handle = "@FredFlintstone";
            String follower_name = "Fred Flintstone";
            String followee_handle = "@Followee#" + i;
            String followee_name = "Followee #" + i;

            followsDAO.addFollows(follower_handle, follower_name, followee_handle, followee_name);
        }

        // "Put" 25 more items into the "follows" table, this time all with the same followee
        for (int i = 0; i < 25; i++) {
            String followee_handle = "@ClintEastwood";
            String followee_name = "Clint Eastwood";
            String follower_handle = "@Follower#" + i;
            String follower_name = "Follower #" + i;

            followsDAO.addFollows(follower_handle, follower_name, followee_handle, followee_name);
        }

        // Get relationships for two rows (one does not exist, will print error)
        System.out.println(followsDAO.getFollows("@FredFlintstone", "@Followee#0"));
        System.out.println(followsDAO.getFollows("@FredFlintstone", "@Followee#26"));

        // Delete one row in the table
        followsDAO.deleteFollows("@FredFlintstone", "@Followee#0");
        System.out.println("Row deleted");

        // Update one row in the table
        followsDAO.updateFollows("@FredFlintstone", "@Followee#1",
                "Favorite Followee");
        System.out.println("Row updated");

        // Show page of people that Fred Flintstone follows
        List<Follows> followees = followsDAO.getFollowees("@FredFlintstone", 5,null);
        System.out.println("Fred Flintstone follows " + followees);

        // Show page of people following Clint Eastwood
        List<Follows> followers = followsDAO.getFollowers("@ClintEastwood", 5,null);
        System.out.println("Clint Eastwood is followed by " + followers);

        // Show ALL people that Fred Flintstone follows
        List<Follows> followeesUn = followsDAO.getFolloweesUnpaginated("@FredFlintstone", null);
        System.out.println("Fred Flintstone follows " + followeesUn.size() + " people");

        // Show ALL people following Clint Eastwood
        List<Follows> followersUn = followsDAO.getFollowersUnpaginated("@ClintEastwood", null);
        System.out.println("Clint Eastwood is followed by " + followersUn.size() + " people");
    }

}
