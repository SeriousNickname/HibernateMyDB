package org.example.hibernarte_crud;

import jakarta.persistence.*;
import org.example.entity.Stuff;


public class HibernateDelete {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager entityManager = factory.createEntityManager();

        /**
         * Создаю и открываю транзакцию. Через .find нахожу работника, через entityManager.remove удаляю его и закрываю транзакцию.
         * */

        EntityTransaction transaction = entityManager.getTransaction();
        Stuff employee = null;

        try{
            transaction.begin();
            employee = entityManager.find(Stuff.class, 8); // нахожу работника в БД
            entityManager.remove(employee); // удаляю работника

            transaction.commit();
        }
        catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(entityManager != null){
                entityManager.close();
                factory.close();
            }
        }

    }
}
