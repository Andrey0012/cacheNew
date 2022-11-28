package com.example.cachenew.sevice;

import com.example.cachenew.entity.Element;
import com.example.cachenew.repository.ElementDAO;
import com.example.cachenew.service.ElementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ElementServiceTest {

    @Autowired
    private ElementService elementService;
    @MockBean
    ElementDAO elementDAO;

    @Test
    public void saveElementTest() {
        Element element = Element.builder().id(1).value("value").version(1).build();
        Mockito.when(elementDAO.saveElement(element)).thenReturn(element);
        Element newElement = elementService.saveElement(element);
        assertEquals(element, newElement);
    }

    @Test
    public void getElementTest() {
        Element element = Element.builder().id(1).value("value").version(1).build();
        Mockito.when(elementDAO.getElement(1)).thenReturn(element);
        Element element1 = elementService.getElement(1);
        assertEquals(element, element1);
    }
}
