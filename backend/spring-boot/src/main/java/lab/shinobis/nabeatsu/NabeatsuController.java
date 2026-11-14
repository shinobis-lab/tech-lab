package lab.shinobis.nabeatsu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NabeatsuController {

    @GetMapping("/nabeatsu")
    public List<NabeatsuResult> nabeatsu() {
        List<NabeatsuResult> results = new ArrayList<>();

        for (int number = 1; number <= 40; number++) {
            boolean special = number % 3 == 0
                    || String.valueOf(number).contains("3");

            String message = special
                    ? "ハローナベアツ！"
                    : "こんにちは";

            results.add(new NabeatsuResult(number, special, message));
        }

        return results;
    }

    public record NabeatsuResult(
            int number,
            boolean special,
            String message
    ) {
    }
}