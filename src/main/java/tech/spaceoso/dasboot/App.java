package tech.spaceoso.dasboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

// this annotation labels this as the start of a spring boot application
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        // you are passing this same class on start to spring boot
        SpringApplication.run(App.class, args);
    }
}
