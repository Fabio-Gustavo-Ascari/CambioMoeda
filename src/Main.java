import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String moeda = "";
        Moedas moedas = new Moedas();
        Scanner scanner = new Scanner(System.in);
        String mainEscolha1 = """
                **************************************
                        Digite uma moeda:
               
                          Dólar Americano (USD)
                          Euro (EUR)
                          Real Brasileiro (BRL)
                          Iene Japonês (JPY)
                          Libra Esterlina (GBP)
                          Yuan Chinês (CNY)
               
                          (Para Sair digite: SAIR)
                **************************************
               """;
        String mainEscolha2 = """
                **************************************
                        Escolha a moeda de Câmbio:
               
                        1)  Dólar Americano (USD)
                        2)  Euro (EUR)
                        3)  Real Brasileiro (BRL)
                        4)  Iene Japonês (JPY)
                        5)  Libra Esterlina (GBP)
                        6)  Yuan Chinês (CNY)
                **************************************
               """;
        String mainescolha3 = """
                ***************************************
                  Digite o valor que deseja Converter:
                ***************************************
                """;


        while (!moeda.equalsIgnoreCase("sair")) {

               System.out.println(mainEscolha1);
               moeda = scanner.nextLine();


            if (moeda == null || moeda.isEmpty()){
                moeda = scanner.nextLine();
            }

            if (moeda.equalsIgnoreCase("sair")){ break;}

            moedas.setMoedaCambio(moeda);
            moeda = "";


            System.out.println(mainescolha3);
            double valor = scanner.nextDouble();

            System.out.println(mainEscolha2);
            int choose = scanner.nextInt();
            moedas.resultadoCambio(choose, valor);

        }

    }
}