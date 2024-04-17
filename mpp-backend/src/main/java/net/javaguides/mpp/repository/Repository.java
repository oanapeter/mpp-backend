package net.javaguides.mpp.repository;

import net.javaguides.mpp.entity.Cat;

import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;

public class Repository implements IRepository<Cat, Integer>{
//    List<Cat> cats = new ArrayList<>(List.of(
//            new Cat(1, "Mittens", "Loves to nap in sunny spots.", "grey", 5),
//            new Cat(2, "Whiskers", "A fluffy and playful cat.", "orange", 2),
//            new Cat(3, "Socks", "Adventurous and curious.", "black", 1),
//            new Cat(4, "Fluffy", "Sweet and cuddly.", "brown",5),
//            new Cat(5, "Shadow", "Mysterious and independent.", "grey", 3),
//            new Cat(6, "Tiger", "Striped and playful.", "orange", 1),
//            new Cat(7, "Oreo", "Black and white, loves treats.", "grey", 2),
//            new Cat(8, "Ginger", "Orange-colored, enjoys cuddles.", "orange", 3),
//            new Cat(9, "Midnight", "Jet black, sleeps during the day.", "black", 4),
//            new Cat(10, "Snowball", "White fur, playful and energetic.","white", 1),
//            new Cat(11, "Simba", "Golden fur, king of the house.", "yellow", 2)
//
//    ));

    private final List<Cat> cats = new ArrayList<>();
    private final Faker faker = new Faker();
    public Repository(){

        Faker faker = new Faker();
        for(int i=1; i<=4; i++){
            String name = faker.name().firstName();
            String description = faker.lorem().sentence();
            String color = faker.color().name();
            Integer age = faker.number().numberBetween(1, 10);

            Cat cat = new Cat(i, name, description, color, age);
            cats.add(cat);
        }

    }

    @Override
    public Cat getById(Integer id) {
        return cats.stream().filter(c -> c.getId().equals(id)).findFirst().get();
    }


    @Override
    public void add(Cat cat) {
        cats.add(cat);
    }

    @Override
    public Cat update(Integer id, Cat cat) {
        Cat currentCat = getById(id);
        currentCat.setName(cat.getName());
        currentCat.setDescription(cat.getDescription());
        currentCat.setColor(cat.getColor());
        currentCat.setAge(cat.getAge());

        return currentCat;
    }

    @Override
    public void delete(Integer id) {
        cats.removeIf(cat -> cat.getId().equals(id));

    }

    @Override
    public boolean exists(Integer id) {
        return cats.stream().anyMatch(c -> c.getId() == id);
    }

    @Override
    public int count() {
        return cats.size();
    }

    @Override
    public List<Cat> getAll() {
        return cats;
    }

    @Override
    public Integer getNextId() {
        return cats.stream().map(Cat::getId).max(Integer::compareTo).orElse(0)+1;
    }
}
