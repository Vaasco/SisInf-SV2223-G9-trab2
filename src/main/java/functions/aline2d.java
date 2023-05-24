package functions;

import jakarta.persistence.*;
import model.Jogadores;
import model.Regiao;

public class aline2d {

    public static void main(String[] args) {
        String email = "tiago@sapo.pt";
        String name = "Thiago";


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEx");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Jogadores jogador = new Jogadores();
            jogador.setId(1007);
            jogador.setEmail(email);
            jogador.setUsername(name);
            jogador.setEstadoPlayer("Ativo");


            em.persist(jogador);

            em.getTransaction().commit();
            System.out.println("Jogador criado");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }


}
