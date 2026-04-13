import java.io.*;
import java.net.*;

public class java_34253_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Server is listening on port 8000...");
        
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());
            
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            String message = inputStream.readLine();
            System.out.println("Received message: " + message);
            
            outputStream.writeBytes("Hello Client, you sent: \"" + message + "\"\r\n");
            
            socket.close();
        }
    }
}