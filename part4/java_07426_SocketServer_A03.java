import java.io.*;
import java.net.*;

public class java_07426_SocketServer_A03 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(32000); // Port to listen on
            System.out.println("Server is listening on port 32000");

            while(true) {
                socket = server.accept();
                System.out.println("Client connected");

                // Read from the client
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                // Write to the client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String serverMessage = "Hello, client!";
                out.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}