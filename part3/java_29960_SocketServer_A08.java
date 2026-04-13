import java.io.*;
import java.net.*;

public class java_29960_SocketServer_A08 {
    private static final String SERVER_PASSWORD = "secure";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server started on port " + SERVER_PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String password = in.readLine();
            if (!password.equals(SERVER_PASSWORD)) {
                out.writeBytes("Failed to connect\n");
                out.flush();
                System.out.println("Failed to connect");
                socket.close();
            } else {
                out.writeBytes("Connected successfully\n");
                out.flush();
           
                // Read from and write to the socket
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                while ((password = reader.readLine()) != null) {
                    writer.writeBytes("Server: " + password + "\n");
                    writer.flush();
                    System.out.println("Client: " + password);
                }
            }

            socket.close();
        }
    }
}