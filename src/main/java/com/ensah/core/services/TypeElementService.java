package com.ensah.core.services;

import com.ensah.core.bo.TypeElement;
import java.util.List;

public interface TypeElementService {
    List<TypeElement> getAllTypesElements();
    TypeElement getTypeElementById(Long id);
}
