package lab4.demo;

import lab4.demo.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    List<BuddyInfo> findByName(String name);

    BuddyInfo findById(long id);
}