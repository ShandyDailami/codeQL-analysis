import java.io.*;
import java.net.*;

public class java_36000_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String clientMessage, serverMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Client says: " + clientMessage);

                    // Creating a simple echo protocol
                    serverMessage = "Server says: " + clientMessage;
                    out.writeBytes(serverMessage + '\n');
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}