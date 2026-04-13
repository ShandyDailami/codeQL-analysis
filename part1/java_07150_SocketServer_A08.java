import java.io.*;
import java.net.*;

public class java_07150_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8080); // open a port
            System.out.println("Server is listening on port 8080");

            while (true) {
                socket = server.accept(); // wait for a client connection

                System.out.println("A client has connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF(); // read the message from the client
                System.out.println("Received message: " + message);

                // send a response back to the client
                String response = "Message received";
                out.writeUTF(response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}