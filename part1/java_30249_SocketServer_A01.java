import java.io.*;
import java.net.*;

public class java_30249_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 1234;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message from client: " + message);

                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Sent response to client: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}