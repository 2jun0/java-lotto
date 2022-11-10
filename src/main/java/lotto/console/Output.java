package lotto.console;

public class Output {

    public void writeLine(String line, Object ...args) {
        System.out.printf(line+"\n", args);
    }

    public void writeEmptyLine() {
        writeLine("");
    }

    public void writeEnterMoney() {
        writeLine("구입금액을 입력해 주세요.");
    }

    public void writeBuyCount(int buyCount) {
        writeLine("%d개를 구매했습니다.", buyCount);
    }

    public void writeEnterWinningNumbers() {
        writeLine("당첨 번호를 입력해 주세요.");
    }

    public void writeEnterBonusNumber() {
        writeLine("보너스 번호를 입력해 주세요.");
    }

    public void writePrefixMatchStatistics() {
        writeLine("당첨 통계");
        writeLine("---");
    }

    public void writeMatchStatistic(int match, int reward, int count) {
        writeLine("%d개 일치 (%s원) - %d개", match, OutputFormatter.formatMoney(reward), count);
    }

    public void writeYield(float yield) {
        writeLine("총 수익률은 %s입니다.", OutputFormatter.formatPercent(yield));
    }
}
