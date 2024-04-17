package net.javaguides.mpp.repository;

import net.javaguides.mpp.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IRepository <EntityType, IdType>{
    EntityType getById(IdType id);
    void add(EntityType e);
    EntityType update(IdType id, EntityType e);
    void delete(IdType id);
    boolean exists(IdType id);
    int count();
    List<EntityType> getAll();
    Integer getNextId();
}



