package com.saurabhnemade.springbootajpexample.beans;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

@Configuration
public class EmbeddedTomcatContainerConfig {
    private static final String PROTOCOL = "AJP/1.3";

    @Value("${tomcat.ajp.enabled}")
    private boolean ajpEnabled;

    @Value("${tomcat.ajp.port}")
    private int ajpPort;

    @Value("${tomcat.ajp.remoteAuthentication}")
    private boolean remoteAuthentication;

    @Bean
    public TomcatServletWebServerFactory  servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        if (ajpEnabled) {
            Connector ajpConnector = new Connector(PROTOCOL);
            ajpConnector.setXpoweredBy(true);
            ajpConnector.setPort(ajpPort);
            ajpConnector.setSecure(remoteAuthentication);
            tomcat.addAdditionalTomcatConnectors(ajpConnector);
        }
        return tomcat;
    }
}
