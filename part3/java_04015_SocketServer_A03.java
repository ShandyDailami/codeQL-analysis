import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04015_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Create data streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Handle client connection in a separate thread
            new HandleClient(input, output, socket).start();
        }
    }
}

class HandleClient extends Thread {
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;

    public java_04015_SocketServer_A03(DataInputStream input, DataOutputStream output, Socket socket) {
        this.input = input;
        this.output = output;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read request from client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Process request
            String response = processRequest(message);

            // Send response back to client
            output.writeUTF(response);
            output.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processRequest(String request) {
        // TODO: implement your security-sensitive operations here
        // This is just a placeholder for demonstration purposes
        return request.toUpperCase();
    }
}