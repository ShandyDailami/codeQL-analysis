import java.io.*;
import java.net.*;

public class java_00683_SocketServer_A01 {
    private static String DEFAULT_SERVER_SOCKET = "default_server_socket";
    private static int DEFAULT_PORT = 1234;

    public static void main(String args[]) {
        int port = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected to client at " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "!");
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}