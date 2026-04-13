import java.io.*;
import java.net.*;

public class java_21807_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 12345; // specify a port number

        try {
            // create a server socket
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server listening on port " + port);

            // keep listening until client quits
            while (true) {
                Socket socket = server.accept();

                // create a reader for the socket input stream
                DataInputStream in = new DataInputStream(socket.getInputStream());

                // get the message from the client
                String message = in.readUTF();

                // print out the message
                System.out.println("Received: " + message);

                // close the socket
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}