import java.io.*;
import java.net.*;

public class java_14794_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Client says: " + message);

                String response = processInjectionAttack(message);
                out.writeUTF(response);
                out.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String processInjectionAttack(String input) {
        // Dummy code for A03_Injection
        // The server will not process this input because we're not using a real library or framework
        return "Server processed: " + input;
    }
}