package org.example.hibernarte_crud;

import jakarta.persistence.*;
import org.example.entity.Stuff;

public class HibernateUpdate {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager entityManager = factory.createEntityManager();

        /**
         * Создаю и открываю транзакцию. Через .find нахожу работника, меняю ему параметры и закрываю транзакцию.
         * */

        EntityTransaction transaction = entityManager.getTransaction();
        Stuff employee = null;

        try{
            transaction.begin();
            employee = entityManager.find(Stuff.class, 1); // нахожу работника в БД
            employee.setOfficeID(4L); // меняю работнику параметр

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
        System.out.println("Employee's id: " + employee.getId() + ", Name: " + employee.getName() + ", officeID: " + employee.getOfficeID());
    }
}
