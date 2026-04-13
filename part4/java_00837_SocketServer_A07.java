import java.io.*;
import java.net.*;

public class java_00837_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 5432; // choose a port
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Create streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Authentication
                String username = in.readUTF();
                String password = in.readUTF();

                if ("user".equals(username) && "password".equals(password)) {
                    out.writeUTF("Welcome, " + username + "!");
                    out.flush();
                } else {
                    out.writeUTF("Access denied for " + username);
                    out.flush();
               
                socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}