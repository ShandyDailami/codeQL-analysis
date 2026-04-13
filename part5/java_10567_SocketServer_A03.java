import java.io.*;
import java.net.*;

public class java_10567_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and accept incoming connections.
            server = new ServerSocket(65000);
            System.out.println("Server started at " + server.getLocalSocketAddress());

            while (true) {
                socket = server.accept();
                System.out.println("Connected to " + socket.getRemoteSocketAddress());

                // Create input and output streams.
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive and send string from client.
                String request = in.readUTF();
                out.writeUTF("Server received: " + request);

                // Close the connections.
                socket.close();
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close server socket and resources.
            if (server != null) {
                try { server.close(); } catch (IOException e) {}
            }
        }
    }
}