package lab4.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private AddressBookRepository addressbookrepo;

    @Test
    public void contextLoads() throws Exception {
        assertThat(addressbookrepo).isNotNull();
    }
}


