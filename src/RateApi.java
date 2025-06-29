import java.util.Map;

public record RateApi(
        Map<String, Double> conversion_rates
) {
}
