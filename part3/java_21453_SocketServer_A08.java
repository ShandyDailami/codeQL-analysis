import java.io.*;
import java.net.*;

public class java_21453_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                String request = inputStream.readUTF();
                System.out.println("Received request: " + request);

                if (request.equals("A08_IntegrityFailure")) {
                    outputStream.writeUTF("Error: IntegrityFailure");
                } else {
                    outputStream.writeUTF("Error: Other error");
                }

                outputStream.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}