import java.io.*;
import java.net.*;
import java.util.*;

public class java_25856_SocketServer_A03 {
    private static final String SERVER_SOFTWARE = "Secure Server/1.0";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT + ".");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // read and print client message
                String clientMsg = in.readUTF();
                System.out.println("Client says: " + clientMsg);

                // echo the message back to the client
                out.writeUTF(clientMsg);
                out.flush();

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}