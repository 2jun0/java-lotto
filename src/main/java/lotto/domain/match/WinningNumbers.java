package lotto.domain.match;

import lotto.domain.lotto.Lotto;

import java.util.List;

import static lotto.domain.lotto.Lotto.MAX_NUMBER;
import static lotto.domain.lotto.Lotto.MIN_NUMBER;

public class WinningNumbers {

    private final List<Integer> standardNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> standardNumbers, int bonusNumber) {
        validateStandardNumbers(standardNumbers);
        validateBonusNumber(bonusNumber);

        this.standardNumbers = standardNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateStandardNumbers(List<Integer> numbers) {
        if (numbers.size() != Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨번호는 6개여야 합니다.");
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("당첨번호는 중복되면 안됩니다.");
        }

        if (!numbers.stream().allMatch(
                number -> MIN_NUMBER <= number && number <= MAX_NUMBER)) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (!(MIN_NUMBER <= bonusNumber && bonusNumber <= MAX_NUMBER)) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public Reward match(Lotto lotto) {
        return Reward.find(getMatchedNumberCount(lotto), isMatchedBonus(lotto));
    }

    private int getMatchedNumberCount(Lotto lotto) {
        return (int) lotto.value().stream()
                .filter(standardNumbers::contains)
                .count();
    }

    private boolean isMatchedBonus(Lotto lotto) {
        return lotto.value().stream()
                .anyMatch(number -> number == bonusNumber);
    }
}
