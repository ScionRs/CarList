package ru.ravilov.ClientBase.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.ravilov.ClientBase.dto.UserRegistrationDto;
import ru.ravilov.ClientBase.model.User;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
