package org.example.hibernarte_crud;

import jakarta.persistence.*;
import org.example.entity.Stuff;
import org.example.entity.Stuff_info;

public class HibernateInsert {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager entityManager = factory.createEntityManager();

        /**
         * Создаю и открываю транзакцию. Создаю работника, через .persist вношу работника в БД, закрываю транзакцию.
         * */

        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            Stuff employee = new Stuff("Grisha", 2L); //создаю нового сотрудника
            Stuff_info info = new Stuff_info("Grisha@mail.ru", "+7 987 237657623675");
            entityManager.persist(employee);
            entityManager.persist(info);

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
    }
}
