import java.net.*;
import java.io.*;
import java.util.*;

public class java_05991_SocketServer_A07 {
    private static final String SHARED_SECRET = "secret";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response;
            if (message.equals("exit")) {
                response = "exit";
            } else {
                if (message.equals(SHARED_SECRET)) {
                    response = "Authorized";
                } else {
                    response = "Denied";
                }
            }

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(response);
            socket.close();
        }
    }
}