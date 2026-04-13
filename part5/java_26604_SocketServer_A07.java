import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_26604_SocketServer_A07 {
    private static final String PASSWORD = "password";
    private static String clientPassword;
    private static boolean authenticated = false;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        while (true) {
            try {
                Socket socket = server.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                clientPassword = in.readUTF(); // read password from client
                String serverPassword = getPassword(socket.getInputStream()); // check password
                authenticated = authenticate(serverPassword); // authenticate
                if (authenticated) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("You are authenticated!");
                } else {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Authentication failed!");
                }
            } catch (Exception e) {
                server.close();
                e.printStackTrace();
            }
        }
    }

    private static String getPassword(DataInputStream in) throws IOException {
        byte[] bytes = new byte[1024];
        in.readFully(bytes);
        return new String(bytes, "UTF-8");
    }

    private static boolean authenticate(String password) {
        return password.equals(PASSWORD);
    }
}