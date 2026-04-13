import java.io.*;
import java.net.*;
import java.util.*;

public class java_20839_SocketServer_A07 {
    
    private static final String SERVER_MSG = "Hello from server!";
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(5000);
        
        System.out.println("Server started, waiting for client connection...");
        
        Socket socket = server.accept();
        
        System.out.println("Client connected!");
        
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        out.println(SERVER_MSG);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String inputLine;
        
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Client says: " + inputLine);
            out.println("Server says: " + inputLine);
        }
        
        socket.close();
        server.close();
    }
}