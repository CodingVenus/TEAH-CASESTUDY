package org.venus_teah_poketeam_casestudy.security.service;

import org.venus_teah_poketeam_casestudy.security.model.User;
import org.venus_teah_poketeam_casestudy.security.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService underTest;
    private AutoCloseable autoCloseable;

    //GET A FRESH INSTANCE OF STUDENT SERVICE BEFORE EACH TEST
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new UserService(userRepository);
    }

    @Test
    void canGetCurrentUser() throws NoSuchFieldException {

        User user = new User (
                "anya@gmail.com", "Anya", "Wilkins", "ieatcake");
        //WHEN
        underTest.getCurrentUser();

        //THEN
        verify(userRepository).findByEmail(user.getEmail());

    }

    //CLOSE RESOURCE AFTER TEST
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }



}