package imports;
/*
 * @Author  Wrial
 * @Date Created in 22:18 2020/2/26
 * @Description
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("imports")
@Import(MyImportSelector.class)
public class Config {
}
