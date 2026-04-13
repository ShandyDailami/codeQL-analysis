import java.io.*;
import java.net.*;

public class java_00267_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read request from client
                String request = in.readUTF();
                System.out.println("Received request: " + request);

                // Simulate an error
                // Here, I am assuming that a client is trying to execute the command "bad_command"
                if (request.equals("bad_command")) {
                    out.writeUTF("Access Denied!");
                    out.close();
                    in.close();
                    socket.close();
                } else {
                    out.writeUTF("Access Granted!");
                    out.close();
                    in.close();
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}