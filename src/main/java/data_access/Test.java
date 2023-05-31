package data_access;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.*;

import java.util.List;

public class Test {
    public static void test1() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEx");
        try (emf; EntityManager em = emf.createEntityManager()) {
            //Criar um aluno
            System.out.println("Ler um tem");
            em.getTransaction().begin();
            String sql = "SELECT j FROM Jogadores j";
            Query query = em.createQuery(sql);
            List<Jogadores > la = query.getResultList();

            for (Jogadores   ax : la) {
                System.out.println(ax.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            test1();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
