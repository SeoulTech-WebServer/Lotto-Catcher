package seoultech.webserver.lotto.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seoultech.webserver.lotto.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
