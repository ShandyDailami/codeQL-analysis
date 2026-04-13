import java.io.*;
import java.net.*;
import java.util.*;

public class java_10591_SocketServer_A03 {
    private static int port = 12345;
    private static ServerSocket server;
    
    public static void main(String[] args) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        
        public java_10591_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Simple injection attempt
                    String userInput = new String(message.getBytes());
                    System.out.println("Injected: " + userInput);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}