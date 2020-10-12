package Banco;

/**
 *
 * @author rodri
 */
public class Cliente {

    String nome;
    String tipo;
    private String PessoFisica;
    private String PessoaJuridica;
    private String numero;
    private int score;

    private ContaBancaria[] contas;

    public String getTipo() {
        return tipo;
    }

    public String setnome(String nome) {
        return nome;
    }

    public boolean soTexto(String text) {
        return text.matches("[^\\d]+");
    }

    public String setNumero(String numero) {
        return numero;
    }

    public boolean soNumero(String numeros) {
        return numeros.matches("\\d+");
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public int getScore() {
        return score;
    }

    public String getPessoFisica() {
        return PessoFisica;
    }

    public String settipo(String tipo) {
        return tipo;
    }

    public void setPessoFisica(String PessoFisica) {
        this.PessoFisica = PessoFisica;
    }

    public String getPessoaJuridica() {
        return PessoaJuridica;
    }

    public void setPessoaJuridica(String PessoaJuridica) {
        this.PessoaJuridica = PessoaJuridica;
    }

    public static String imprimeCPF(String CPF) {
        CPF = CPF.substring(0, 3) + "." +CPF.substring(3, 6) + "." +CPF.substring(6, 9) + "-" +CPF.substring(9, 11);
        return CPF;
    }

    public static String imprimeCNPJ(String CNPJ) {
        CNPJ = CNPJ.substring(0, 2) + "." +CNPJ.substring(2, 5) + "." +CNPJ.substring(5, 8) + "/" +CNPJ.substring(8, 12) + "-" +CNPJ.substring(12, 14);
        return CNPJ;
    }

    public boolean cpf(String numero) throws Exception {
        try {
            if ((numero == null)) {
                return false;
            } else if (numero.length() != 11
                    || "00000000000".equals(numero)
                    || "11111111111".equals(numero)
                    || "22222222222".equals(numero)
                    || "33333333333".equals(numero)
                    || "44444444444".equals(numero)
                    || "55555555555".equals(numero)
                    || "66666666666".equals(numero)
                    || "77777777777".equals(numero)
                    || "88888888888".equals(numero)
                    || "99999999999".equals(numero)) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
    }

    public boolean cnpj(String numero) throws Exception {
        try {
            if ((numero == null)) {
                return false;
            } else if (numero.length() != 14) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
    }
}
