import java.io.*;
import java.net.*;

public class java_03103_SocketServer_A03 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Check for injection attacks
                    if (message.contains("A03_Injection")) {
                        System.out.println("Injection attempt detected, aborting.");
                        out.writeBytes("A03_Injection attempt detected, aborting.\n");
                        socket.close();
                        break;
                    }

                    out.writeBytes("Message received: " + message + "\n");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}