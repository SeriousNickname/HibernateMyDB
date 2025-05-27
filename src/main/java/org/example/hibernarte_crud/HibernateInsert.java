package org.example.hibernarte_crud;

import jakarta.persistence.*;
import org.example.entity.Stuff;


public class HibernateInsert {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager entityManager = factory.createEntityManager();

        /**
         * Создаю и открываю транзакцию. Создаю работника, через .persist вношу работника в БД, закрываю транзакцию.
         * */
        EntityTransaction transaction = entityManager.getTransaction();
        Stuff employee = null;

        try{
            transaction.begin();
            employee = new Stuff("Lena", 4); //создаю нового сотрудника
            entityManager.persist(employee);
            transaction.commit();
        } catch (Exception e){
            if(transaction!=null){
                transaction.rollback(); // откатываем транзакцию, если она не закрылась
            }
            e.printStackTrace();
        }finally {
            if(entityManager!=null){
                entityManager.close();
                factory.close();
            }
        }
        System.out.println(employee);

    }
}
