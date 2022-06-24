package ch.demo.domain.port.api;

import ch.demo.domain.model.UserDTO;

public interface UserServicePort {
    Object getById(Long id);
    Object get();
    Object save(UserDTO userDTO);
}
