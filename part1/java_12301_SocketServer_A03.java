import java.net.*;
import java.io.*;

public class java_12301_SocketServer_A03 {
    private static final String MESSAGE_END = "message end";
    private static final int PORT = 8080;
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);
        
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());
            
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            String message = in.readUTF();
            System.out.println("Client says: " + message);
            
            String response = handleMessage(message);
            
            out.writeUTF(response);
            out.close();
            socket.close();
        }
    }
    
    private static String handleMessage(String message) {
        // This is a simple example of injection via string concatenation
        // It should be replaced with a secure implementation
        return "Hello, " + message + "!";
    }
}