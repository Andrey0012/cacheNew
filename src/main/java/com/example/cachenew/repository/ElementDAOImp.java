package com.example.cachenew.repository;

import com.example.cachenew.entity.Element;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class ElementDAOImp implements ElementDAO {

    private final EntityManager entityManager;

    @Override
    public Element saveElement(Element element) {
        if (element.getId() == null) {
            return entityManager.merge(element);
        }
        Element foundedElement = getElement(element.getId());
        return foundedElement == null ||
                foundedElement.getVersion() < element.getVersion() ? entityManager.merge(element) : foundedElement;
    }

    @Override
    public Element getElement(int id) {
        return entityManager.find(Element.class, id);
    }
}