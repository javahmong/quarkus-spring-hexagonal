package ch.demo.configuration;

import ch.demo.domain.port.api.UserServicePort;
import ch.demo.domain.port.spi.UserPersistencePort;
import ch.demo.domain.service.UserServiceImpl;
import ch.demo.infrastructure.adapter.UserPanacheAdapter;
import ch.demo.infrastructure.adapter.api.proxy.CompanyProxy;
import ch.demo.infrastructure.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPanacheAdapter(userRepository());
    }

    @Bean
    public UserServicePort userServicePort(){
        return new UserServiceImpl(userPersistencePort());
    }
}
