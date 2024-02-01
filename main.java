import java.util.Scanner;
import java.util.Random;

class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Pressione enter para iniciar: ");
        sc.nextLine();
        System.out.print("Voce quer jogar? Digite '1' para sim ou '2' para nao: ");
        int pontosPlayer = 0;
        int pontosIa = 0;
        int empate = 0;

        int novoJogo = sc.nextInt();

//bibliotecas de mensagens 
        String[] mensagensVitoria = {
            "Parabéns! Você venceu!",
            "Incrível! Vitória para o jogador.",
            "Você mostrou suas habilidades e venceu.",
            "A vitória é sua, jogador!",
            "Mais uma para o jogador! Parabéns.",
            "Impressionante! O jogador conquista a vitória.",
            "Você é imparável! Vitória para o jogador.",
            "O jogador comemora outra grande vitória."
        };

        String[] mensagensVitoriaMaquina = {
            "A máquina mais uma vez prova ser invencível.",
            "Desta vez, a vitória é da máquina.",
            "A maquina mostra sua superioridade.",
            "Você deu o seu melhor, mas a máquina vence novamente.",
            "A vitória desta vez é da máquina.",
            "A maquina se destaca com outra vitória.",
            "Infelizmente, a máquina prevaleceu.",
            "A máquina comemora mais uma vitória."
        };

        while (novoJogo == 1) {
            System.out.println("Escolha '1' para pedra, '2' para papel e '3' para tesoura: ");
            int escolhaPlayer = sc.nextInt();

            while (escolhaPlayer < 1 || escolhaPlayer > 3) {
                System.out.println("Opcao invalida, deve ser '1' para pedra, '2' para papel ou '3' para tesoura: ");
                time();
                escolhaPlayer = sc.nextInt();
            }
            Random gerador = new Random();

            int escolhaIa = (gerador.nextInt(2) + 1);

            Boolean resultado = resultado(escolhaPlayer, escolhaIa);
            
            switch (escolhaPlayer) {
                case 1:
                    System.out.println("Voce escolheu pedra");
                    break;
                case 2:
                    System.out.println("Voce escolheu papel");
                    break;
                case 3:
                    System.out.println("Voce escolheu tesoura");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
            time();
            System.out.println(" ");
            System.out.print("A maquina esta escolhendo");
            for (int x = 0; x < 3; x++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print(".");

                if (x == 2) {
                    System.out.print("\n");
                }
            }
            time();
            System.out.print("\n");
            switch (escolhaIa) {
                case 1:
                    System.out.println("A maquina escolheu pedra");
                    break;
                case 2:
                    System.out.println("A maquina escolheu papel");
                    break;
                case 3:
                    System.out.println("A maquina escolheu tesoura");
                    break;
            }
            time();
            if (!resultado) {
                System.out.println(obterMensagemAleatoria(mensagensVitoriaMaquina));
            } else {
                System.out.println(obterMensagemAleatoria(mensagensVitoria));
            }

            switch (escolhaPlayer) {
                case 1:
                    if (escolhaIa == 1) {
                        empate++;
                    } else if (escolhaIa == 3) {
                        pontosPlayer++;
                    } else if (escolhaIa == 2) {
                        pontosIa++;
                    }
                    break;
                case 2:
                    if (escolhaIa == 2) {
                        empate++;
                    } else if (escolhaIa == 1) {
                        pontosPlayer++;
                    } else if (escolhaIa == 3) {
                        pontosIa++;
                    }
                    break;
                case 3:
                    if (escolhaIa == 3) {
                        empate++;
                    } else if (escolhaIa == 2) {
                        pontosPlayer++;
                    } else if (escolhaIa == 1) {
                        pontosIa++;
                    }
                    break;
            }
            time();
            System.out.println("\nQuer jogar novamente? Digite '1' para sim ou '2' para nao: ");
            novoJogo = sc.nextInt();
        }
        time();
        System.out.println("------------------------\n");
        System.out.println("A maquina fez " + pontosIa + " pontos");
        System.out.println("O Player fez " + pontosPlayer + " pontos");
        System.out.println("Deu " + empate + " empates");
        sc.close();
    }

    public static boolean resultado(int player, int ia) {
        if (player == 1 && ia == 1 || player == 2 && ia == 2 || player == 3 && ia == 3) {
            return false;
        } else if (player == 1 && ia == 3 || player == 2 && ia == 1 || player == 3 && ia == 2) {
            return true;
        } else if (player == 1 && ia == 2 || player == 2 && ia == 3 || player == 3 && ia == 1) {
            return false;
        }
        return false;
    }
    public static void time(){
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
    }
    private static String obterMensagemAleatoria(String[] array) {
        Random random = new Random();
        int indice = random.nextInt(array.length);
        return array[indice];
    }
}
