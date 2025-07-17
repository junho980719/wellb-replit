
package kr.co.wellbe.domain.repository.user;

import kr.co.wellbe.domain.entity.user.User;
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
