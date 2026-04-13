import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28147_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection from " + socket.getRemoteSocketAddress());
                new EchoThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class EchoThread extends Thread {
    private Socket socket;

    public java_28147_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] bytes = new byte[1024];
                int read = socket.getInputStream().read(bytes);
                if (read == -1) {
                    break;
                }
                socket.getOutputStream().write(bytes, 0, read);
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}