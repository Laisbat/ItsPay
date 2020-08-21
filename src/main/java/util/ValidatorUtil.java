package util;

import java.util.Calendar;
import java.util.InputMismatchException;

public class ValidatorUtil {
    public static boolean verificarCpf(String cpf) {
        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static boolean verificarCNPJ(String CNPJ) {
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
                CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
                CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
                CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
                CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
                (CNPJ.length() != 14))
            return(false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
                num = (int)(CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else dig13 = (char)((11-r) + 48);

            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(CNPJ.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char)((11-r) + 48);

            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String getMesExtenso(String mes) {
        switch (mes) {
            case "01":
                return "Janeiro";
            case "02":
                return "Fevereiro";
            case "03":
                return "Março";
            case "04":
                return "Abril";
            case "05":
                return "Maio";
            case "06":
                return "Junho";
            case "07":
                return "Julho";
            case "08":
                return "Agosto";
            case "09":
                return "Setembro";
            case "10":
                return "Outubro";
            case "11":
                return "Novembro";
            case "12":
                return "Dezembro";
        }
        return "";
    }

}
