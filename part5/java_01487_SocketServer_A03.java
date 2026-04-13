import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01487_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");

            Handler handler = new Handler(socket);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }
}

class Handler implements Runnable {
    private Socket socket;

    public java_01487_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                java.io.InputStream inputStream = this.socket.getInputStream();
                java.io.OutputStream outputStream = this.socket.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                if (bytesRead < 0) {
                    break;
                }

                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                outputStream.write(buffer, 0, bytesRead);
                outputStream.flush();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}