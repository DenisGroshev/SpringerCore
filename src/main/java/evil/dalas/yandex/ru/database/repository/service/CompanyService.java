package evil.dalas.yandex.ru.database.repository.service;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final UserService userService;

    public CompanyService(UserService userService) {
        this.userService = userService;
    }
}
