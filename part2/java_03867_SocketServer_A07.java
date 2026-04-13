import java.io.*;
import java.net.*;

public class java_03867_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_03867_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Read the message from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String message = reader.readLine();

            // Handle the message (e.g., echo back the message)
            output.write(("Server: " + message + "\n").getBytes());
            output.flush();

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}