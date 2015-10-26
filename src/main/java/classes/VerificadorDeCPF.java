package classes;

public class VerificadorDeCPF {

    private final String cpf;

    public VerificadorDeCPF(String cpf) {
        this.cpf = cpf;
    }

    public int retornaNumero(char c) {
        if (c == '1') {
            return 1;
        }
        if (c == '2') {
            return 2;
        }
        if (c == '3') {
            return 3;
        }
        if (c == '4') {
            return 4;
        }
        if (c == '5') {
            return 5;
        }
        if (c == '6') {
            return 6;
        }
        if (c == '7') {
            return 7;
        }
        if (c == '8') {
            return 8;
        }
        if (c == '9') {
            return 9;
        }
        return 0;
    }

    public boolean verificarPrimeiroDigito() {
        int soma = 0;
        int cont = 10;
        for (int i = 0; i < 11; i++) {
            if ((i != 3) && (i != 7)) {
                soma += cont-- * retornaNumero(cpf.charAt(i));
            }
        }

        int resto = soma % 11;

        int primeiroDigito;
        
        if (resto < 2) {
            primeiroDigito = 0;
        } else {
            primeiroDigito = 11 - resto;
        }

        return primeiroDigito == retornaNumero(cpf.charAt(12));
    }

    public boolean verificarSegundoDigito() {
        int soma = 0;
        int cont = 11;
        for (int i = 0; i < 13; i++) {
            if ((i != 3) && (i != 7) && (i != 11)) {
                soma += cont-- * retornaNumero(cpf.charAt(i));
            }
        }

        int resto = soma % 11;

        int segundoDigito;

        if (resto < 2) {
            segundoDigito = 0;
        } else {
            segundoDigito = 11 - resto;
        }

        return segundoDigito == retornaNumero(cpf.charAt(13));
    }
}