package businessLogic.commands;

import businessLogic.View.ConsoleView;
import businessLogic.View.View;
import businessLogic.accessFunctionalities.*;

import java.util.Map;


public class commands {

    protected View view = new ConsoleView();

    public Map<Integer, Action> getCommands() {
        int i = 0;
        return Map.ofEntries(
                Map.entry(i, new Exit()),
                Map.entry(++i, new CriarJogador()),
                Map.entry(++i, new DesativarJogador()),
                Map.entry(++i, new BanirJogador()),
                Map.entry(++i, new TotalPontosJogador()),
                Map.entry(++i, new TotalJogosJogador()),
                Map.entry(++i, new PontosJogoPorJogador()),
                Map.entry(++i, new AssociarCracha()),
                Map.entry(++i, new IniciarConversa()),
                Map.entry(++i, new JuntarConversa()),
                Map.entry(++i, new EnviarMensagem()),
                Map.entry(++i, new JogadorTotalInfo()),
                Map.entry(++i, new pessimistCrachaUpdate()),
                Map.entry(++i, new optimisticCrachaUpdate())
        );
    }

    public static class Exit implements Action {
        @Override
        public void execute() {
            System.out.println("Exiting the program...");
            System.exit(0);
        }
    }

    public class CriarJogador implements Action {
        @Override
        public void execute() {
            try {
                String email = view.getInputString("Email: ");
                String username = view.getInputString("Username: ");
                String nome_regiao = view.getInputString("Região: ");
                accessFunctionality.criar_jogador(email, username, nome_regiao);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class DesativarJogador implements Action {
        @Override
        public void execute() {
            try {
                Integer id = view.getInputInt("Id: ");
                accessFunctionality.desativar_jogador(id);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class BanirJogador implements Action {
        @Override
        public void execute() {
            try {
                Integer id = view.getInputInt("Id: ");
                accessFunctionality.banir_jogador(id);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class TotalPontosJogador implements Action {
        @Override
        public void execute() {
            try {
                Integer id = view.getInputInt("Id: ");
                accessFunctionality.total_pontos_jogador(id);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class TotalJogosJogador implements Action {
        @Override
        public void execute() {
            try {
                Integer id = view.getInputInt("Id: ");
                accessFunctionality.total_jogos_jogador(id);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class PontosJogoPorJogador implements Action {
        @Override
        public void execute() {
            try {
                String id_game = view.getInputString("Id_game: ");
                accessFunctionality.pontos_jogo_por_jogador(id_game);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class AssociarCracha implements Action {
        @Override
        public void execute() {
            try {
                Integer id_jogador = view.getInputInt("Id Jogador: ");
                String id_game = view.getInputString("Id Game: ");
                String nome_cracha = view.getInputString("Nome Cracha: ");
                accessFunctionality.associar_cracha(id_jogador, id_game, nome_cracha);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class IniciarConversa implements Action {
        @Override
        public void execute() {
            try {
                Integer id_jogador = view.getInputInt("Id Jogador: ");
                String nome_chat = view.getInputString("Nome chat: ");
                accessFunctionality.iniciar_conversa(id_jogador, nome_chat);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class JuntarConversa implements Action {
        @Override
        public void execute() {
            try {
                Integer id_player = view.getInputInt("Id Jogador: ");
                Integer id_conv = view.getInputInt("Id Conversar: ");
                accessFunctionality.juntar_conversa(id_player, id_conv);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class EnviarMensagem implements Action {
        @Override
        public void execute() {
            try {
                Integer id_jogador = view.getInputInt("Id Jogador: ");
                Integer id_conv = view.getInputInt("Id Conversa: ");
                String msg = view.getInputString("Mensagem: ");
                accessFunctionality.enviar_mensagem(id_jogador, id_conv, msg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static class JogadorTotalInfo implements Action {
        @Override
        public void execute() {
            try {
                accessFunctionality.jogador_total_info();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class pessimistCrachaUpdate implements Action {
        @Override
        public void execute() {
            try {
                String nomeCracha = view.getInputString("Nome cracha: ");
                String idGame = view.getInputString("Id Game: ");
                accessFunctionality.pessimistCrachaUpdate(nomeCracha, idGame);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class optimisticCrachaUpdate implements Action {
        @Override
        public void execute() {
            try {
                String nomeCracha = view.getInputString("Nome cracha: ");
                String idGame = view.getInputString("Id Game: ");
                accessFunctionality.optimistCrachaUpdate(nomeCracha, idGame);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        commands cmd = new commands();
        cmd.new EnviarMensagem().execute();
    }
}