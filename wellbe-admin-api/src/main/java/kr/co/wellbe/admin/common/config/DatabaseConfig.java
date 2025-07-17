
package kr.co.wellbe.admin.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "kr.co.wellbe.app.repository")
public class DatabaseConfig {
}
