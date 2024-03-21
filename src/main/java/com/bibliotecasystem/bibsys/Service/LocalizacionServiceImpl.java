package com.bibliotecasystem.bibsys.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotecasystem.bibsys.Model.entities.Localizacion;
import com.bibliotecasystem.bibsys.Repositories.LocalizacionRepository;

@Service
public class LocalizacionServiceImpl implements LocalizacionService {

     @Autowired
    private LocalizacionRepository localizacionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Localizacion> findAll() {
        return (List<Localizacion>) localizacionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Localizacion> findById(Long id) {
        return localizacionRepository.findById(id);
    }

    @Override
    @Transactional
    public Localizacion save(Localizacion localizacion) {
        return localizacionRepository.save(localizacion);
    }

    @Override
    @Transactional
    public Optional<Localizacion> update(Localizacion localizacion, Long id) {

        Optional<Localizacion> existingLocalizacion = localizacionRepository.findById(id);

        if (existingLocalizacion.isPresent()) {

            Localizacion updatedLocalizacion = existingLocalizacion.get();
            updatedLocalizacion.setPosicion(localizacion.getPosicion());
            updatedLocalizacion.setCoordenada(localizacion.getCoordenada());
            updatedLocalizacion.setAula(localizacion.getAula());
            updatedLocalizacion.setLibrero(localizacion.getLibrero());
            return Optional.of(localizacionRepository.save(updatedLocalizacion));
        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public void remove(Long id) {
        localizacionRepository.deleteById(id);
    }

}
