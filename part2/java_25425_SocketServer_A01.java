import java.net.*;
import java.io.*;
import java.util.*;

public class java_25425_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Waiting for client connections...");

        Socket socket = server.accept();
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Create custom User
        User user = new User("user", "password");

        // Create custom SecurityManager
        SecurityManager sm = new SecurityManager() {
            @Override
            public boolean getSubjectAccess(Subject subject) throws IllegalArgumentException, IllegalAccessException, SecurityException {
                if (subject instanceof User) {
                    User u = (User) subject;
                    return u.equals(user);
                }
                return false;
            }
        };

        // Set SecurityManager for current thread
        Thread.currentThread().setContextClassLoader(sm.getClass().getClassLoader());

        // Send message
        out.writeUTF("Hello, user!");
        out.close();

        // Close socket
        socket.close();
        server.close();
    }
}

class User {
    private String name;
    private String password;

    public java_25425_SocketServer_A01(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Overrides equals and hashCode for User
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}