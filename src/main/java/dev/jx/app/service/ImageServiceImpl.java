package dev.jx.app.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import dev.jx.app.entity.Image;
import dev.jx.app.repository.ImageRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Image> findAll() {
        return this.imageRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Image> findAllByPetIsNull() {
        return this.imageRepository.findAllByPetIsNull();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Image> findAllByPetIsNullOrPet_Id(Integer id) {
        return this.imageRepository.findAllByPetIsNullOrPet_Id(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Image findById(Integer id) {
        return this.imageRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insert(Image image) {
        this.imageRepository.save(image);
    }

    @Override
    @Transactional
    public void update(Image image) {
        this.imageRepository.save(image);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        this.imageRepository.deleteById(id);
    }
}
