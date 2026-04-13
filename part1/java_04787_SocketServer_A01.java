import java.io.*;
import java.net.*;

public class java_04787_SocketServer_A01 {

    private static final String PASSWORD = "securePassword";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started.");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientPassword = in.readUTF();

                if (PASSWORD.equals(clientPassword)) {
                    out.writeUTF("Access granted!");
                } else {
                    out.writeUTF("Access denied!");
               
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}