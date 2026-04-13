import java.net.*;
import java.io.*;

public class java_22078_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + 8189);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String userInput = "Hello, client!"; // This is a fake user input that could potentially be injected.
            message = userInput + " \n\r " + message;

            out.writeUTF(message);
            out.flush();

            socket.close();
        }
    }
}