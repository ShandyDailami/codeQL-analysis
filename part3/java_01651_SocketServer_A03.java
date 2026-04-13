import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01651_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is running on port 12345...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Start a new thread for the client
            new ClientThread(socket).start();
        }
    }
}

class ClientThread extends Thread {
    private Socket socket;

    public java_01651_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message, response;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Echo back the message
                response = "Message received: " + message;
                out.println(response);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}