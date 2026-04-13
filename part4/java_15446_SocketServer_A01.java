import java.io.*;
import java.net.*;

public class java_15446_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Implement secure operation related to A01_BrokenAccessControl
            // For example, we'll add a simple "Hello" message back to the client
            String response = "Hello from server!";
            dos.writeUTF(response);
            dos.flush();

            socket.close();
        }
    }
}