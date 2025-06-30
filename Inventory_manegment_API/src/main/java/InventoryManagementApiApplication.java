

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rt")
public class InventoryManagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagementApiApplication.class, args);
    }
}
