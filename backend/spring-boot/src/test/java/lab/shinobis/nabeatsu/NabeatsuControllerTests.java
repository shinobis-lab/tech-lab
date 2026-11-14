package lab.shinobis.nabeatsu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class NabeatsuControllerTests {

    @Test
    void 全40件の判定結果が正しいこと() {
        NabeatsuController controller = new NabeatsuController();

        List<NabeatsuController.NabeatsuResult> results =
                controller.nabeatsu();

        assertEquals(40, results.size());

        for (int i = 1; i <= 40; i++) {
            NabeatsuController.NabeatsuResult result = results.get(i - 1);

            boolean expected = i % 3 == 0
                    || String.valueOf(i).contains("3");

            assertEquals(i, result.number());
            assertEquals(expected, result.special(),
                    "判定エラー: " + i);

            assertEquals(
                    expected ? "ハローナベアツ！" : "こんにちは",
                    result.message(),
                    "メッセージエラー: " + i
            );
        }
    }
}