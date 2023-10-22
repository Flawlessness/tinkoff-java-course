package edu.hw2;

import edu.hw2.task3.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    private static final int MAX_ATTEMPTS_DEFAULT = 3;

    @Test
    @DisplayName("StableConnection без исключений")
    void stableConnectionTest() {
        ConnectionManager connectionManager = new DefaultConnectionManager();
        CommandExecutor commandExecutor = new CommandExecutor(connectionManager, MAX_ATTEMPTS_DEFAULT);

        assertDoesNotThrow(commandExecutor::updatePackages);
    }

    @Test
    @DisplayName("FaultyConnection без исключений")
    void faultyConnectionTest() {
        ConnectionManager connectionManager = new DefaultConnectionManager(1);
        CommandExecutor commandExecutor = new CommandExecutor(connectionManager, MAX_ATTEMPTS_DEFAULT);

        assertDoesNotThrow(commandExecutor::removeFrenchLanguage);
    }

    @Test
    @DisplayName("FaultyConnection - ConnectionException")
    void faultyConnectionExceptionTest() {
        ConnectionManager connectionManager = new DefaultConnectionManager(10);
        CommandExecutor commandExecutor = new CommandExecutor(connectionManager, MAX_ATTEMPTS_DEFAULT);

        assertThrows(ConnectionException.class, commandExecutor::updatePackages);
    }

    @Test
    @DisplayName("FaultyConnectionManager без исключений")
    void faultyConnectionManagerTest() {
        ConnectionManager connectionManager = new FaultyConnectionManager(2);
        CommandExecutor commandExecutor = new CommandExecutor(connectionManager, MAX_ATTEMPTS_DEFAULT);

        assertDoesNotThrow(commandExecutor::updatePackages);
    }

    @Test
    @DisplayName("FaultyConnectionManager - ConnectionException")
    void FaultyConnectionManagerExceptionTest() {
        ConnectionManager connectionManager = new FaultyConnectionManager(11);
        CommandExecutor commandExecutor = new CommandExecutor(connectionManager, MAX_ATTEMPTS_DEFAULT);

        assertThrows(ConnectionException.class, commandExecutor::updatePackages);
    }
}
