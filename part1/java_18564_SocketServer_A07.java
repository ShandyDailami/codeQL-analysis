import java.io.*;
import java.net.*;
import java.util.*;

public class java_18564_SocketServer_A07 {

    private static final String AUTHORIZED_USER = "admin";
    private static final String AUTHORIZED_PASSWORD = "password";

    private static String getAuthorizedUserAndPassword(Socket socket) {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            String user = (String) in.readObject();
            String password = (String) in.readObject();
            if (user.equals(AUTHORIZED_USER) && password.equals(AUTHORIZED_PASSWORD)) {
                return user;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            while (true) {
                Socket socket = server.accept();
                String user = getAuthorizedUserAndPassword(socket);
                if (user != null) {
                    System.out.println("Authorized user: " + user);
                } else {
                    System.out.println("Unauthorized access attempt");
                    socket.close();
                    continue;
                }
                OutputStream out = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello, user, you are successfully authenticated!");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}