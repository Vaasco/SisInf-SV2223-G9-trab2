package businessLogic.accessFunctionalities;

import businessLogic.DataScopes.DataScope;
import jakarta.persistence.*;
import model.Crachas;
import model.CrachasId;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;


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
        }
    }

    //Alínea 2e
    public static Integer total_pontos_jogador(Integer id_player) {
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
            throw e;
        }
    }

    //Alínea 2f
    public static Integer total_jogos_jogador(Integer id_player) {
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
            throw e;
        }
    }

    //Alínea 2g
    public static List<PGobject> pontos_jogo_por_jogador(String id_game) {
        //List<Object[]> resultTable = new ArrayList<>();
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            String SQLQuery = "SELECT pontosjogoporjogador(?)";
            Query query = em.createNativeQuery(SQLQuery);
            query.setParameter(1, id_game);
            List<PGobject> resultList = query.getResultList();
            ds.validateWork();
            /*
            for (PGobject row : resultList) {
                String value = row.getValue();
                String[] columns =
                        value != null ? value.substring(1, value.length() - 1).split(",") : new String[0];
                int playerId = Integer.parseInt(columns[0].trim());
                long totalPoints = Long.parseLong(columns[1].trim());
                System.out.println("\n" + playerId + "  " + totalPoints + "\n");
            }
            */
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
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
        }
    }

    //Alínea 2i
    public static Integer iniciar_conversa(Integer id_jogador, String nome_chat) throws SQLException {
        int ret;
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            Connection cn = em.unwrap(Connection.class);

            try (CallableStatement f = cn.prepareCall("CALL iniciarconversa(?,?,?)")) {
                f.setInt(1, id_jogador);
                f.setString(2, nome_chat);
                f.registerOutParameter(3, Types.INTEGER);
                f.execute();
                ret = f.getInt(3);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }

            ds.validateWork();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        return ret;
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
        }
    }

    //Alínea 2k
    public static void enviar_mensagem(Integer id_jogador, Integer id_conv, String msg) {
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
            e.printStackTrace();
        }
    }

    //Alínea 2l
    public static List<Object[]> jogador_total_info() {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            String SQLQuery = "select * from jogadorTotalInfo;";
            Query q = em.createNativeQuery(SQLQuery);
            List<Object[]> resultTable = q.getResultList();
            /*
            System.out.println();
            for (Object[] row : resultTable) {
                int playerId = (int) row[0];
                String estado = (String) row[1];
                String email = (String) row[2];
                String username = (String) row[3];
                int totaljogos = (int) row[4];
                long totalpartidas = (long) row[5];
                int totalpontos = (int) row[6];
                System.out.printf(
                        "[PlayerID: %4s, Estado: %5s, Email: %5s, Username: %5s, " +
                                "TotalJogos: %2s, TotalPartidas: %2s, TotalPontos: %1s]\n",
                        playerId, estado, email, username, totaljogos, totalpartidas, totalpontos
                );
            }
            System.out.println();
            */
            ds.validateWork();
            return resultTable;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    // 1b) 2h (sem usar qualquer PA nem qualquer função pgSql)
    public static void associar_cracha_np(Integer id_jogador, String id_game, String cracha_nome) {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();

            TypedQuery<Integer> query1 = em.createQuery(
                    "SELECT CAST(SUM(n.pontuacaoN) AS INTEGER) " +
                            "FROM Normal n " +
                            "WHERE n.idPlayer = ?1 AND n.id.idGame = ?2",
                    Integer.class);
            query1.setParameter(1, id_jogador);
            query1.setParameter(2, id_game);
            Integer pontuacaoN = query1.getSingleResult();

            TypedQuery<Integer> query2 = em.createQuery(
                    "SELECT CAST(SUM(mj.pontuacaoMj) AS INTEGER) " +
                            "FROM JogaMj mj " +
                            "WHERE mj.id.idPlayer = ?1 AND mj.id.idGame = ?2",
                    Integer.class);
            query2.setParameter(1, id_jogador);
            query2.setParameter(2, id_game);
            Integer pontuacaoMj = query2.getSingleResult();

            TypedQuery<Integer> query3 = em.createQuery(
                    "SELECT c.limitePontos " +
                            "FROM Crachas c " +
                            "WHERE c.id.idGame = ?1 AND c.id.nomeCracha = ?2",
                    Integer.class);
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


    // 1c) 2h (reutilizando os PA e funções que a funcionalidade pgSql original usa)
    public static void associar_cracha_reusing_procedures(Integer idJogador, String idGame, String nomeCracha) {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();

            Query query1 = em.createNativeQuery(
                    "select pontos " +
                            "from PontosJogoPorJogador(?1) " +
                            "where id_jogador = ?2"
            );
            query1.setParameter(1, idGame);
            query1.setParameter(2, idJogador);
            Object aux1 = query1.getSingleResult();
            long pontosJogo = aux1 != null ? ((Number) aux1).longValue() : 0L;

            Query query2 = em.createNativeQuery(
                    "select j.nome_regiao from jogadores j where j.id_player = ?1"
            );
            query2.setParameter(1, idJogador);
            Object aux2 = query2.getSingleResult();
            if (aux2 == null) throw new IllegalStateException("Invalid 'regiao'.");
            String regiao = aux2.toString();

            Query query3 = em.createNativeQuery(
                    "select c.limite_pontos from crachas c where c.id_game = ?1 and c.nome_cracha = ?2"
            );
            query3.setParameter(1, idGame);
            query3.setParameter(2, nomeCracha);
            Object aux3 = query3.getSingleResult();
            if (aux3 == null) aux3 = 0;
            Integer limitePontos = (Integer) aux3;

            if (pontosJogo >= limitePontos) {
                //System.out.println("\n\n" + pontosJogo + "  " + regiao + "  " + limitePontos + "\n\n");
                Query queryInsert = em.createNativeQuery(
                        "insert into tem (id_player, nome_cracha, id_game, nome_regiao) " +
                                "select ?1, ?2, ?3, ?4 " +
                                "where not exists(" +
                                "select 1 from tem " +
                                "where id_player = ?5 and nome_cracha = ?6 and id_game = ?7" +
                                ")"
                );
                queryInsert.setParameter(1, idJogador);
                queryInsert.setParameter(2, nomeCracha);
                queryInsert.setParameter(3, idGame);
                queryInsert.setParameter(4, regiao);
                queryInsert.setParameter(5, idJogador);
                queryInsert.setParameter(6, nomeCracha);
                queryInsert.setParameter(7, idGame);
                queryInsert.executeUpdate();
            }
            ds.validateWork();
        }
    }


    //Alínea 2a)
    public static void optimistCrachaUpdate(String nomeCracha, String idGame) {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();
            //Verificação de parâmetros
            if (nomeCracha.length() > 10) throw new IllegalArgumentException("Invalid nome cracha!");
            if (idGame.length() > 10) throw new IllegalArgumentException("Invalid id do game");

            Crachas resultado = em.find(Crachas.class, new CrachasId(idGame, nomeCracha));
            System.out.println("\n" + resultado + "\n");

            Integer novosPontos = (int) (resultado.getLimitePontos() * 1.2);
            resultado.setLimitePontos(novosPontos);

            try {
                ds.validateWork();
            } catch (OptimisticLockException ex) {
                System.err.println("Conflito detetado. A atualização não pode ser concluída.");
                return;
            }

            System.out.println("\n" + resultado + "\n");
        }
    }


    //Alínea 2b)
    public static void test2a() throws Exception {
        //Executa duas threads simultaneamente
        String idGame = "0123456789";
        String cracha = "Test Drive";

        Thread thread1 = new Thread(() -> {
            try {
                optimistCrachaUpdate(cracha, idGame);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                optimistCrachaUpdate(cracha, idGame);
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
    public static void pessimistCrachaUpdate(String nomeCracha, String idGame) {
        try (DataScope ds = new DataScope()) {
            EntityManager em = ds.getEntityManager();

            if (nomeCracha.length() > 10) throw new IllegalArgumentException("Invalid nome cracha!");
            if (idGame.length() > 10) throw new IllegalArgumentException("Invalid id do game");

            Crachas resultado =
                    em.find(Crachas.class, new CrachasId(idGame, nomeCracha), LockModeType.PESSIMISTIC_WRITE);
            System.out.println("\n" + resultado + "\n");

            Integer novosPontos = (int) (resultado.getLimitePontos() * 1.2);
            resultado.setLimitePontos(novosPontos);

            try {
                ds.validateWork();
            } catch (PessimisticLockException ex) {
                System.err.println("Conflito detetado. A atualização não pode ser concluída.");
            } finally {
                ds.validateWork();
                System.out.println("\n" + resultado + "\n");
            }
        }
    }


    public static void main(String[] args) throws Exception {
        /*Fase 1) d*/ /*
        criar_jogador("testMain@hotmail.com", "Test Main", "Africa");
        //desativar_jogador(1000);
        //banir_jogador(1000);
        */
        /*Fase 1) e*/ /*
        Integer totalPontosJogador = total_pontos_jogador(1001);
        System.out.println("\n" + totalPontosJogador + "\n");
        */
        /*Fase 1) f*/ /*
        Integer totalJogosJogador = total_jogos_jogador(1001);
        System.out.println("\n" + totalJogosJogador + "\n");
        */
        /*Fase 1) g*/ /*
        List<PGobject> pontosJogoPorJogadorList = pontos_jogo_por_jogador("22222bbbbb");
        System.out.println("\n" + pontosJogoPorJogadorList + "\n");
        */
        /*Fase 1) h*/ /*
        associar_cracha(1000, "0123456789", "Test Drive");
        //associar_cracha_np(1000, "0123456789", "Test Drive");
        //associar_cracha_reusing_procedures(1000, "0123456789", "Test Drive");
        */
        /*Fase 1) i*/ /*
        Integer idNovaConversa = iniciar_conversa(1000, "Test Main");
        System.out.println("\n" + idNovaConversa + "\n");
        */
        /*Fase 1) j*/ /*
        juntar_conversa(1001, 100000);
        */
        /*Fase 1) k*/ /*
        enviar_mensagem(1000, 100000, "Test Main");
        */
        /*Fase 1) l*/ /*
        List<Object[]> jogadorTotalInfoList = jogador_total_info();
        System.out.println();
        for (Object[] jogadorInfo : jogadorTotalInfoList) {
            System.out.format("%-6s %-8s %-25s %-15s %-2s %-2s %-10s%n", jogadorInfo);
        }
        */

        /*2a) e 2b)*/ /*
        //optimistCrachaUpdate("Test Drive", "0123456789");
        test2a();
        */
        /*2c*/        /*
        pessimistCrachaUpdate("Test Drive", "0123456789");
        */
    }
}
