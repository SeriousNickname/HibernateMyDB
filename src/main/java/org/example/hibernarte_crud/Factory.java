package org.example.hibernarte_crud;

import jakarta.persistence.*;
import org.example.entity.Stuff;


public class Factory {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager entityManager = factory.createEntityManager();

        /**
         * Создаю и открываю транзакцию.
         * */
        EntityTransaction transaction = entityManager.getTransaction();
        Stuff employee = null;

        try{
            System.out.println("try1");
            transaction.begin();
            System.out.println("try2");
            employee = new Stuff("Olya", 2); //создаю нового сотрудника
            System.out.println("try3");
            entityManager.persist(employee); // сохраняю нового сотрудника в БД -- ОШИБКА
            System.out.println("try4");
            transaction.commit();
            System.out.println("try5");
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback(); // откатываем транзакцию, если она не закрылась
            }
            e.printStackTrace();
            System.out.println("catch");
        }finally {
            if(entityManager!=null){
                entityManager.close();
                factory.close();
            }
            System.out.println("finalyy");
        }
        System.out.println(employee);

    }
}
