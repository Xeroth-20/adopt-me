package dev.jx.app.service;

import java.util.Collection;

import dev.jx.app.entity.Image;

public interface ImageService {

    Collection<Image> findAll();

    Collection<Image> findAllByPetIsNull();

    Collection<Image> findAllByPetIsNullOrPet_Id(Integer id);;

    Image findById(Integer id);

    void insert(Image image);

    void update(Image image);

    void deleteById(Integer id);
}
