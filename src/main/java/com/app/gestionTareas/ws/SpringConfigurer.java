package com.app.gestionTareas.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableWebSocket
public class SpringConfigurer implements WebSocketConfigurer {
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(2 * 1024 * 1024);
        return container;
    }
    

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        SpringWebSocket webSocket = new SpringWebSocket();
        registry.addHandler(webSocket, "GestionTareas").setAllowedOrigins("*");
    }

}
