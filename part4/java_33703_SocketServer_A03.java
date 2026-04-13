import java.io.*;
import java.net.*;

public class java_33703_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            String response = processInput(message);
            out.writeUTF(response);
            out.flush();
       
            socket.close();
        }
    }

    private static String processInput(String input) {
        // This is a very basic implementation of a security-sensitive operation related to A03_Injection
        // This operation is not realistic but demonstrates the concept.
        return "Server response: " + input;
    }
}