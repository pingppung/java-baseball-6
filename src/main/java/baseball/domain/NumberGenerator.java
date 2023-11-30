package baseball.domain;

import baseball.constants.BaseballConstants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BaseballConstants.PITCHES.value) {
            int randomNumber = Randoms.pickNumberInRange(BaseballConstants.RANDOM_MIN_NUMBER.value,
                    BaseballConstants.RANDOM_MAX_NUMBER.value);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
