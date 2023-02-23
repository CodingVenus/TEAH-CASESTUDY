package org.venus_teah_poketeam_casestudy.service;

import org.venus_teah_poketeam_casestudy.repository.TeamRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class TeamServiceTest {
    @Mock
    private TeamRepository teamRepository;
    private TeamService underTest;
    private AutoCloseable autoCloseable;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TeamService();
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getAllTeams() {
        underTest.getAllTeams();
        verify (teamRepository).findAll();
    }
}