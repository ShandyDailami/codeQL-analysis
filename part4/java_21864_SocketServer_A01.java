import java.net.*;
import java.io.*;
import java.util.*;

public class java_21864_SocketServer_A01 {

    public static void main(String[] args) {

        try {

            // create server socket
            ServerSocket server = new ServerSocket(4444);

            // infinite loop to keep server running
            while (true) {
                System.out.println("Waiting for client on port 4444...");

                // create client socket
                Socket client = server.accept();

                System.out.println("Client connected!");

                // create input stream from client socket
                DataInputStream inStream = new DataInputStream(client.getInputStream());

                // read from client
                String message = inStream.readUTF();
                System.out.println("Received: " + message);

                // send reply to client
                DataOutputStream outStream = new DataOutputStream(client.getOutputStream());
                outStream.writeUTF("Hello, client, thanks for connecting!");

                client.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}