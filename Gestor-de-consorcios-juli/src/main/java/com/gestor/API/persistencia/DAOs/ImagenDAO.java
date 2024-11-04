package com.gestor.API.persistencia.DAOs;

import com.gestor.API.models.Imagen;
import com.gestor.API.persistencia.repositories.ImagenRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ImagenDAO {
    ImagenRepository imagenRepository;

    public ImagenDAO(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    public List<Imagen> findAll(){
        return imagenRepository.findAll();
    }

    public Optional<Imagen> findById(int codigo){
        return imagenRepository.findById(codigo);
    }

    public void save(Imagen imagen){
        imagenRepository.save(imagen);
    }

    public void delete(Imagen imagen){
        imagenRepository.delete(imagen);
    }

    public void deleteById (int id){
        imagenRepository.deleteById(id);
    }

}
