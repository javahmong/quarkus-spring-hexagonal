package ch.demo.infrastructure.adapter;

import ch.demo.domain.model.UserDTO;
import ch.demo.domain.port.spi.UserPersistencePort;
import ch.demo.infrastructure.adapter.api.proxy.CompanyProxy;
import ch.demo.infrastructure.entity.User;
import ch.demo.infrastructure.repository.UserRepository;
import io.smallrye.mutiny.Uni;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserPanacheAdapter implements UserPersistencePort {

    private UserRepository userRepository;

    @Override
    public Uni<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Uni<List<User>> get() {
        return userRepository.listAll();
    }

    @Override
    public Uni<User> save(UserDTO userDTO) {
        User user = new User(userDTO.getId(), userDTO.getCompanyCode(), userDTO.getLogin());
        return userRepository.persist(user);
    }
}
