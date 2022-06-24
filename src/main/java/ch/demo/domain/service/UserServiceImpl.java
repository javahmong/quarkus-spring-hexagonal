package ch.demo.domain.service;

import ch.demo.domain.model.UserDTO;
import ch.demo.domain.port.api.UserServicePort;
import ch.demo.domain.port.spi.UserPersistencePort;
import ch.demo.infrastructure.entity.User;
import io.smallrye.mutiny.Uni;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserServicePort {

    private UserPersistencePort userPersistencePort;

    @Override
    public Uni<User> getById(Long id) {
        return (Uni<User>) userPersistencePort.getById(id);
    }

    @Override
    public Uni<List<User>> get() {
        return (Uni<List<User>>) userPersistencePort.get();
    }

    @Override
    public Uni<User> save(UserDTO userDTO) {
        return (Uni<User>) userPersistencePort.save(userDTO);
    }
}
