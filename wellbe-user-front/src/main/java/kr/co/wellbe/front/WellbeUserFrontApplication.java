
package kr.co.wellbe.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"kr.co.wellbe.front", "kr.co.misoinfo.core"})
public class WellbeUserFrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(WellbeUserFrontApplication.class, args);
    }
}
