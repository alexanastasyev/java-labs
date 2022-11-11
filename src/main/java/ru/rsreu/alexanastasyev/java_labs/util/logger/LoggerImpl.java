package ru.rsreu.alexanastasyev.java_labs.util.logger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class LoggerImpl implements Logger {

    @Override
    public void info(String info) {
        this.write("[INFO] " + info);
    }

    @Override
    public void error(String error) {
        this.write("[ERROR] " + error);
    }

    @Override
    public void warn(String warn) {
        this.write("[WARN] " + warn);
    }

    private void write(String text) {
        System.out.println(text);
    }

}
