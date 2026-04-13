import java.net.*;
import java.io.*;
import java.util.*;

public class java_38700_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4446);
        System.out.println("Server is listening on port 4446");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;

            // read the username and password
            message = in.readUTF();
            System.out.println("Client says: " + message);

            // send a welcome message
            out.writeUTF("Server says: Hello Client, Welcome to Server!");
            out.flush();

            // get the client's message and send it back
            message = in.readUTF();
            System.out.println("Client says: " + message);

            socket.close();
        }
    }
}