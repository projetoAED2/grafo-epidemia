package br.com.grafo;

import java.util.List;

public class Utils {
    public static Individuo encontrarIndividuoPorCodigo(List<Individuo> individuos, Long codigoDesejado) {
        for (Individuo individuo : individuos) {
            if (individuo.getCodigo().equals(codigoDesejado)) {
                return individuo;
            }
        }
        return null;
    }
}
