package lab.shinobis.nabeatsu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class NabeatsuControllerTests {

    @Test
    void 全40件の数字とメッセージが正しいこと() {
        var controller = new NabeatsuController();
        List<NabeatsuController.NabeatsuResult> results =
                controller.nabeatsu();

        Set<Integer> specialNumbers = Set.of(
                3, 6, 9, 12, 13, 15, 18, 21, 23, 24,
                27, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39
        );

        assertEquals(40, results.size());

        for (int number = 1; number <= 40; number++) {
            var result = results.get(number - 1);
            String expectedMessage = specialNumbers.contains(number)
                    ? "オモロ～ワールド～！"
                    : "Hello World!";

            assertEquals(number, result.number());
            assertEquals(expectedMessage, result.message(),
                    "メッセージエラー: " + number);
        }
    }
}