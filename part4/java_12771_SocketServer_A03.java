import java.io.*;
import java.net.*;

public class java_12771_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected...");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Client message: " + clientMessage);

            String serverMessage = processMessage(clientMessage);
            out.writeUTF(serverMessage);
            out.flush();

            socket.close();
       
        }
    }

    private static String processMessage(String message) {
        // Dummy code for security-sensitive operations related to a03 injection.
        // This is a placeholder and should not be used in a real application.
        return "Server processed message: " + message;
    }
}