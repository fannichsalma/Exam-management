package com.ensah.core.services.impl;

import com.ensah.core.bo.TypeElement;

import com.ensah.core.dao.TypeElementRepository;
import com.ensah.core.services.TypeElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeElementServiceImpl implements TypeElementService {
    @Autowired
    private TypeElementRepository typeElementRepository;

    @Override
    public List<TypeElement> getAllTypesElements() {
        return typeElementRepository.findAll();
    }

    @Override
    public TypeElement getTypeElementById(Long id) {
        return typeElementRepository.findById(id).orElse(null);
    }
}
