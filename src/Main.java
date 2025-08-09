import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha sua opção:\n[0] - Sair\n[1] - Fazer pedido");
            String input = scanner.nextLine();
            switch (input) {
                case "0":
                    sair();
                    break;

                case "1":
                    cardapio();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static void sair() {
        System.exit(0);
    }

    public static void cardapio() {
        Item item1 = new Item(1, "Coca Cola", 7);
        Item item2 = new Item(2, "Sanduíche", 13);
        Item item3 = new Item(3, "Brigadeiro", 8);
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        ArrayList<Item> carrinho = new ArrayList<>();
        while (true) {
            System.out.println(
                    "========== CARDÁPIO ===========" +
                    "\n[1] - Coca Cola  - R$ 7,00" +
                    "\n[2] - Sanduíche  - R$ 13,00" +
                    "\n[3] - Brigadeiro - R$ 8,00" +
                    "\n[0] - Finalizar pedido" +
                    "\n=============================");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    carrinho.add(item1);
                    System.out.println("--> Produto adicionado!!!");
                    break;
                case "2":
                    carrinho.add(item2);
                    System.out.println("--> Produto adicionado!!!");
                    break;
                case "3":
                    carrinho.add(item3);
                    System.out.println("--> Produto adicionado!!!");
                    break;
                case "0":
                    double preco = 0;
                    System.out.println("======= Nota fiscal de " + nome + " =======");
                    for (Item item : carrinho) {
                        preco += item.preco;
                        System.out.println("--> " + item.id + " - " + item.nome + " - " + item.preco);
                    }
                    double taxaSer = preco * 0.1;
                    double valorTotal = preco + taxaSer;
                    System.out.println("==========================");
                    System.out.println("--> Valor itens: R$ " + preco);
                    System.out.println("--> Taxa de serviço: R$ " + taxaSer);
                    System.out.println("--> VALOR TOTAL: R$ " + valorTotal);
                    boolean finalizar = false;
                    while (!finalizar) {
                        System.out.println("======= Valor recebido: =======");
                        double valorRecebido = scanner.nextDouble();
                        if (valorRecebido < valorTotal) {
                            System.out.println("Pagamento incompleto. Tente novamente!");
                        } else {
                            double troco = valorRecebido - valorTotal;
                            System.out.println("======= Troco: R$" + troco + " =======");
                            return;
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
