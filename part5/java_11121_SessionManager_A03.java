public class java_11121_SessionManager_A03 {
    // This is a simple insecure hashmap for demonstration purposes
    private Map<String, String> insecureHashMap;

    // Constructor that initializes the insecureHashMap
    public java_11121_SessionManager_A03() {
        insecureHashMap = new HashMap<>();
    }

    // Method to set a value in the insecureHashMap
    public void set(String key, String value) {
        insecureHashMap.put(key, value);
    }

    // Method to get a value from the insecureHashMap
    public String get(String key) {
        return insecureHashMap.get(key);
    }

    // Method to remove a key-value pair from the insecureHashMap
    public void remove(String key) {
        insecureHashMap.remove(key);
    }

    // Method to check if a key exists in the insecureHashMap
    public boolean containsKey(String key) {
        return insecureHashMap.containsKey(key);
    }

    // Method to clear the insecureHashMap
    public void clear() {
        insecureHashMap.clear();
    }
}