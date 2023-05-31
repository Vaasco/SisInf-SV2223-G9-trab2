/*package data_access;

import data_access.JPA_unit_of_work;
import data_mappers.*;
import jakarta.persistence.LockModeType;
import model.*;
import orm.interfaces.ICrachas;
import orm.interfaces.IEstatisticasJogadores;

public class Mappers {

    private final JPA_unit_of_work unitOfWork;

    public Mappers(JPA_unit_of_work context) {
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
            Comprar cr = unitOfWork._em.find(Comprar.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Compra not found");
                return null;
            }
            cr.setId(entity.getId());
            cr.setPreco(entity.getPreco());
            cr.setDataCompra(entity.getDataCompra());
            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public ComprarId Delete(Comprar entity) {
            unitOfWork.beginTransaction();
            Comprar cr = unitOfWork._em.find(Comprar.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Compra not found");
                return null;
            }
            unitOfWork._em.remove(entity);
            unitOfWork.commit();
            return cr.getId();
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
            Conversas cr = unitOfWork._em.find(Conversas.class, entity.getIdConversa(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Conversa not found");
                return null;
            }
            cr.setIdConversa(entity.getIdConversa());
            cr.setNomeConversa(entity.getNomeConversa());
            unitOfWork.commit();
            return entity.getIdConversa();
        }

        @Override
        public Integer Delete(Conversas entity) {
            unitOfWork.beginTransaction();
            Conversas cr = unitOfWork._em.find(Conversas.class, entity.getIdConversa(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Conversa not found");
                return null;
            }
            unitOfWork._em.remove(entity);
            unitOfWork.commit();
            return cr.getIdConversa();
        }
    }

    protected class CrachasMapper implements ICrachasMapper {

        @Override
        public CrachasId Create(Crachas entity) {
            unitOfWork.beginTransaction();
            unitOfWork._em.persist(entity);
            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public Crachas Read(CrachasId id) {
            return unitOfWork._em.find(Crachas.class, LockModeType.PESSIMISTIC_WRITE);
        }

        @Override
        public CrachasId Update(Crachas entity) {
            unitOfWork.beginTransaction();
            Crachas cr = unitOfWork._em.find(Crachas.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Crachas not found.");
                return null;
            }
            cr.setId(entity.getId());
            cr.setUrl(entity.getUrl());
            cr.setLimitePontos(entity.getLimitePontos());
            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public CrachasId Delete(Crachas entity) {
            unitOfWork.beginTransaction();
            Crachas cr = unitOfWork._em.find(Crachas.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Crachas not found");
                return null;
            }
            unitOfWork._em.remove(cr);
            unitOfWork.commit();
            return cr.getId();
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
            JogaMj cr = unitOfWork._em.find(JogaMj.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("JogaMj not found.");
                return null;
            }
            cr.setId(entity.getId());
            cr.setPontuacaoMj(entity.getPontuacaoMj());
            return entity.getId();
        }

        @Override
        public JogaMjId Delete(JogaMj entity) {
            unitOfWork.beginTransaction();
            JogaMj cr = unitOfWork._em.find(JogaMj.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("JogaMj not found");
                return null;
            }
            unitOfWork._em.remove(cr);
            unitOfWork.commit();
            return cr.getId();
        }
    }

    protected class JogosMapper implements IJogosMapper {

        @Override
        public Character Create(Jogos entity) {
            unitOfWork.beginTransaction();
            unitOfWork._em.persist(entity);
            unitOfWork.commit();
            return entity.getIdGame();
        }

        @Override
        public Jogos Read(Character id) {
            return unitOfWork._em.find(Jogos.class, id);
        }

        @Override
        public Character Update(Jogos entity) {
            unitOfWork.beginTransaction();
            Jogos cr = unitOfWork._em.find(Jogos.class, entity.getIdGame(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Jogo not found.");
                return null;
            }
            cr.setIdGame(entity.getIdGame());
            cr.setUrl(entity.getUrl());
            cr.setNomeGame(entity.getNomeGame());
            return entity.getIdGame();
        }

        @Override
        public Character Delete(Jogos entity) {
            unitOfWork.beginTransaction();
            Jogos cr = unitOfWork._em.find(Jogos.class, entity.getIdGame(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Jogo not found");
                return null;
            }
            unitOfWork._em.remove(cr);
            unitOfWork.commit();
            return cr.getIdGame();
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
            Mensagens cr = unitOfWork._em.find(Mensagens.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Mensagem not found.");
                return null;
            }
            //Este setter de id é diferente dos outros
            cr.setId(entity.getId());
            cr.setRemetente(entity.getRemetente());
            cr.setDataHoraMsg(entity.getDataHoraMsg());
            return entity.getId();
        }

        @Override
        public MensagensId Delete(Mensagens entity) {
            unitOfWork.beginTransaction();
            Mensagens cr = unitOfWork._em.find(Mensagens.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Mensagem not found");
                return null;
            }
            unitOfWork._em.remove(cr);
            unitOfWork.commit();
            return cr.getId();
        }
    }

    protected class MultijogadorMapper implements IMultijogadorMapper {

        @Override
        public MultijogadorId Create(Multijogador entity) {
            unitOfWork.beginTransaction();
            unitOfWork._em.persist(entity);
            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public Multijogador Read(MultijogadorId id) {
            return unitOfWork._em.find(Multijogador.class, id);
        }

        @Override
        public MultijogadorId Update(Multijogador entity) {
            unitOfWork.beginTransaction();
            Multijogador cr = unitOfWork._em.find(Multijogador.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Multijogador not found.");
                return null;
            }

            cr.setId(entity.getId());
            cr.setDataHoraFim(entity.getDataHoraFim());
            cr.setDataHoraInicio(entity.getDataHoraInicio());
            cr.setEstadoPartida(entity.getEstadoPartida());
            cr.setJogadores(entity.getJogadores());
            cr.setJogos(entity.getJogos());
            cr.setNomeRegiao(entity.getNomeRegiao());
            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public MultijogadorId Delete(Multijogador entity) {
            unitOfWork.beginTransaction();
            Multijogador cr = unitOfWork._em.find(Multijogador.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Multijogador not found");
                return null;
            }
            unitOfWork._em.remove(cr);
            unitOfWork.commit();
            return cr.getId();
        }
    }

    protected class NormalMapper implements INormalMapper {

        @Override
        public Normald Create(Normal entity) {
            unitOfWork.beginTransaction();
            unitOfWork._em.persist(entity);
            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public Normal Read(Normald id) {
            return unitOfWork._em.find(Normal.class, id);
        }

        @Override
        public Normald Update(Normal entity) {
            unitOfWork.beginTransaction();
            Normal cr = unitOfWork._em.find(Normal.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Normal not found.");
                return null;
            }

            cr.setId(entity.getId());
            cr.setDataHoraFim(entity.getDataHoraFim());
            cr.setDataHoraInicio(entity.getDataHoraInicio());
            cr.setEstadoPartida(entity.getEstadoPartida());
            cr.setGrauDificuldade(entity.getGrauDificuldade());
            cr.setJogadores(entity.getJogadores());
            cr.setJogos(entity.getJogos());
            cr.setNomeRegiao(entity.getNomeRegiao());
            cr.setPontuacaoN(entity.getPontuacaoN());
            unitOfWork.commit();
            return entity.getId();
        }

        @Override
        public Normald Delete(Normal entity) {
            unitOfWork.beginTransaction();
            Normal cr = unitOfWork._em.find(Normal.class, entity.getId(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Normal not found");
                return null;
            }
            unitOfWork._em.remove(cr);
            unitOfWork.commit();
            return cr.getId();
        }
    }

    protected class RegiaoMapper implements IRegiaoMapper {

        @Override
        public String Create(Regiao entity) {
            unitOfWork.beginTransaction();
            unitOfWork._em.persist(entity);
            unitOfWork.commit();
            return entity.getNomeRegiao();
        }

        @Override
        public Regiao Read(String id) {
            return unitOfWork._em.find(Regiao.class, id);
        }

        @Override
        public String Update(Regiao entity) {
            unitOfWork.beginTransaction();
            Regiao cr = unitOfWork._em.find(Regiao.class, entity.getNomeRegiao(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Regiao not found.");
                return null;
            }

            cr.setNomeRegiao(entity.getNomeRegiao());
            unitOfWork.commit();
            return entity.getNomeRegiao();
        }

        @Override
        public String Delete(Regiao entity) {
            unitOfWork.beginTransaction();
            Regiao cr = unitOfWork._em.find(Regiao.class, entity.getNomeRegiao(), LockModeType.PESSIMISTIC_WRITE);
            if (cr == null) {
                System.out.println("Regiao not found");
                return null;
            }
            unitOfWork._em.remove(cr);
            unitOfWork.commit();
            return cr.getNomeRegiao();
        }
    }


}
*/
