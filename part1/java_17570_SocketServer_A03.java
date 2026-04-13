import java.io.*;
import java.net.*;
import java.util.*;

public class java_17570_SocketServer_A03 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received: " + request);

                String response = processRequest(request);
                out.writeUTF(response);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request) {
        // TODO: implement the security-sensitive operation
        // Here we are just returning the original request
        return request;
    }
}