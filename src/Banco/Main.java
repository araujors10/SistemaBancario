package Banco;

import static Banco.Cliente.imprimeCPF;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Cliente cadCli = new Cliente();

        System.out.println("Cadastrando novo cliente.");

        String nome = JOptionPane.showInputDialog("Entre com o nome do cliente: ").toUpperCase();

        while (!cadCli.soTexto(nome)) {
            JOptionPane.showMessageDialog(null, "Você não pode inserir números no nome.");
            nome = JOptionPane.showInputDialog("Entre com o nome do cliente: ").toUpperCase();
        }
        cadCli.setnome(nome);

        String tipo = JOptionPane.showInputDialog("Entre com o tipo de pessoa (PF ou PJ): ").toUpperCase();

        while (!cadCli.soTexto(tipo) || !tipo.equals("PF") || !tipo.equals("PJ")) {
            if (tipo.equals("PF")) {
                cadCli.settipo(tipo);
                break;
            } else if (tipo.equals("PJ")) {
                cadCli.settipo(tipo);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida, entre com os dados corretos: ");
                tipo = JOptionPane.showInputDialog("Entre com o tipo de pessoa (PF ou PJ): ").toUpperCase();
            }
        }

        String documento = JOptionPane.showInputDialog("Entre com o nº do documento: ");
        while (!cadCli.soNumero(documento) || !cadCli.cpf(documento) || !cadCli.cnpj(documento)) {

            if (tipo.equals("PF")) {
                boolean valida = cadCli.cpf(documento);
                if (valida == false) {
                    JOptionPane.showMessageDialog(null, "Erro", "CPF inválido, tente novamente!", JOptionPane.WARNING_MESSAGE);
                    documento = JOptionPane.showInputDialog("Entre com o nº do documento: ");
                } else {
                    cadCli.setNumero(documento);
                    documento = imprimeCPF(documento);
                    break;
                }
            } else if (tipo.equals("PJ")) {
//                67423152001301
                boolean valida = cadCli.cnpj(documento);
                if (valida == false) {
                    JOptionPane.showMessageDialog(null, "Erro", "CPF inválido, tente novamente!", JOptionPane.WARNING_MESSAGE);
                    documento = JOptionPane.showInputDialog("Entre com o nº do documento: ");
                } else {
                    cadCli.setNumero(documento);
                    documento = Cliente.imprimeCNPJ(documento);
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você não pode inserir letras no campo documento.");
                documento = JOptionPane.showInputDialog("Entre com o nº do documento: ");
            }
        }
        
        ContaBancaria cont = new ContaBancaria();
        ArrayList<Integer> numbers = (ArrayList<Integer>) cont.gerarNumConta();
        System.out.println("Nome do cliente.: " + nome
                + "\nTipo de pessoa.: " + tipo
                + "\nNº do documento.: " + documento
                + "\nNº da conta.: " + numbers.toString().replace("[","").replace("]","").replace(",", ""));

    }

}
