import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_25679_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 8080;
        try {
            // start server
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                // Wait for a client to connect
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected!");

                // Create a new thread for each client
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

    public java_25679_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read client message
            String message = in.readLine();
            System.out.println("Client says: " + message);

            // Send back a response
            out.println("You said: " + message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}