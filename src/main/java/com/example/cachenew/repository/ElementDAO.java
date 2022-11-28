package com.example.cachenew.repository;

import com.example.cachenew.entity.Element;

public interface ElementDAO {
    Element saveElement(Element element);

    Element getElement(int id);
}