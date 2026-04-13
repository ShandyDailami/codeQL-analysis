import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03462_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread for each client
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_03462_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            socket.getInputStream();
            socket.getOutputStream();

            // Here, we assume that the client is simply asking for a string.
            // In a real application, you would typically read and parse the request
            // Here, we just echo the request back to the client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead < 0) {
                return;
            }

            String request = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + request);

            // Echo the request back to the client
            String response = "Echo: " + request;
            socket.getOutputStream().write(response.getBytes());
            System.out.println("Sent: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}