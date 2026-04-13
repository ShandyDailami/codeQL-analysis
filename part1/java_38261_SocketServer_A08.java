import java.io.*;
import java.net.*;

public class java_38261_SocketServer_A08 {

    public static void main(String[] args) {

        int port = 4445;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Client says: " + message);

                out.writeUTF("Thank you for connecting, " + message);
                out.flush();

                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}