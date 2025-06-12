package org.example.hibernarte_crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.Stuff;
import org.example.entity.Stuff_info;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

/** Тестирование по системе ААА класса HibernateInsert с помощью Mokito */

@ExtendWith(MockitoExtension.class)
class HibernateInsertTest {

    @Mock
    private EntityManager entityManager;
    @Mock
    private EntityTransaction transaction;

    @InjectMocks
    private HibernateInsert hibernateInsert;

    @Test
    void testSuccessfulTransaction() {
        // Arrange
        when(entityManager.getTransaction()).thenReturn(transaction);

        // Act
        hibernateInsert.insertToDB(entityManager);

        // Assert
        verify(transaction).begin();
        verify(entityManager).persist(any(Stuff.class));
        verify(entityManager).persist(any(Stuff_info.class));
        verify(transaction).commit();
    }

    @Test
    void testRollback(){

        // Arrange
        when(entityManager.getTransaction()).thenReturn(transaction);
        when(transaction.isActive()).thenReturn(true);

        // Act
        doThrow(new RuntimeException("Simulated exception")).when(entityManager).persist(any());

        try {
            hibernateInsert.insertToDB(entityManager);
        } catch (Exception e) {
            e.printStackTrace();// ловим исключение
        }

        // Assert
        verify(transaction).rollback();
    }
}