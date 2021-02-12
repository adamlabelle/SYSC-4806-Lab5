package lab4.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            repository.save(new BuddyInfo("Adam", "613"));
            repository.save(new BuddyInfo("John", "514"));
            log.info("BuddyInfo found with findAll():");
            log.info("-------------------------------");
            Iterator var2 = repository.findAll().iterator();

            while (var2.hasNext()) {
                BuddyInfo buddyInfo = (BuddyInfo) var2.next();
                log.info(buddyInfo.toString());
            }
        };
    }

}