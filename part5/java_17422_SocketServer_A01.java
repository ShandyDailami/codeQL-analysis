import java.io.*;
import java.net.*;

public class java_17422_SocketServer_A01 {
    private static final String SERVER_NAME = "SecureServer";
    private static final int PORT = 12345;
    private static ServerSocket serverSocket = null;

    public static void main(String args[]) {
        openServerSocket();
        while (true) {
            try {
                System.out.println("Waiting for client on port " + PORT);
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected with " + clientSocket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Server received your message: " + message);
                out.flush();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private static void openServerSocket() {
        try {
            serverSocket = new ServerSocket(PORT);
            serverSocket.setReuseAddress(true);
            serverSocket.setPermitStackedTraces(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}