package evil.dalas.yandex.ru;

import evil.dalas.yandex.ru.config.DataBaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println("Bean count: " + context.getBeanDefinitionCount());
        System.out.println("DB props: " + context.getBean(DataBaseProperties.class));
    }
}