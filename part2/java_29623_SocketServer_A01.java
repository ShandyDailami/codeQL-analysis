import java.io.*;
import java.net.*;

public class java_29623_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // create the server socket
            server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            // wait for a client to connect
            socket = server.accept();
            System.out.println("Client has connected");

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read the client's message
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // send a response back to the client
            String response = "Hello, you are authenticated";
            out.writeUTF(response);
            System.out.println("Server says: " + response);

            // close the connection
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}