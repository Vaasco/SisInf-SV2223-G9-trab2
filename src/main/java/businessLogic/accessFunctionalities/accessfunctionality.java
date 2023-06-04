package businessLogic.accessFunctionalities;

import businessLogic.DataScopes.DataScope;
import data_access.Mappers;
import data_access.UnitOfWork;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class accessfunctionality {
    //Alínea 2d

    //criar jogador
    public static void criar_jogador(String email, String username, String nome_regiao) {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            Query query = em.createNativeQuery("CALL criar_jogador(?, ?, ?)");
            query.setParameter(1, email);
            query.setParameter(2, username);
            query.setParameter(3, nome_regiao);
            query.executeUpdate();
            ds.validateWork();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //desativar jogador
    public static void desativar_jogador(Integer id_player) {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            Query query = em.createNativeQuery("CALL desativar_jogador(?)");
            query.setParameter(1, id_player);
            query.executeUpdate();
            ds.validateWork();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //transaction.rollback();
        }
    }

    //banir jogador
    public static void banir_jogador(Integer id_player) {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            Query query = em.createNativeQuery("CALL banir_jogador(?)");
            query.setParameter(1, id_player);
            query.executeUpdate();
            ds.validateWork();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //transaction.rollback();
        }
    }

    //Alínea 2e
    public static Integer total_pontos_jogador(Integer id_player) throws Exception {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            Query query = em.createNativeQuery("SELECT totalpontosjogador(?)");
            query.setParameter(1, id_player);
            Integer totalPoints = (Integer) query.getSingleResult();
            ds.validateWork();
            String message = "Total de pontos: " + totalPoints;
            System.out.println(message);
            return totalPoints;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //transaction.rollback();
            throw e;
        }
    }

    //Alínea 2f
    public static Integer total_jogos_jogador(Integer id_player) throws Exception {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            Query query = em.createNativeQuery("SELECT totaljogosjogador(?)");
            query.setParameter(1, id_player);
            Integer totalJogos = (Integer) query.getSingleResult();
            ds.validateWork();
            String message = "Total de jogos: " + totalJogos;
            System.out.println(message);
            return totalJogos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //transaction.rollback();
            throw e;
        }
    }

    //todo COLOCAR ESTA FUNÇÃO A DAR PRINT!
    //Alínea 2g
    public static List<Object[]> pontos_jogo_por_jogador(String id_game) {
        List<Object[]> resultTable = new ArrayList<>();
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            String SQLQuery = "SELECT pontosjogoporjogador(?)";
            Query query = em.createNativeQuery(SQLQuery);
            query.setParameter(1, id_game);
            List resultList = query.getResultList();
            resultTable.addAll(resultList);
            for (Object[] row : resultTable) {
                //System.out.println(row);
                int playerId = (int) row[0];
                String gameId = (String) row[1];
                System.out.printf("%4s , %10s", playerId, gameId);
            }
            ds.validateWork();
        } catch (Exception e) {
            //_em.getTransaction().rollback();
            e.printStackTrace();
        }
        return resultTable;
    }


    //Alínea 2h
    public static void associar_cracha(Integer id_jogador, String id_game, String cracha_nome) {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            Query query = em.createNativeQuery("CALL associarcracha(?,?,?)");
            query.setParameter(1, id_jogador);
            query.setParameter(2, id_game);
            query.setParameter(3, cracha_nome);
            query.executeUpdate();
            ds.validateWork();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //transaction.rollback();
        }
    }

    //Alínea 2i
    public static Integer iniciar_conversa(Integer id_jogador, String nome_chat) throws Exception {

        Integer ret;
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();

            Connection cn = em.unwrap(Connection.class);
            try (CallableStatement f = cn.prepareCall("CALL iniciarconversa(?,?,?)")) {
                f.registerOutParameter(3, Types.INTEGER);
                f.setInt(1, id_jogador);
                f.setString(2, nome_chat);
                f.execute();
                ret = f.getInt(3);

            }
            ds.validateWork();
            return ret;
        }
    }
    //Alínea 2j

    public static void juntar_conversa(Integer id_jogador, Integer id_conv) {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            Query query = em.createNativeQuery("CALL juntarconversa(?,?)");
            query.setParameter(1, id_jogador);
            query.setParameter(2, id_conv);
            query.executeUpdate();
            ds.validateWork();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //transaction.rollback();
        }

    }

    //Alínea 2k

    public static void enviar_mensagem(Integer id_jogador, Integer id_conv, String msg) throws Exception {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            String SQLQuery = "CALL enviarmensagem(?,?,?)";
            Query query = em.createNativeQuery(SQLQuery);
            query.setParameter(1, id_jogador);
            query.setParameter(2, id_conv);
            query.setParameter(3, msg);
            query.executeUpdate();
            ds.validateWork();
        } catch (Exception e) {
            //_em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    //Alínea 2l
    public static List<Object[]> jogador_total_info() throws Exception {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            String SQLQuery = "select * from jogadorTotalInfo;";
            Query q = em.createNativeQuery(SQLQuery);
            ds.validateWork();
            return q.getResultList();
        }
    }

    //todo resolver este problema!
    // 1b) 2h (sem aceder a procedimentos e functions)
    public static void associar_cracha_np(Integer id_jogador, String id_game, String cracha_nome) throws Exception {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            Integer totalPontos;
            UnitOfWork unitOfWork = new UnitOfWork();
            Mappers mappers = new Mappers(unitOfWork);
            //Verificar os parâmetros
            if (id_jogador.toString().length() != 4) throw new IllegalArgumentException("Invalid Id jogador!");
            if (id_game.length() != 10) throw new IllegalArgumentException("Invalid Id jogo!");
            if (cracha_nome.length() > 40) throw new IllegalArgumentException("Invalid nome cracha!");
            String sql = "Select n FROM Normal n WHERE n.idPlayer = ?1 AND n.jogoNormal.idGame = ?2";
            TypedQuery<Normal> query = em.createQuery(sql, Normal.class);
            query.setParameter(1, id_jogador);
            query.setParameter(2, id_game);
            Normal resultados = query.getSingleResult();
            System.out.println(resultados);
            ds.validateWork();

        }

    }

    /**
     * 1c) 2h (reutilizando os procedimentos armazenados e funções que a funcionalidade original usa)
     * <p>
     * A funcionalidade original não utiliza procedimentos armazenados, logo torna-se impossível
     * realizar esta alínea, pois não iríamos reutilizar nada.
     */

    //Alínea 2a)
    public static void optimistCrachaUpdate(String nomeCracha, String idGame) throws Exception {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            //Verificação de parâmetros
            if (nomeCracha.length() > 10) throw new IllegalArgumentException("Invalid nome cracha!");
            if (idGame.length() > 10) throw new IllegalArgumentException("Invalid id do game");
            String sql = "Select c from Crachas c where c.id.nomeCracha = ?1 and c.id.idGame = ?2";
            TypedQuery<Crachas> query = em.createQuery(sql, Crachas.class);
            query.setParameter(1,nomeCracha);
            query.setParameter(2,idGame);
            Crachas resultado = query.getSingleResult();
            System.out.println(resultado);
            Integer novosPontos = (int) (resultado.getLimitePontos() * 1.2);
            resultado.setLimitePontos(novosPontos);
            System.out.println(resultado);
            ds.validateWork();
        }
    }


    public static void main(String[] args) throws Exception {

        Integer idJogador = 1016;
        System.out.println(jogador_total_info());
    }
}
