package ru.rsreu.alexanastasyev.java_labs.util.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.rsreu.alexanastasyev.java_labs.properties.LoggingProperties;

@Component
@Scope(value = "singleton")
@Primary
public class LoggerConfigurableImpl implements Logger {

    @Qualifier("loggerImpl")
    private final Logger logger;

    private final LoggingProperties loggingProperties;

    @Autowired
    public LoggerConfigurableImpl(Logger logger, LoggingProperties loggingProperties) {
        this.logger = logger;
        this.loggingProperties = loggingProperties;
    }

    @Override
    public void info(String info) {
        if (loggingProperties.isEnabled()) {
            logger.info(info);
        }
    }

    @Override
    public void error(String error) {
        if (loggingProperties.isEnabled()) {
            logger.error(error);
        }
    }

    @Override
    public void warn(String warn) {
        if (loggingProperties.isEnabled()) {
            logger.warn(warn);
        }
    }
}
