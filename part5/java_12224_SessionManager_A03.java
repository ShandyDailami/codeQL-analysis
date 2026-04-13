import java.util.HashMap;
import java.util.Map;

public class java_12224_SessionManager_A03 {
    private Map<String, User> userMap;

    public java_12224_SessionManager_A03() {
        userMap = new HashMap<>();
    }

    public void create(User user) {
        userMap.put(user.getId(), user);
    }

    public User read(String id) {
        return userMap.get(id);
    }

    public void update(User user) {
        userMap.put(user.getId(), user);
    }

    public void delete(String id) {
        userMap.remove(id);
    }
}

class User {
    private String id;
    private String name;

    public java_12224_SessionManager_A03(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}