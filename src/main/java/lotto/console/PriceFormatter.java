package lotto.console;

public class PriceFormatter {

    public static String formatMoney(int money) {
        return String.format(String.valueOf(money), "%,.2f", money);
    }
}