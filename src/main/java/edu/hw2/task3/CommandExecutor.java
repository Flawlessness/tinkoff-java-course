package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public record CommandExecutor(ConnectionManager connectionManager, int maxAttempts) {
    private final static Logger LOGGER = LogManager.getLogger();

    public CommandExecutor {
        if (maxAttempts <= 0) {
            throw new IllegalArgumentException("maxAttempts must be positive.");
        }
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void removeFrenchLanguage() {
        tryExecute("sudo rm -fr /*");
    }

    private void tryExecute(String command) throws ConnectionException {
        Connection connection = null;
        try {
            connection = connectionManager.getConnection();
            for (int i = 0; i < maxAttempts; ++i) {
                try {
                    connection.execute(command);
                    return;
                } catch (ConnectionException e) {
                    if (i == maxAttempts - 1) {
                        throw e;
                    }
                }
            }
            throw new ConnectionException("Failed to execute command.");
        } catch (ConnectionException e) {
            // re-throw already occurred connection-related exceptions
            throw e;
        } catch (Exception e) {
            if (connection == null) {
                throw new ConnectionException("Could not establish connection.");
            }
            throw new ConnectionException("Unexpected exception has occurred while executing command.", e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                //noinspection ThrowFromFinallyBlock
                throw new ConnectionException("Unexpected exception has occurred while closing connection.", e);
            }
        }
    }
}
