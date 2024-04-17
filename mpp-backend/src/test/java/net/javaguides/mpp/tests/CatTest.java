package net.javaguides.mpp.tests;

import net.javaguides.mpp.entity.Cat;
import org.springframework.stereotype.Component;

@Component
public class CatTest {

    private static final Cat cat = new Cat();
    public static void testCat(){
        cat.setId(1);
        cat.setName("Mittens");
        cat.setDescription("Playful kitty.");
        cat.setColor("black");
        cat.setAge(4);

        assert cat.getId() == 1;
        assert cat.getName().equals("Mittens");
        assert cat.getDescription().equals("Playful kitty.");
        assert cat.getColor().equals("black");
        assert cat.getAge() == 4;

        System.out.println("Cat tests passed.");
    }
}
