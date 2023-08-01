package cn.arcy.testing.repositories;

import cn.arcy.testing.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserWithSpecificationRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}
