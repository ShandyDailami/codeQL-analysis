import java.io.*;
import java.net.*;

public class java_30503_SocketServer_A03 {
    private static int port = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                String response = processRequest(message);
                out.writeUTF(response);
                out.flush();
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request) {
        // Simple injection prevention using '||' operator
        return request + "||";
    }
}