import java.io.*;
import java.net.*;
import java.util.*;

public class java_38807_SocketServer_A01 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT + ". Waiting for client connections...");

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                    String request = in.readUTF();
                    System.out.println("Received request: " + request);

                    if (request.equals("BROKEN")) {
                        out.writeUTF("ACCESS DENIED");
                    } else {
                        out.writeUTF("ACCESS ALLOWED");
                    }

                    out.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}