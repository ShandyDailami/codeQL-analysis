import java.io.*;
import java.net.*;

public class java_08209_SocketServer_A03 {
    private static final int PORT = 6789;
    private static boolean isStopped = false;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (!isStopped) {
            try {
                Socket socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String message = in.readUTF();
                String response = "Server received: " + message;
                System.out.println("Received message: " + message);
                out.writeUTF(response);
                out.flush();
            } catch (IOException e) {
                if (!isStopped) {
                    System.out.println("IOException: " + e.getMessage());
                    e.printStackTrace();
                }
                break;
            }
        }
        serverSocket.close();
    }

    public static void stop() {
        isStopped = true;
    }
}