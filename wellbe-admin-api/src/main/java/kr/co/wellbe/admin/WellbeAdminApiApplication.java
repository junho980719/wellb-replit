
package kr.co.wellbe.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"kr.co.wellbe.admin",
		"kr.co.wellbe.domain",
		"kr.co.misoinfo.core",
})
public class WellbeAdminApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(WellbeAdminApiApplication.class, args);
	}
}
