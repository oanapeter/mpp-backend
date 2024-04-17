package net.javaguides.mpp.tests;

import net.javaguides.mpp.entity.Cat;
import net.javaguides.mpp.repository.Repository;

import java.util.Objects;

public class RepoTest {
    private static Repository repo;

    public static void allTests(){
        getByIdTest();
        addTest();
        updateTest();
        deleteTest();
        existsTest();
        countTest();
        getAllTest();
        System.out.println("Repo tests passed.");
    }

    private static void getByIdTest(){
        repo = new Repository();
        Cat cat = repo.getById(1);
        assert Objects.equals(cat.getName(), "Mittens");

    }

    private static void addTest(){
        repo = new Repository();
        repo.add(new Cat(20, "Mini", "Teen mom", "white", 1));
        assert repo.exists(20);
    }
    private static void updateTest(){
        repo = new Repository();
        repo.update(4, new Cat(4, "oana", "oana", "oana", 5));
        Cat cat = repo.getById(4);
        assert Objects.equals(cat.getName(), "oana");
        assert Objects.equals(cat.getDescription(), "oana");
    }
    private static void deleteTest(){
        repo = new Repository();
        repo.delete(2);;
        assert !repo.exists(2);
    }
    private static void existsTest(){
        repo = new Repository();
        assert repo.exists(2);
    }

    private static void countTest(){
        repo = new Repository();
        assert repo.count() == 11;
    }

    private static void getAllTest(){
        repo = new Repository();
        assert repo.getAll().size() == 11;
    }


}
