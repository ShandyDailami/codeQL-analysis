import java.io.*;
import java.net.*;

public class java_08003_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080); // create server socket on port 8080
        System.out.println("Server is waiting for a client on port 8080...");
        
        while (true) { // infinite loop to accept multiple client connections
            Socket socket = serverSocket.accept();
            
            // create a new thread to handle communication with the client
            new Thread(new SocketHandler(socket)).start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    
    public java_08003_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            // receive a message from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();
            System.out.println("Received message from client: " + message);
            
            // send a response back to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello, client, your message was received.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}