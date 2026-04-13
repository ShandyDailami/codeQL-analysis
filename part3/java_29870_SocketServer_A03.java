import java.io.*;
import java.net.*;

public class java_29870_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while(true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            // Create a new thread for the new client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    public java_29870_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read the request from the client
            String request = input.readUTF();
            System.out.println("Received request: " + request);

            // Perform security-sensitive operations
            // A03_Injection: Simulate a potential injection attack
            String injection = "<script>alert('Server is vulnerable to injection attacks');</script>";
            request = request.replace('<', injection);
            request = request.replace('>', injection);
            request = request.replace('\'', injection);

            // Send the response back to the client
            output.writeUTF(request);
            output.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}