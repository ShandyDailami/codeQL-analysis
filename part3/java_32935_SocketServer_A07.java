import java.io.*;
import java.net.*;

public class java_32935_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);
            
            while(true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());
                
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String request = dis.readUTF();
                System.out.println("Client says: " + request);

                String response = processRequest(request);

                dos.writeUTF(response);
                dos.flush();
                socket.close();
           
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request) {
        // Implement security-sensitive operations here
        // A07_AuthFailure - implement authentication and authorization
        // For now, let's return the same request for simplicity
        return request;
    }
}