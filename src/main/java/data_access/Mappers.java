package data_access;

import businessLogic.DataScopes.DataScope;
import data_mappers.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.*;


public class Mappers {

    private final UnitOfWork unitOfWork;

    public Mappers(UnitOfWork context) {
        this.unitOfWork = context;
    }

    protected class ComprarMapper implements IComprarMapper {

        @Override
        public ComprarId Create(Comprar entity) {
            unitOfWork.beginTransaction();
            unitOfWork._em.persist(entity);
            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public Comprar Read(ComprarId id) {
            return unitOfWork._em.find(Comprar.class, id);
        }

        @Override
        public ComprarId Update(Comprar entity) {
            unitOfWork.beginTransaction();

            Comprar comprar =
                    unitOfWork._em.find(Comprar.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (comprar == null) {
                System.out.println("Compra not found");
                return null;
            }
            comprar.setId(entity.getId());
            comprar.setPreco(entity.getPreco());
            comprar.setDataCompra(entity.getDataCompra());

            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public ComprarId Delete(Comprar entity) {
            unitOfWork.beginTransaction();

            Comprar comprar =
                    unitOfWork._em.find(Comprar.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (comprar == null) {
                System.out.println("Compra not found");
                return null;
            }

            unitOfWork._em.remove(entity);
            unitOfWork.commit();
            return comprar.getId();
        }
    }


    protected class ConversaMapper implements IConversaMapper {

        @Override
        public Integer Create(Conversas entity) {
            unitOfWork.beginTransaction();
            unitOfWork._em.persist(entity);
            unitOfWork.commit();
            return entity.getIdConversa();
        }

        @Override
        public Conversas Read(Integer id) {
            return unitOfWork._em.find(Conversas.class, id);
        }

        @Override
        public Integer Update(Conversas entity) {
            unitOfWork.beginTransaction();

            Conversas conversas =
                    unitOfWork._em.find(Conversas.class, entity.getIdConversa(), LockModeType.PESSIMISTIC_WRITE);
            if (conversas == null) {
                System.out.println("Conversa not found");
                return null;
            }
            conversas.setIdConversa(entity.getIdConversa());
            conversas.setNomeConversa(entity.getNomeConversa());

            unitOfWork.commit();
            return entity.getIdConversa();
        }

        @Override
        public Integer Delete(Conversas entity) {
            unitOfWork.beginTransaction();

            Conversas conversas =
                    unitOfWork._em.find(Conversas.class, entity.getIdConversa(), LockModeType.PESSIMISTIC_WRITE);
            if (conversas == null) {
                System.out.println("Conversa not found");
                return null;
            }

            unitOfWork._em.remove(entity);
            unitOfWork.commit();
            return conversas.getIdConversa();
        }
    }


    // TODO: 28/05/2023 Não sei se as implementações da classe em baixo estão corretas!
    protected class EstatisticasJogadoresMapper implements IEstatisticasJogadoresMapper {

        @Override
        public Integer Create(estatisticas_jogadores entity) {
            return null;
        }

        @Override
        public estatisticas_jogadores Read(Integer id) {
            return unitOfWork._em.find(estatisticas_jogadores.class, id);
        }

        @Override
        public Integer Update(estatisticas_jogadores entity) {
            return null;
        }

        @Override
        public Integer Delete(estatisticas_jogadores entity) {
            return null;
        }
    }


    protected class EstatisticasJogosMapper implements IEstatisticasJogosMapper {

        @Override
        public Character Create(estatisticas_jogo entity) {
            return null;
        }

        @Override
        public estatisticas_jogo Read(Character id) {
            return unitOfWork._em.find(estatisticas_jogo.class, id);
        }

        @Override
        public Character Update(estatisticas_jogo entity) {
            return null;
        }

        @Override
        public Character Delete(estatisticas_jogo entity) {
            return null;
        }
    }


    protected class JogaMjMapper implements IJogaMjMapper {

        @Override
        public JogaMjId Create(JogaMj entity) {
            unitOfWork.beginTransaction();
            unitOfWork._em.persist(entity);
            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public JogaMj Read(JogaMjId id) {
            return unitOfWork._em.find(JogaMj.class, id);
        }

        @Override
        public JogaMjId Update(JogaMj entity) {
            unitOfWork.beginTransaction();

            JogaMj jogaMJ =
                    unitOfWork._em.find(JogaMj.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (jogaMJ == null) {
                System.out.println("JogaMj not found.");
                return null;
            }
            jogaMJ.setId(entity.getId());
            jogaMJ.setPontuacaoMj(entity.getPontuacaoMj());

            return entity.getId();
        }

        @Override
        public JogaMjId Delete(JogaMj entity) {
            unitOfWork.beginTransaction();

            JogaMj jogaMj =
                    unitOfWork._em.find(JogaMj.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (jogaMj == null) {
                System.out.println("JogaMj not found");
                return null;
            }

            unitOfWork._em.remove(jogaMj);
            unitOfWork.commit();
            return jogaMj.getId();
        }
    }


    public class JogosMapper implements IJogosMapper {

        @Override
        public String Create(Jogos entity) {
            unitOfWork.beginTransaction();
            unitOfWork._em.persist(entity);
            unitOfWork.commit();
            return entity.getIdGame();
        }

        @Override
        public Jogos Read(String id) {
            return unitOfWork._em.find(Jogos.class, id);
        }

        @Override
        public String Update(Jogos entity) {
            unitOfWork.beginTransaction();

            Jogos jogo =
                    unitOfWork._em.find(Jogos.class, entity.getIdGame(), LockModeType.PESSIMISTIC_WRITE);
            if (jogo == null) {
                System.out.println("Jogo not found.");
                return null;
            }
            jogo.setIdGame(entity.getIdGame());
            jogo.setUrl(entity.getUrl());
            jogo.setNomeGame(entity.getNomeGame());

            return entity.getIdGame();
        }

        @Override
        public String Delete(Jogos entity) {
            unitOfWork.beginTransaction();

            Jogos jogo =
                    unitOfWork._em.find(Jogos.class, entity.getIdGame(), LockModeType.PESSIMISTIC_WRITE);
            if (jogo == null) {
                System.out.println("Jogo not found");
                return null;
            }

            unitOfWork._em.remove(jogo);
            unitOfWork.commit();
            return jogo.getIdGame();
        }
    }


    protected class MensagensMapper implements IMensagensMapper {

        @Override
        public MensagensId Create(Mensagens entity) {
            unitOfWork.beginTransaction();
            unitOfWork._em.persist(entity);
            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public Mensagens Read(MensagensId id) {
            return unitOfWork._em.find(Mensagens.class, id);
        }

        @Override
        public MensagensId Update(Mensagens entity) {
            unitOfWork.beginTransaction();

            Mensagens mensagem =
                    unitOfWork._em.find(Mensagens.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (mensagem == null) {
                System.out.println("Mensagem not found.");
                return null;
            }
            //Este setter de id difere dos outros
            mensagem.setId(entity.getId());
            mensagem.setRemetente(entity.getRemetente());
            mensagem.setDataHoraMsg(entity.getDataHoraMsg());

            return entity.getId();
        }

        @Override
        public MensagensId Delete(Mensagens entity) {
            unitOfWork.beginTransaction();

            Mensagens mensagem =
                    unitOfWork._em.find(Mensagens.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (mensagem == null) {
                System.out.println("Mensagem not found");
                return null;
            }

            unitOfWork._em.remove(mensagem);
            unitOfWork.commit();
            return mensagem.getId();
        }
    }


    public class JogadoresMapper implements IJogadoresMapper {

        @Override
        public Integer Create(Jogadores entity) {
            try (DataScope ds = new DataScope()) {
                EntityManager em = ds.getEntityManager();
                em.getTransaction().begin();
                em.persist(entity);
                em.getTransaction().commit();
                return entity.getIdPlayer();
            }
        }

        @Override
        public Jogadores Read(Integer id) {
            return unitOfWork._em.find(Jogadores.class, id);
        }

        @Override
        public Integer Update(Jogadores entity) {
            unitOfWork.beginTransaction();

            Jogadores jogador =
                    unitOfWork._em.find(Jogadores.class, entity.getIdPlayer(), LockModeType.PESSIMISTIC_READ);
            if (jogador == null) {
                System.out.println("Jogador not found.");
                return null;
            }
            jogador.setIdPlayer(entity.getIdPlayer());
            jogador.setEmail(entity.getEmail());
            jogador.setUsername(entity.getUsername());
            jogador.setEstadoPlayer(entity.getEstadoPlayer());
            jogador.setNomeRegiao(entity.getNomeRegiao());

            return entity.getIdPlayer();
        }

        @Override
        public Integer Delete(Jogadores entity) {
            unitOfWork.beginTransaction();

            Jogadores jogador =
                    unitOfWork._em.find(Jogadores.class, entity.getIdPlayer(), LockModeType.PESSIMISTIC_WRITE);
            if (jogador == null) {
                System.out.println("Jogador not found");
                return null;
            }

            unitOfWork._em.remove(jogador);
            unitOfWork.commit();
            return jogador.getIdPlayer();
        }
    }


    public static class CrachaMapper implements ICrachaMapper {

        @Override
        public String Create(Crachas entity) {
            try (DataScope ds = new DataScope()) {
                EntityManager em = ds.getEntityManager();
                em.getTransaction().begin();
                em.persist(entity);
                em.getTransaction().commit();
                return entity.getId().getNomeCracha();
            }
        }

        @Override
        public Crachas Read(String id) {
            return null;
        }

        @Override
        public Crachas read(String idGame, String nomeCracha) {
            try (DataScope ds = new DataScope()) {
                EntityManager em = ds.getEntityManager();

                Crachas cracha =
                        em.find(Crachas.class, new CrachasId(idGame, nomeCracha), LockModeType.PESSIMISTIC_READ);

                ds.validateWork();
                return cracha;
            }
        }

        @Override
        public String Update(Crachas entity) {
            try (DataScope ds = new DataScope()) {
                EntityManager em = ds.getEntityManager();
                em.flush();

                Crachas a =
                        em.find(Crachas.class, entity, LockModeType.PESSIMISTIC_WRITE);
                a.setId(a.getId());
                a.setUrl(a.getUrl());
                a.setLimitePontos(a.getLimitePontos());

                ds.validateWork();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }
            return null;
        }

        @Override
        public String Delete(Crachas entity) {
            return null;
        }
    }


    public static class NormalMapper implements INormalMapper {

        @Override
        public Normald Create(Normal entity) {
            return null;
        }

        @Override
        public Normal Read(Normald id) {
            return null;
        }

        @Override
        public Normal read(String idGame, String nomeRegiao) {
            try (DataScope ds = new DataScope()) {
                EntityManager em = ds.getEntityManager();

                Normal normal = em.find(Normal.class, new Normald(idGame, nomeRegiao));

                ds.validateWork();
                return normal;
            }
        }

        @Override
        public Normald Update(Normal entity) {
            return null;
        }

        @Override
        public Normald Delete(Normal entity) {
            return null;
        }
    }
}