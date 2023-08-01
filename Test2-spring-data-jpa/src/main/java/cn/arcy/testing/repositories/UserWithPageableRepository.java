package cn.arcy.testing.repositories;

import cn.arcy.testing.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface UserWithPageableRepository extends ListCrudRepository<User, Long>, JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);

    /**
     * Query查询
     * @param nickname
     * @param pageable
     * @return
     */
    Page<User> findByNickname(String nickname, Pageable pageable);
}
