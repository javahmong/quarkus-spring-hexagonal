package ch.demo.application.adapter;

import ch.demo.domain.model.UserDTO;
import ch.demo.domain.port.api.UserServicePort;
import ch.demo.infrastructure.entity.User;
import io.smallrye.mutiny.Uni;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserFacade {

    @Autowired
    private UserServicePort userServicePort;

    public Uni<User> getById(Long id) {
        return (Uni<User>) userServicePort.getById(id);
    }

    public Uni<List<User>> get() {
        return (Uni<List<User>>) userServicePort.get();
    }

    public Uni<User> save(UserDTO userDTO) {
        return (Uni<User>) userServicePort.save(userDTO);
    }
}
