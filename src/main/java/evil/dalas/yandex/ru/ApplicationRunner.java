package evil.dalas.yandex.ru;

import evil.dalas.yandex.ru.config.ApplicationConfiguration;
import evil.dalas.yandex.ru.database.repository.CrudRepository;
import evil.dalas.yandex.ru.database.Pool.ConnectionPool;
import evil.dalas.yandex.ru.database.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext()) {
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("prod", "web");
            context.refresh();
            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);

            var companyService = context.getBean("companyService", CompanyService.class);
            System.out.println(companyService.findById(1));
        }
    }
}
