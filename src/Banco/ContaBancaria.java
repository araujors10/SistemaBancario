package Banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author rodri
 */
public class ContaBancaria {

    int numero;
    int agencia = 104;
    int contaCorrente; //PF
    int contaEmpresarial; //PJ
    private static int numero1, numero2;

    public int getNumero() {
        return numero;
    }

    public int setNumero(int numero) {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(int contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public int getContaEmpresarial() {
        return contaEmpresarial;
    }

    public void setContaEmpresarial(int contaEmpresarial) {
        this.contaEmpresarial = contaEmpresarial;
    }

    public static List<Integer> gerarNumConta() {
        int number;
        List<Integer> numeros = new ArrayList();
        Random num = new Random();

        while (numeros.size() < 6) {
            number = 1 + num.nextInt(9);

            if (!numeros.contains(number)) {
                numeros.add(number);      
            }
        }

        for (Integer numero2 : numeros) {
        }
        return numeros;

    }

}
