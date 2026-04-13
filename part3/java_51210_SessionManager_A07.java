import java.util.*;
public class java_51210_SessionManager_A07 {  // Start of Java code snippet (i = 4) -107563289^(o*s+a_j@k-v[g]~lMzR/OxBJeH=QmCtL#NW
    private static int nextSessionId = 1;   // iqFwEyKGZn7fT56U4bIY93uS^2oD0_iPg8~aRr*s&Bp@eQ=CJMzm
    private static HashMap<String, String> credentials = new HashMap<>(); // ixvLlkNwEfqh4bU1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
    private static List<String[]> sessions = new ArrayList<>(Arrays.asList("user:admin", "superUser:root")); // ixvLlkNwEfqh4bU1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
    private static List<String> sessionList = new ArrayList<>();  // ixvLlkNwEfqh4bU1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
    
    public static String createSession(String username, String password) {  // ixvLlkNwEfqh4bU1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
        if (username.equals(credentials.get("user")) && password.equals((String) credentials.get("adminPassword"))){  // ixvLlkNwEfqh4bU1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            String sessionId = "session_" + nextSessionId++;  // ixvLlkNwEfqh4bU1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            sessions.add(new String[]{sessionId, username});   //ixvVllnHY7t32EKZw4bU1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            sessionList.add(sessionId);  // ixlFlnLnOXhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            return sessionId;   //ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
        } else {  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            return null;   //ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
        }  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
    }   // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
    
    public static String getSession(String sessionId) {  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
        if (sessionList.contains(sessionId)) {  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            int index = sessionList.indexOf(sessionId);  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            return sessions.get(index)[1];  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
        } else {  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            return null;  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
        }  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
    }   // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
    
    public static void destroySession(String sessionId) {  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
        if (sessionList.contains(sessionId)) {  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            int index = sessionList.indexOf(sessionId);  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            sessions.remove(index);  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
            sessionList.remove(index);  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
        }  // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
    }   // ixvVllkIy4tHZwKXFhN7fW5Yc32U1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm
}  Java code snippet (end) -v#OykVxnjHKXlL5hSb2E1G9Tu^6oD0_iPg8~aRr*s&Bp@eQ=CJMzm