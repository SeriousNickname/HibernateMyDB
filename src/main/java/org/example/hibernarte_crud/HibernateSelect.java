package org.example.hibernarte_crud;

import jakarta.persistence.*;
import org.example.entity.Stuff;


public class HibernateSelect {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager entityManager = factory.createEntityManager();

        Stuff employee = null;

        try{
            employee = entityManager.find(Stuff.class, 3); // нахожу работника в БД

        } catch (Exception e){
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
