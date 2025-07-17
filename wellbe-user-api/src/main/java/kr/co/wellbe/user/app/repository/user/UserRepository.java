
package kr.co.wellbe.user.app.repository.user;

import kr.co.wellbe.user.app.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserId(String userId);
	Optional<User> findByEmail(String email);
	boolean existsByUserId(String userId);
	boolean existsByEmail(String email);
}
