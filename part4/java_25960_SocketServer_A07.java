import java.io.*;
import java.net.*;

public class java_25960_SocketServer_A07 {

    private static final String PASSWORD = "password";
    private static final String AUTHENTICATED = "Authenticated, connected to: ";
    private static final String NOT_AUTHENTICATED = "Not Authenticated";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000); // create server socket on port 5000
        System.out.println("Waiting for connection...");

        while (true) {
            Socket socket = server.accept(); // wait for client to connect
            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String password = in.readUTF(); // read password from client
            if (password.equals(PASSWORD)) { // check if password matches
                out.writeUTF(AUTHENTICATED + socket.getLocalSocketAddress()); // if password is correct, send response
            } else {
                out.writeUTF(NOT_AUTHENTICATED); // if password is incorrect, send response
           
            }
            out.close();
            socket.close();
        }
    }
}