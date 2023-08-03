package springtest3.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-26 10:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private double height;
    private double weight;
}
