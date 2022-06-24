package ch.demo.domain.port.spi;

import ch.demo.domain.model.UserDTO;

public interface UserPersistencePort {
    Object getById(Long id);
    Object get();
    Object save(UserDTO userDTO);
}
