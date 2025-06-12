package org.example.hibernarte_crud;

import jakarta.persistence.*;
import org.example.entity.Stuff;
import org.example.entity.Stuff_info;

/**
 * Класс для выполнения операции вставки данных в БД (CREATE).
 * Для работы Mockito пришлось вынести работу с транзакцией в метод insertToDB, который принимает entityManager из main.
 * Так не придётся проверять main, а только этот метод.
 * */

public class HibernateInsert {
    public void insertToDB(EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Stuff employee = new Stuff("Grisha", 2L);
            Stuff_info info = new Stuff_info("Grisha@mail.ru", "+7 987 237657623675");
            entityManager.persist(employee);
            entityManager.persist(info);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Re-throw exception to be caught in main method or handled by caller
        }
    }
    /**
     * main метод, создаю entityManager и передаю его в качестве параметра.
     */

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager entityManager = factory.createEntityManager();
        HibernateInsert hibernateInsert = new HibernateInsert();

        try {
            hibernateInsert.insertToDB(entityManager);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}