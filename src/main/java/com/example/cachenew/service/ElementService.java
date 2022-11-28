package com.example.cachenew.service;

import com.example.cachenew.entity.Element;

public interface ElementService {
    Element saveElement(Element element);

    Element getElement (int id);
}
