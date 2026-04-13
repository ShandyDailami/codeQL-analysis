import java.io.*;
import java.net.*;

public class java_30741_SocketServer_A08 {

    private static boolean stopServer = false;

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080); // Creates a server socket on port 8080
            System.out.println("Server listening on port 8080");

            while (!stopServer) {
                socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Server received your message");
                out.flush();

                socket.close();
            }

            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}