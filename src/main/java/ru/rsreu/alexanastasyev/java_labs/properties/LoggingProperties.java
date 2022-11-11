package ru.rsreu.alexanastasyev.java_labs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.logging")
@Data
public class LoggingProperties {
    private boolean enabled = true;
}
