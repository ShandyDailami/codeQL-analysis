import java.io.*;
import java.net.*;

public class java_38831_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Sent: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}