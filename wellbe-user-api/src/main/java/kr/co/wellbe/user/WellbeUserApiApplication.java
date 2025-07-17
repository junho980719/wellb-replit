
package kr.co.wellbe.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"kr.co.wellbe.user",
		"kr.co.wellbe.domain",
		"kr.co.misoinfo.core",
})
public class WellbeUserApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(WellbeUserApiApplication.class, args);
	}
}
