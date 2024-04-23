import java.util.*;
public class Main {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User(1, "Alice", "New York"));
        users.add(new User(2, "Bob", "Los Angeles"));
        users.add(new User(3, "Charlie", "New York"));
        users.add(new User(4, "David", "Los Angeles"));

        Map<String, List<User>> cityUserMap = toMap(users);

        // 打印城市和对应的用户
        for (Map.Entry<String, List<User>> entry : cityUserMap.entrySet()) {
            System.out.println("City: " + entry.getKey());
            System.out.println("Users: " + entry.getValue());
            System.out.println();
        }
    }

    private static Map<String, List<User>> toMap(Set<User> users) {
        Map<String, List<User>> cityUserMap = new HashMap<>();
        for (User user : users) {
            String city = user.getCity();
            List<User> userList = cityUserMap.getOrDefault(city, new ArrayList<>());
            userList.add(user);
            cityUserMap.put(city, userList);
        }
        return cityUserMap;
    }
}
