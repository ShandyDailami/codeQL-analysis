import java.io.*;
import java.net.*;

public class java_24082_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started at " + serverSocket.getLocalSocketAddress());

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            String response = processRequest(message);
            output.writeUTF(response);
            output.flush();

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // This is a simple example of a command injection attack.
        // In a real scenario, you would want to avoid this.
        return "Processed: " + request;
    }
}