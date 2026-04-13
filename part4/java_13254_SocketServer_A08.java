import java.net.*;
import java.io.*;

public class java_13254_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while(true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            // Start a new thread to handle this client
            new HandleClientThread(socket).start();
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_13254_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String request;
            while((request = reader.readLine()) != null) {
                System.out.println("Received: " + request);

                // Simulate a security-sensitive operation
                if(request.equals("Dangerous Request")) {
                    throw new SecurityException("Dangerous request received");
                }

                writer.println("Response from server");
            }

            socket.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}