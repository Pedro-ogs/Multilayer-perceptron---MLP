
public class MlpMain {
    private static double [][][] base = new double[][][]{

            {{0,0},{0}},
            {{0,1},{1}},
            {{1,0},{1}},
            {{1,1},{0}},
    };

    public static void main(String[] args) {
        Mlp perceptron = new Mlp(2,1,2,0.3);
        for (int e = 0; e < 10000; e++){
            double erroEpoca = 0;
            int erroClassificacaoEpoca = 0;
            for (int a = 0; a < base.length; a++){
                double[] x = base[a][0];
                double[] y = base[a][1];
                double[] o = perceptron.treinar(x,y);

                double erroAmostra = 0;//valor do somatorio
                int erroClassificacao = 0 ;
                for (int i = 0; i< y.length; i++){
                    erroAmostra += Math.abs(y[i] - o[i]);

                    if( o[i] >= 0.5){
                        erroClassificacao += Math.abs(y[i] - 1) ;
                    }else{
                        erroClassificacao +=  Math.abs(y[i] - 0);
                    }
                }
                erroClassificacaoEpoca += erroClassificacao;
                erroEpoca += erroAmostra;

            }
            System.out.println("A epoca: " + e + " - erro: " + erroEpoca + " - erro de classificação: " + erroClassificacaoEpoca);
        }
    }
}
