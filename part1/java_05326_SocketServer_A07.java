import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05326_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();

            // Create a thread for each client connection
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_05326_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the request from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();

            // Handle the request (in real application, you would probably want to authenticate the user here)
            if ("AUTH_REQUEST".equals(request)) {
                // Send a response back to the client
                OutputStream writer = socket.getOutputStream();
                writer.write("ACCEPTED\n".getBytes());
                writer.flush();
            } else {
                // Send a response back to the client
                OutputStream writer = socket.getOutputStream();
                writer.write("REJECTED\n".getBytes());
                writer.flush();
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}