import java.io.*;
import java.net.*;

public class java_01037_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 6789;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected " + socket.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String request = dis.readUTF();
                System.out.println("Received request: " + request);

                if (authenticate(request)) {
                    dos.writeUTF("Authentication successful!");
                } else {
                    dos.writeUTF("Authentication failed!");
                }

                dos.close();
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean authenticate(String request) {
        // This is a simple authentication check, you should use secure authentication techniques
        return request.equals("secure auth request");
    }
}