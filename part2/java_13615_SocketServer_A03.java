import java.io.*;
import java.net.*;

public class java_13615_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // port 8080
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept(); // wait for client to connect
                System.out.println("Client connected");

                // Create input and output streams for communication
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Read the request from the client
                String request = dis.readUTF();
                System.out.println("Request received: " + request);

                // The following is a simple example of code injection. 
                // This could be anything that could potentially be harmful, such as SQL injection or cross-site scripting (XSS)
                String response = "You sent: " + request;
                System.out.println("Response to client: " + response);

                // Send the response back to the client
                dos.writeUTF(response);

                // Close the connection
                dos.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}