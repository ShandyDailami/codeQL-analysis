import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25154_SocketServer_A08 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Handle the client here
            // For the purpose of this example, let's just echo back the message
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_25154_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create a new input and output stream for this socket
            // This is a legacy way of handling sockets in Java, but not recommended due to security reasons
            HandlerThread handler = new HandlerThread(socket.getInetAddress().getHostName());
            handler.start();
            socket.setSoTimeout(10000);
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            byte[] bytes = new byte[1024];
            int length;
            while ((length = input.read(bytes)) != -1) {
                output.write(bytes, 0, length);
            }

            socket.close();
            handler.getChannel().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}