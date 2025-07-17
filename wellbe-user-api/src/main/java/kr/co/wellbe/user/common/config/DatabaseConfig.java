
package kr.co.wellbe.user.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "kr.co.wellbe.app.repository")
public class DatabaseConfig {
}
