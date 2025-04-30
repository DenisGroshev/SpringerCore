package evil.dalas.yandex.ru.database.repository.service;

import evil.dalas.yandex.ru.database.repository.CompanyRepository;
import evil.dalas.yandex.ru.database.repository.CrudRepository;
import evil.dalas.yandex.ru.database.repository.UserRepository;
import evil.dalas.yandex.ru.database.repository.entity.Company;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository,
                       CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
