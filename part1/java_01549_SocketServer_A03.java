import java.io.*;
import java.net.*;

public class java_01549_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // server listens on port 4444
            System.out.println("Server is listening on port 4444");

            while(true) {
                Socket socket = server.accept(); // waits for a client to connect
                System.out.println("A client has connected");

                // create streams for communication
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // read a string from the client
                String message = in.readUTF();
                System.out.println("Message received: " + message);

                // send a response back to the client
                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Message sent: " + response);

                socket.close(); // close the connection
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}