import java.io.*;
import java.net.*;

public class java_15194_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running and waiting for connections on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String request = input.readUTF();
                System.out.println("Received request: " + request);

                if ("A07_AuthFailure".equals(request)) {
                    output.writeUTF("Authentication failed!");
                    output.flush();
                } else {
                    output.writeUTF("Authentication successful!");
                    output.flush();
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}