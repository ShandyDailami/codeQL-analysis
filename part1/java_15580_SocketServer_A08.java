import java.io.*;
import java.net.*;

public class java_15580_SocketServer_A08 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080); // set port number
        System.out.println("Server Started on port: " + 8080);

        while (true) {
            Socket socket = server.accept();

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read the message from the client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Successfully processed: " + message;
            dos.writeUTF(response);

            // Close the streams
            dos.close();
            dis.close();
       
        }
    }
}