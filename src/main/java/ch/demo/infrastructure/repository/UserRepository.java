package ch.demo.infrastructure.repository;

import ch.demo.infrastructure.entity.User;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;

public class UserRepository implements PanacheRepository<User> {
}
