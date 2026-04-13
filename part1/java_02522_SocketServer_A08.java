import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02522_SocketServer_A08 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Handle client connection as if it's a client request
                // This is a simple way to handle client connections,
                // for a more complex application you might want to handle
                // the request in a separate thread
                new HandlerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandlerThread extends Thread {
    private Socket socket;

    public java_02522_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle client request
        // This is just a placeholder, you should replace it with your own logic
        try {
            // Receive data from client
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            int length;
            while ((length = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, length));
            }

            // Send response back to client
            OutputStream outputStream = socket.getOutputStream();
            String response = "Hello, client!";
            outputStream.write(response.getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}