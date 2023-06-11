package data_access;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.*;

import java.util.List;


public class Test {

    public static void test1() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEx");
        try (emf; EntityManager em = emf.createEntityManager()) {
            //Criar um jogador
            em.getTransaction().begin();
            String sql = "SELECT j FROM Jogadores j";
            Query query = em.createQuery(sql);

            List<Jogadores> playerList = query.getResultList();
            System.out.println();
            for (Jogadores ax : playerList) {
                System.out.println(ax.toString());
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public static void main(String[] args) {
        try {
            test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
