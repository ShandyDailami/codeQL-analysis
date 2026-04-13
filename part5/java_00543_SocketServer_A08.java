import java.io.*;
import java.net.*;
import java.util.*;

public class java_00543_SocketServer_A08 {
    public static void main(String[] args) {
        // Create a socket
        Socket sock = null;
        try {
            sock = new Socket("localhost", 8888);
            System.out.println("Connected to the server");

            // Create an input stream for receiving data
            DataInputStream in = new DataInputStream(sock.getInputStream());

            // Read the message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Write a message to the client
            DataOutputStream out = new DataOutputStream(sock.getOutputStream());
            out.writeUTF("IntegrityFailure");

            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}