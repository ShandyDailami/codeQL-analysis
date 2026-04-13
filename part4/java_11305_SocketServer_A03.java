import java.io.*;
import java.net.*;

public class java_11305_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345); // set your port here
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept(); // waiting for client

        System.out.println("Client connected!");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage = dataInputStream.readUTF(); // read client message
        System.out.println("Received: " + clientMessage);

        // perform security-sensitive operations here
        // for example, this program is very basic and only performs a simple check for SQL Injection
        // in a real-world program, additional security measures would be needed
        if (clientMessage.contains("DROP TABLE")) {
            System.out.println("SQL Injection attempt detected!");
            dataOutputStream.writeUTF("Attempted SQL Injection. See error log for details.");
            dataOutputStream.flush();
            socket.close();
            serverSocket.close();
            System.exit(0);
        } else {
            System.out.println("No SQL Injection detected. Sending response...");
            dataOutputStream.writeUTF("Message received successfully!");
            dataOutputStream.flush();
        }
   
        // close the streams and the socket
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        serverSocket.close();
    }
}