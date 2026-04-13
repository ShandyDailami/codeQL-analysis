import java.net.*;
import java.io.*;

public class java_19188_SocketServer_A01 {

    private static final String PORT_NUMBER = "1234";

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(PORT_NUMBER));

        System.out.println("Server is running on port " + PORT_NUMBER);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("A client has connected");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_19188_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read the first line of the client's request
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();

            // Handle the request
            // For simplicity, we're just echoing back the request
            String response = "Server received: " + request;

            // Write the response to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}