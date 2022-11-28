package com.example.cachenew.service;

import com.example.cachenew.entity.Element;
import com.example.cachenew.repository.ElementDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ElementServiceImp implements ElementService {

    private final ElementDAO elementDAO;

    @Override
    @Transactional
    public Element saveElement(Element element) {
        return elementDAO.saveElement(element);
    }

    @Override
    @Transactional
    public Element getElement(int id) {
        return elementDAO.getElement(id);
    }

}