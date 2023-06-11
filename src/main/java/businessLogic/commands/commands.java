package businessLogic.commands;

import businessLogic.View.ConsoleView;
import businessLogic.View.View;
import businessLogic.accessFunctionalities.*;

import java.util.Map;


public class commands {

    protected View view = new ConsoleView();

    public Map<String, Action> getCommands() {
        return Map.ofEntries(
                Map.entry("0", new Exit()),
                Map.entry("1", new CriarJogador()),
                Map.entry("2", new DesativarJogador()),
                Map.entry("3", new BanirJogador()),
                Map.entry("4", new TotalPontosJogador()),
                Map.entry("5", new TotalJogosJogador()),
                Map.entry("6", new PontosJogoPorJogador()),
                Map.entry("7", new AssociarCracha()),
                Map.entry("8", new IniciarConversa()),
                Map.entry("9", new JuntarConversa()),
                Map.entry("10", new EnviarMensagem()),
                Map.entry("11", new JogadorTotalInfo()),
                Map.entry("12", new pessimistCrachaUpdate()),
                Map.entry("13", new optimisticCrachaUpdate())
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
            String email, username, nome_regiao;
            try {
                email = view.getInputString("Email: ");
                username = view.getInputString("Username: ");
                nome_regiao = view.getInputString("Região: ");
                accessFunctionality.criar_jogador(email, username, nome_regiao);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class DesativarJogador implements Action {
        @Override
        public void execute() {
            Integer id;
            try {
                id = view.getInputInt("Id: ");
                accessFunctionality.desativar_jogador(id);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class BanirJogador implements Action {
        @Override
        public void execute() {
            Integer id;
            try {
                id = view.getInputInt("Id: ");
                accessFunctionality.banir_jogador(id);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class TotalPontosJogador implements Action {
        @Override
        public void execute() {
            Integer id;
            try {
                id = view.getInputInt("Id: ");
                accessFunctionality.total_pontos_jogador(id);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class TotalJogosJogador implements Action {
        @Override
        public void execute() {
            Integer id;
            try {
                id = view.getInputInt("Id: ");
                accessFunctionality.total_jogos_jogador(id);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class PontosJogoPorJogador implements Action {
        @Override
        public void execute() {
            String id_game;
            try {
                id_game = view.getInputString("Id_game: ");
                accessFunctionality.pontos_jogo_por_jogador(id_game);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class AssociarCracha implements Action {
        @Override
        public void execute() {
            Integer id_jogador;
            String id_game, nome_cracha;
            try {
                id_jogador = view.getInputInt("Id Jogador: ");
                id_game = view.getInputString("Id Game: ");
                nome_cracha = view.getInputString("Nome Cracha: ");
                accessFunctionality.associar_cracha(id_jogador, id_game, nome_cracha);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class IniciarConversa implements Action {
        @Override
        public void execute() {
            Integer id_jogador;
            String nome_chat;
            try {
                id_jogador = view.getInputInt("Id Jogador: ");
                nome_chat = view.getInputString("Nome chat: ");
                accessFunctionality.iniciar_conversa(id_jogador, nome_chat);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class JuntarConversa implements Action {
        @Override
        public void execute() {
            Integer id_player, id_conv;
            try {
                id_player = view.getInputInt("Id Jogador: ");
                id_conv = view.getInputInt("Id Conversar: ");
                accessFunctionality.juntar_conversa(id_player, id_conv);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class EnviarMensagem implements Action {
        @Override
        public void execute() {
            Integer id_jogador, id_conv;
            String msg;
            try {
                id_jogador = view.getInputInt("Id Jogador: ");
                id_conv = view.getInputInt("Id Conversa: ");
                msg = view.getInputString("Mensagem: ");
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
            String nomeCracha, idGame;
            try {
                nomeCracha = view.getInputString("Nome cracha: ");
                idGame = view.getInputString("Id Game: ");
                accessFunctionality.pessimistCrachaUpdate(nomeCracha, idGame);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class optimisticCrachaUpdate implements Action {
        @Override
        public void execute() {
            String nomeCracha, idGame;
            try {
                nomeCracha = view.getInputString("Nome cracha: ");
                idGame = view.getInputString("Id Game: ");
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