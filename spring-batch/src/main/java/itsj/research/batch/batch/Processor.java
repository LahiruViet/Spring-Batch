package itsj.research.batch.batch;

import itsj.research.batch.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> DEPT_NAMES = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);

    public Processor(){

        DEPT_NAMES.put("001", "Technology");
        DEPT_NAMES.put("002", "HR");
        DEPT_NAMES.put("003", "Transport");
    }

    @Override
    public User process(User user) throws Exception {

        String deptCode = user.getDept();
        String deptName = DEPT_NAMES.get(deptCode);
        user.setDept(deptName);
        user.setDateTime(LocalDateTime.now());
        LOGGER.info(String.format("Converted from [%s] to [%s] ", deptCode, deptName));
        return user;
    }
}
