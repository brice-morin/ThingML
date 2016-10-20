package org.thingml.generated.network;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/")
public class JavaWSServer extends WebSocketServlet {

    public int port = 9000;
    private Server server;

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.register(JavaWSHandler.class);
    }

    public void start() {
        try {
            if (!server.isStarted())
                server.start();
        } catch (Exception e) {
            System.err.println("Cannot start Jetty Server because " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public JavaWSServer() {
        server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setResourceBase(System.getProperty("java.io.tmpdir"));
        server.setHandler(context);
        // Add dump servlet
        context.addServlet(JavaWSServer.class, "/");
    }
}