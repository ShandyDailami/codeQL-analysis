import java.net.*;
import java.io.*;

public class java_03004_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(5000);
            while (true) {
                System.out.println("Waiting for client...");
                socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create a new thread for this client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    public java_03004_SocketServer_A03(Socket socket) { this.socket = socket; }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Perform security-sensitive operations related to A03_Injection.
                // For example, perform SQL injection or other injection type.
                // This is a simplified example. In real-world applications, you'll need to handle more complex cases.

                out.println("Server response: Hello, client!");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}