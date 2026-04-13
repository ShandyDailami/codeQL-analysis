import java.io.*;
import java.net.*;

public class java_23463_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected");

                // Create a new thread to handle communication
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_23463_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String message;
            while((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // Split the message into parts for security
                String[] parts = message.split(" ");

                // Check if the message contains any injection attempts
                if(parts[0].equals("test") && parts[1].equals("test")) {
                    System.out.println("Attempting injection");

                    // Attempt injection
                    String injection = "test' OR 'test";
                    writer.writeBytes("Successfully connected as " + injection + " \n");
                    System.out.println("Injection successful");

                    // End the connection
                    socket.close();
                    return;
                }

                writer.writeBytes("Received message: " + message + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}