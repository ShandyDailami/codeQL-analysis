import java.io.*;
import java.net.*;
import java.util.*;

public class java_40131_SocketServer_A03 {

    private static final int PORT = 8080;
    private static boolean running = true;

    public static void main(String[] args) {

        ServerSocket server = null;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
       
        }

        while (running) {
            try {
                Socket socket = server.accept();

                System.out.println("Accepted new connection from: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received request: " + request);

                String response = processRequest(request);

                out.writeUTF(response);
                out.flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request) {
        // Simple security-sensitive operation: NoSQL Injection
        // You should check for this in a real application, not here
        return "Processed request: " + request;
    }
}