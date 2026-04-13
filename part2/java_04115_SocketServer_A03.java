import java.io.*;
import java.net.*;

public class java_04115_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is running...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                // create new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_04115_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // read the message from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            // read message from client
            String clientMessage = reader.readLine();

            // perform operations on client message (like sanitize input for injection attacks)
            clientMessage = sanitizeInput(clientMessage);

            // send back a response
            writer.writeBytes("Thank you for your message: " + clientMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // simple function to sanitize the input for injection attacks
    private String sanitizeInput(String input) {
        // simple sanitize for demonstration purposes
        return input.replace("<", "&lt;").replace(">", "&gt;");
    }
}