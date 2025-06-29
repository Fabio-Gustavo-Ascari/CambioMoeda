import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Moedas {
    private double brl;
    private double usd;
    private double eur;
    private double gbp;
    private double jpy;
    private double cny;

    private double result;

    Map<String, Double> taxas = new HashMap<>();
    Busca busca = new Busca();


     public void setMoedaCambio(String moeda) throws IOException, InterruptedException {
        RateApi rateApi = busca.buscadorDeMoeda(moeda);
         taxas = rateApi.conversion_rates();

         this.brl = taxas.get("BRL");
         this.usd = taxas.get("USD");
         this.eur = taxas.get("EUR");
         this.gbp = taxas.get("GBP");
         this.jpy = taxas.get("JPY");
         this.cny = taxas.get("CNY");
     }



    public void resultadoCambio(int choose, double valor){
         switch (choose) {
             case 1:
                 this.result = valor*getUsd();
                 System.out.println("******************************************");
                 System.out.println(String.format("O valor do Câmbio em Dólar: %.2f", result));
                 System.out.println("******************************************");
                 break;

             case 2:
                 this.result = valor*getEur();
                 System.out.println("******************************************");
                 System.out.println(String.format("O valor do Câmbio em Euro: %.2f", result));
                 System.out.println("******************************************");
                 break;

             case 3:
                 this.result = valor*getBrl();
                 System.out.println("******************************************");
                 System.out.println(String.format("O valor do Câmbio em Real: %.2f" , result));
                 System.out.println("******************************************");
                 break;

             case 4:
                 this.result = valor*getJpy();
                 System.out.println("******************************************");
                 System.out.println(String.format("O valor do Câmbio em Iene Japonês: %.2f" , result));
                 System.out.println("******************************************");
                 break;

             case 5:
                 this.result = valor*getGbp();
                 System.out.println("******************************************");
                 System.out.println(String.format("O valor do Câmbio em Libra: %.2f" , result));
                 System.out.println("******************************************");
                 break;

             case 6:
                 this.result = valor*getCny();
                 System.out.println("******************************************");
                 System.out.println(String.format("O valor do Câmbio em Yuan Chinês: %.2f", result));
                 System.out.println("******************************************");
                 break;

         }
     }


    public double getBrl() {
        return brl;
    }

    public double getUsd() {
        return usd;
    }

    public double getEur() {
        return eur;
    }

    public double getGbp() {
        return gbp;
    }

    public double getJpy() {
        return jpy;
    }

    public double getCny() {
        return cny;
    }

    @Override
    public String toString() {
        return "brl: " + brl +
                " usd: " + usd +
                " eur: " + eur +
                " gbp: " + gbp +
                " jpy: " + jpy +
                " cny: " + cny +
                '}';
    }
}
