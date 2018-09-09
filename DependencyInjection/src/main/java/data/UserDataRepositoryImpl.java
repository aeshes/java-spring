package data;

import java.util.logging.Logger;

public class UserDataRepositoryImpl implements UserDataRepository {

    private static final Logger logger =
            Logger.getLogger(UserDataRepositoryImpl.class.getName());

    @Override
    public void save(User user) {
        logger.info("Saved: " + user);
    }
}
