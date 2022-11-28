package com.example.cachenew.repository;


import com.example.cachenew.entity.Element;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ElementRepositoryTest {
    @MockBean
    EntityManager entityManager;
    @Autowired
    ElementDAO elementDAO;

    @AfterEach
    public void deleteAllElement() {
        Query query = entityManager.createQuery("delete from Element ");
        int i = query.executeUpdate();
    }

    @Test
    public void whenSaveElementTest() {
        Element element = new Element(1,"value",1);
        Mockito.when(entityManager.merge(element)).thenReturn(element);
        Element element1 = elementDAO.saveElement(element);
        assertEquals(element, element1);
    }

    @Test
    public void whenGetElementTest() {
        Element element = new Element(1,"value",1);
        Mockito.when(entityManager.find(Element.class, 1)).thenReturn(element);
        Element element1 = elementDAO.getElement(1);
        assertEquals(element, element1);
    }

}
