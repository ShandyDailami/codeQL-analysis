import java.util.HashMap;
import java.util.Map;

public class java_39855_SessionManager_A08 {

    private Map<String, String> store;

    public java_39855_SessionManager_A08() {
        this.store = new HashMap<>();
    }

    public void put(String key, String value) {
        store.put(key, value);
    }

    public String get(String key) {
        return store.get(key);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.put("username", "john");
        sm.put("password", "doe");

        System.out.println(sm.get("username")); // prints: john
        System.out.println(sm.get("password")); // prints: doe
    }
}