package businessLogic.accessFunctionalities;

import businessLogic.DataScopes.DataScope;
import data_access.Mappers;
import data_access.UnitOfWork;
import jakarta.persistence.*;
import model.Crachas;
import model.CrachasId;
import model.Jogadores;
import org.eclipse.persistence.exceptions.i18n.ExceptionMessageGenerator;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;


public class accessFunctionality {

    //Alínea 2d
    //2d -- criar jogador
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

    //2d -- desativar jogador
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

    //2d -- banir jogador
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
        try (DataScope ds = new  DataScope()) {
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
            List<Object[]> resultTable = new ArrayList<>();
            String SQLQuery = "select * from jogadorTotalInfo;";
            Query q = em.createNativeQuery(SQLQuery);
            resultTable.addAll(q.getResultList());
            System.out.println();
            for ( Object[] row : resultTable ){
                int playerId = (int) row[0];
                String estado = (String) row[1];
                String email = (String) row[2];
                String username = (String) row[3];
                int totaljogos = (int) row[4];
                long totalpartidas = (long) row[5];
                int totalpontos = (int) row[6];

                System.out.printf("[PlayerID: %4s, Estado: %5s, Email: %5s, Username: %5s, TotalJogos: %2s, TotalPartidas: %2s, TotalPontos: %1s]\n", playerId, estado, email, username, totaljogos,totalpartidas,totalpontos);
            }
            System.out.println();
            ds.validateWork();
            return q.getResultList();
        }
    }

    // 1b) 2h (sem aceder a procedimentos e functions)
    public static void associar_cracha_np(Integer id_jogador, String id_game, String cracha_nome) throws Exception {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();

            TypedQuery<Integer> query1 = em.createQuery(
                    "SELECT CAST(SUM(n.pontuacaoN) AS INTEGER) " +
                            "FROM Normal n " +
                            "WHERE n.idPlayer = ?1 AND n.id.idGame = ?2", Integer.class);
            query1.setParameter(1, id_jogador);
            query1.setParameter(2, id_game);
            Integer pontuacaoN = query1.getSingleResult();

            TypedQuery<Integer> query2 = em.createQuery(
                    "SELECT CAST(SUM(mj.pontuacaoMj) AS INTEGER) " +
                            "FROM JogaMj mj " +
                            "WHERE mj.id.idPlayer = ?1 AND mj.id.idGame = ?2", Integer.class);
            query2.setParameter(1, id_jogador);
            query2.setParameter(2, id_game);
            Integer pontuacaoMj = query2.getSingleResult();

            TypedQuery<Integer> query3 = em.createQuery(
                    "SELECT c.limitePontos " +
                            "FROM Crachas c " +
                            "WHERE c.id.idGame = ?1 AND c.id.nomeCracha = ?2", Integer.class);
            query3.setParameter(1, id_game);
            query3.setParameter(2, cracha_nome);
            Integer limitePontos = query3.getSingleResult();
            int totalPontos = (pontuacaoN != null ? pontuacaoN : 0) + (pontuacaoMj != null ? pontuacaoMj : 0);

            if (totalPontos >= limitePontos) {
                Query insertQuery = em.createNativeQuery(
                        "INSERT INTO tem (id_player, nome_cracha, id_game, nome_regiao) " +
                                "SELECT ?1, ?2, ?3, (SELECT nome_regiao FROM Jogadores j WHERE j.id_player = ?1) " +
                                "WHERE NOT EXISTS " +
                                "(SELECT 1 FROM tem WHERE id_player = ?1 AND nome_cracha = ?2 AND id_game = ?3)"
                );
                insertQuery.setParameter(1, id_jogador);
                insertQuery.setParameter(2, cracha_nome);
                insertQuery.setParameter(3, id_game);
                insertQuery.executeUpdate();
            }

            ds.validateWork();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Alínea 1c) 2h (reutilizando os procedimentos armazenados e funções que a funcionalidade original usa)
     * <p>
     * A funcionalidade original não utiliza procedimentos armazenados, logo torna-se impossível
     * realizar esta alínea, pois não iríamos reutilizar nada.
     */

    public static void associar_cracha_with_procedures(String idGame, String nomeCracha) throws Exception{
        try (DataScope ds = new DataScope()){
            EntityManager em = ds.getEntityManager();
            List<Object[]> resultTable = new ArrayList<>();
            String SQLQuery = "select * from pontosjogoporjogador(?);";
            Query q = em.createNativeQuery(SQLQuery);
            q.setParameter(1,idGame);
            resultTable.addAll(q.getResultList());
            for (Object[] row : resultTable){
                int idPlayer =(int) row[0];
                associar_cracha(idPlayer,idGame,nomeCracha);
            }
        }
    }


    //Alínea 2a)
    public static void optimistCrachaUpdate(String nomeCracha, String idGame) throws Exception {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            //Verificação de parâmetros
            if (nomeCracha.length() > 10) throw new IllegalArgumentException("Invalid nome cracha!");
            if (idGame.length() > 10) throw new IllegalArgumentException("Invalid id do game");


            Crachas resultado = em.find(Crachas.class, new CrachasId(idGame, nomeCracha));

            System.out.println(resultado);

            Integer novosPontos = (int) (resultado.getLimitePontos() * 1.2);
            resultado.setLimitePontos(novosPontos);
            try {
                ds.validateWork();
            } catch (OptimisticLockException ex) {
                System.err.println("Conflito detetado. A atualização não pode ser concluída.");
                return;
            }
            System.out.println(resultado);
        }
    }
    //Alínea 2b)
    public static void test2a() throws Exception{
        // Executa duas threads simultaneamente
        String idGame = "0123456789";
        String cracha = "Test Drive";

        Thread thread1 = new Thread(() -> {
            try {
                optimistCrachaUpdate(cracha,idGame);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                optimistCrachaUpdate(cracha,idGame);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Inicia as threads
        thread1.start();
        thread2.start();

        // Aguarda o término das threads
        thread1.join();
        thread2.join();
    }
    //Alínea 2c)
    public static void pessimistCrachaUpdate(String nomeCracha, String idGame) throws Exception {
        try(DataScope ds = new DataScope()){
            EntityManager em = ds.getEntityManager();


            if (nomeCracha.length() > 10) throw new IllegalArgumentException("Invalid nome cracha!");
            if (idGame.length() > 10) throw new IllegalArgumentException("Invalid id do game");

            Crachas resultado = em.find(Crachas.class, new CrachasId(idGame, nomeCracha), LockModeType.PESSIMISTIC_WRITE);


            Integer novosPontos = (int) (resultado.getLimitePontos() * 1.2);
            resultado.setLimitePontos(novosPontos);


            try{
                ds.validateWork();
            }catch (PessimisticLockException ex) {
                System.err.println("Conflito detetado. A atualização nao pode ser concluída.");
            } finally {
                ds.close();
                System.out.println(resultado);
            }
        }
    }

   public static void main(String[] args) throws Exception{
      jogador_total_info();
    }
}
