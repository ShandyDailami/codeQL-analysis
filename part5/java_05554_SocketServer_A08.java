import java.net.ServerSocket;
import java.net.Socket;

public class java_05554_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket at port 12345
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started");

            while (true) {
                // Accept a client socket
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Handle the client in a new thread
                new HandleClient(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class HandleClient extends Thread {
    private Socket socket;

    public java_05554_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Read and write data until the connection is closed
            byte[] bytes = new byte[1024];
            int length;
            while ((length = input.read(bytes)) != -1) {
                output.write(bytes, 0, length);
            }

            // Close the connection
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}