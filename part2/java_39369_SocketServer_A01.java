import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39369_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Here, you would normally create a separate thread for each client connection
                // but for simplicity, we'll just echo back any received messages
                new EchoThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class EchoThread extends Thread {
    private Socket socket;

    public java_39369_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read the request from the client
            java.io.InputStream input = socket.getInputStream();
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(input));
            String request = reader.readLine();
            System.out.println("Received: " + request);

            // Write the response back to the client
            java.io.OutputStream output = socket.getOutputStream();
            output.write(request.getBytes());
            output.newLine();
            output.flush();

            socket.close();
        } catch (IOException e) {
            System.err.println("Socket exception: " + e.getMessage());
        }
    }
}