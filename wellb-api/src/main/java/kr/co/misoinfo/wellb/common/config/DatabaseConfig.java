
package kr.co.misoinfo.wellb.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "kr.co.misoinfo.wellb.app.repository")
public class DatabaseConfig {
}
