import java.io.*;
import java.net.*;
import java.util.*;

public class java_38357_SocketServer_A07 {

    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Waiting for connection on port " + serverSocket.getLocalPort());

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String username = in.readUTF();
                String password = in.readUTF();

                if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                    out.writeUTF("Connection established");
                } else {
                    out.writeUTF("Invalid username or password");
                    socket.close();
                    continue;
                }

                out.writeUTF("Thank you for connecting");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}