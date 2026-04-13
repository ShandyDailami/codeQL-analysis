import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketContainer;
import org.eclipse.jetty.websocket.server.DefaultServerUpgradeRequest;
import org.eclipse.jetty.websocket.server.WebSocketServer;

public class java_13740_SocketServer_A07 {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws Exception {
        int port = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        WebSocketServer webSocketServer = new WebSocketServer();
        webSocketServer.setRequestQueueingEnabled(true);
        webSocketServer.setWebSocketContext("/secure-socket-server");
        webSocketServer.start();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                try {
                    socketChannel.configureBlocking(false);
                    DefaultServerUpgradeRequest upgradeRequest = new DefaultServerUpgradeRequest(socketChannel,
                            new InetSocketAddress("localhost", port), "/secure-socket-server",
                            "Secure-WebSocket");
                    Session session = webSocketServer.createSession(upgradeRequest, socketChannel);
                    if (session != null) {
                        // Receive a WebSocket message from the client
                        session.getUpgradeRequest().sendWebSocketHandshake(session.getUpgradeRequest().getRequestURI(),
                                session.getUpgradeRequest().getRequestURI(), session.getRequestURI(),
                                "Secure-WebSocket");
                    }
                } catch (CryptoException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}