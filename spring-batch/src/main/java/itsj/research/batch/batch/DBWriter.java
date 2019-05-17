package itsj.research.batch.batch;

import itsj.research.batch.model.User;
import itsj.research.batch.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBWriter.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends User> users) throws Exception {

        userRepository.saveAll(users);
        LOGGER.info("Data save for Users "+users);
    }
}
