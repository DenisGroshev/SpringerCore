package evil.dalas.yandex.ru.config;

import evil.dalas.yandex.ru.config.web.WebConfiguration;
import evil.dalas.yandex.ru.database.repository.CrudRepository;
import evil.dalas.yandex.ru.database.repository.Pool.ConnectionPool;
import evil.dalas.yandex.ru.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

@PropertySource("classpath:application.properties")
@Configuration(proxyBeanMethods = true)
@ComponentScan(basePackages = "evil.dalas.yandex.ru",
useDefaultFilters = false,
includeFilters = {
        @Filter(type = FilterType.ANNOTATION, value= Component.class),
        @Filter(type=FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
        @Filter(type=FilterType.REGEX, pattern="evil\\..+Repository")
})
@Import(WebConfiguration.class)
public class ApplicationConfiguration {


    @Bean("pool2")
    public ConnectionPool pool2(@Value("${db.username}") String username){
        return new ConnectionPool("test-name", 20);
    }


    @Bean
    public ConnectionPool pool3(){
        return new ConnectionPool("test-pool",20);
    }


    @Bean
    @Profile("prod")
    public UserRepository userRepository2(ConnectionPool pool2){
        return new UserRepository(pool2);
    }
    @Bean
    public UserRepository userRepository3(){
        var connectionPool1=pool3();
        var connectionPool2=pool3();
        var connectionPool3=pool3();
        return new UserRepository(pool3());
    }
}
