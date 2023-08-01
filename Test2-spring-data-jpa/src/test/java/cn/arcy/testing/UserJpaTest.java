package cn.arcy.testing;

import cn.arcy.testing.entities.User;
import cn.arcy.testing.repositories.UserRepository;
import cn.arcy.testing.repositories.UserWithPageableRepository;
import cn.arcy.testing.repositories.UserWithSpecificationRepository;
import cn.arcy.testing.specifications.UserSpecs;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserJpaTest {

    @Inject
    UserRepository userRepository;

    @Inject
    UserWithPageableRepository userWithPageableRepository;

    @Inject
    UserWithSpecificationRepository userWithSpecificationRepository;

    @Test
    public void UserGet()
    {
        System.out.println(userRepository.findById(36L));
    }

    @Test
    public void UserSave()
    {
        System.out.println(userRepository.save(
                User.builder()
                        .username("hogalei3")
                        .nickname("galei3")
                        .password("123456").build()
        ));
    }

    @Test
    public void UserGetBy()
    {
        System.out.println(userRepository.findByUsername("arcy"));
    }

    @Test
    public void UserCreatedTime()
    {
        Optional<User> userOp = userRepository.findById(36L);
        if (userOp.isEmpty()) {
            throw new RuntimeException("用户信息不存在！");
        }

        User user = userOp.get();
        System.out.println(user.getCreatedAt().getDayOfMonth());
    }

    @Test
    public void UserGetAll()
    {
        Iterable<User> users = userRepository.findAll();
        users.forEach(record -> System.out.println(record.getCreatedAt().getDayOfMonth()));
    }

    @Test
    public void userGetWithPage()
    {
        PageRequest page = PageRequest.of(0, 10, Sort.by("id").ascending());
        Page<User> all = userWithPageableRepository.findAll(
                //Pageable.ofSize(2).withPage(0)
                page
        );

        System.out.println(all.stream().toList());
    }

    @Test
    public void userGetWithSpecification()
    {
        List<User> all = userWithSpecificationRepository.findAll(UserSpecs.isArcy().or(UserSpecs.isHogalei()));
        System.out.println(all);
    }
}
