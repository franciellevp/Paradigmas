package Utils;

public class Operacao {

    public static Double StringToDouble(String str) {
        return ValidaNumeroAcertos(str) ? Double.parseDouble(str.replace(",", ".")) : 0;
    }

    private static boolean ValidaNumeroAcertos(String x) {
        return !x.contains("acerto") && !x.contains("-");
    }
}
