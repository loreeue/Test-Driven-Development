package es.codeurjc.test.ejem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PiratesURJCTest {
    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "1M 4M, Gana jugador 2",
            "5M 2M, Gana jugador 1",
            "1M 2M 4M, Gana jugador 3",
            "5M 2M 4M 7M, Gana jugador 4",
            "1M 4A 2M 7V, Gana jugador 3",
            "2A 7V 4V 1A, Gana jugador 1",
            "7V 9M 1M 8V, Gana jugador 4",
            "2V 6M 3N 8V, Gana jugador 3",
            "2V 7V 4V 1N, Gana jugador 4",
            "7M 4N 1N 8V, Gana jugador 2",
            "2V 6M 3N SR, Gana jugador 4",
            "2V SR 4V 1N, Gana jugador 2",
            "7M SR SR 8V, Gana jugador 3",
            "2V PR 3N 1N, Gana jugador 2",
            "8A PR 1N PR, Gana jugador 4",
            "9V PR 4V SR, Gana jugador 2",
            "SR SR PR SR, Gana jugador 3",
            "7N 8A 1V SK, Gana jugador 4",
            "2V PR SK 1N, Gana jugador 3",
            "1N SK 4V SR, Gana jugador 2",
            "PR SK SR SR, Gana jugador 3",
            "1V KK SR, Gana jugador 1",
            "5A PR KK, Gana jugador 1",
            "7M SK KK, Gana jugador 1",
            "KK SK 5A SR, Gana jugador 3",
            "PR KK SR PR, Gana jugador 2",
            "1A 1V BB 2V, Gana jugador 4",
            "1A 8V BB 2N, Gana jugador 2",
            "2A 1V BB 2N, Gana jugador 3",
            "1A 8N BB SR, Gana jugador 2",
            "2N BB PR 9V, Gana jugador 4",
            "1N SK BB, Gana jugador 1",
            "SR BB KK 8V 1N SK PR, Gana jugador 5",
            "6A KK BB SR, Gana jugador 4",
            "KK SK BB, Gana jugador 2",
            "PR KK BB 7M, Gana jugador 1",
            //EJEMPLOS EXTRA
            "SR BB 8V KK 1N SK PR, Gana jugador 5",
            "7M 1N 4N 8V, Gana jugador 3"
    })
    public void test(String entrada, String salida) {
        // Given
        PiratesURJC game = new PiratesURJC();
        // When
        String result = game.play(entrada);
        // Then
        assertEquals(salida, result);
    }
}