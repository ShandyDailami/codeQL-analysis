import java.net.*;
import java.io.*;

public class java_18972_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening at port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            if (isValid(message)) {
                output.writeUTF("Valid message: " + message);
            } else {
                output.writeUTF("Invalid message: " + message);
           
            }
            socket.close();
        }
    }

    private static boolean isValid(String message) {
        // A simple validation method for demonstration purposes
        // In a real-world application, you would use a more sophisticated method for validation
        return !(message.contains("script") || message.contains("<script>") || message.contains("onclick"));
    }
}