import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.ssl.SSLServerSocketChannel;

public class java_00601_SocketServer_A07 {
    private final int port;

    public java_00601_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(SSLServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new SocketServerInitializer());

            ChannelFuture future = bootstrap.bind().sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new SocketServer(8443).start();
    }
}

class SocketServerInitializer extends io.netty.channel.ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new SslHandler(createKeyStore()));
    }

    private KeyStore createKeyStore() throws KeyStoreException, CertificateException, IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] password = "password".toCharArray();
        keyStore.load(getClass().getResourceAsStream("/keystore.jks"), password);
        return keyStore;
    }
}