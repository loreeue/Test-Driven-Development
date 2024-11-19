## Test Driven Development (TDD) - PiratesURJC

Este proyecto forma parte de la asignatura **Ampliación de Ingeniería del Software** del Grado en Ingeniería Informática. Su objetivo es implementar el juego **PiratesURJC** utilizando la metodología **Test Driven Development (TDD)**.

### Descripción del Proyecto

**PiratesURJC** es un juego para varios jugadores en el que cada participante juega una carta. Basándose en diferentes reglas, se determina un ganador. La práctica sigue estrictamente los pasos de TDD: escribir tests antes de implementar las funcionalidades, garantizar que fallan, implementar la solución mínima y finalmente refactorizar el código.

### Reglas del Juego

#### Ejemplos Simples (R1 - R3):
- **R1:** Gana la carta con el valor más alto.
- **R2:** Gana la carta más alta del color marcado por el jugador 1.
- **R3:** Las cartas negras (N) tienen prioridad sobre el color marcado por el jugador 1.

#### Ejemplos Avanzados (R4 - R19):
- **R4:** La carta Sirena (SR) gana a todas las cartas numeradas.
- **R8:** Si una carta Pirata (PR) y una Sirena aparecen juntas, gana el Pirata.
- **R9:** La carta Skull King (SK) gana a todas las cartas del juego.
- **R11:** La carta Kraken (KK) anula los efectos de las cartas figura.
- **R13:** La Ballena Blanca (BB) introduce reglas específicas, como cambios en el valor de cartas.

### Metodología TDD

1. **Escribir un test:**
   - Basándose en los ejemplos proporcionados (R1 - R19).
2. **Comprobar que el test falla:**
   - Esto asegura que la funcionalidad aún no está implementada.
3. **Implementar la solución mínima:**
   - Solo el código necesario para hacer que el test pase.
4. **Refactorizar:**
   - Mejorar el código eliminando duplicados y asegurando calidad.
5. **Repetir:**
   - Continuar con el siguiente ejemplo.

### Requisitos

- **Ciclos TDD:** Cada funcionalidad debe seguir estrictamente los pasos de TDD.
- **Calidad del código:**
  - Refactorización obligatoria.
  - Código en inglés y bien formateado.
- **Entrega:** Incluir una memoria que documente cada ciclo TDD.

### Tecnologías Utilizadas

- **Java** para la implementación.
- **JUnit 5** para los tests.
- **Maven** como herramienta de construcción.

### Cómo Ejecutarlo

1. **Ejecutar los tests:**
   ```bash
   mvn test
   ```
2. **Ver resultados:**
   - Asegúrate de que todos los tests pasan tras cada refactorización.

## Entrega

### Ejemplo 1

**INPUT y OUTPUT**: "1M 4M" - "Gana jugador 2"

**EJ1. Código de test**
```java
//"1M 4M" - "Gana jugador 2"
@Test
@DisplayName("1M 4M -> Gana jugador 2")
public void test1() {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play("1M 4M");
    // Then
    assertEquals("Gana jugador 2", result);
}
```

**EJ1. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 2> but was: <null>
```

**EJ1. Código mínimo para que el test pase**

Se devuelve directamente aquello que hace pasar el test.

```java
public String play(String ronda){
    return "Gana jugador 2";
}
```

**EJ1. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo1.1.png "Pasa")

**EJ1. Refactorización**

En esta refactorización he cambiado el nombre de la variable al inglés.

```java
public String play(String round){
    return "Gana jugador 2";
}
```
**EJ1. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo1.2.png "Pasa")

### Ejemplo 2

**INPUT y OUTPUT**: "5M 2M" - "Gana jugador 1"

**EJ2. Código de test**
```java
//"5M 2M" - "Gana jugador 1"
@Test
@DisplayName("5M 2M -> Gana jugador 1")
public void test2() {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play("5M 2M");
    // Then
    assertEquals("Gana jugador 1", result);
}
```

**EJ2. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 1> but was: <Gana jugador 2>
```

**EJ2. Código mínimo para que el test pase**

Se obtienen los dos enteros de las dos cartas y se comparan. Dependiendo de cuál sea mayor, se devuelve un mensaje u otro.

```java
public String play(String round){
    String[] cards = round.split(" ");
    int player1 = Character.getNumericValue(cards[0].charAt(0));
    int player2 = Character.getNumericValue(cards[1].charAt(0));
    if (player1 > player2) {
        return "Gana jugador 1";
    }
    return "Gana jugador 2";
}
```

**EJ2. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo2.1.png "Pasa")

**EJ2. Refactorización**

En esta refactorización he cambiado únicamente el nombre de las variables.

```java
public String play(String round){
    String[] cards = round.split(" ");
    int valueCardPlayer1 = Character.getNumericValue(cards[0].charAt(0));
    int valueCardPlayer2 = Character.getNumericValue(cards[1].charAt(0));
    if (valueCardPlayer1 > valueCardPlayer2) {
        return "Gana jugador 1";
    }
    return "Gana jugador 2";
}
```
**EJ2. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo2.2.png "Pasa")

### Ejemplo 3

**INPUT y OUTPUT**: "1M 2M 4M" - "Gana jugador 3"

**EJ3. Código de test**
```java
//"1M 2M 4M" - "Gana jugador 3"
@Test
@DisplayName("1M 2M 4M -> Gana jugador 3")
public void test3() {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play("1M 2M 4M");
    // Then
    assertEquals("Gana jugador 3", result);
}
```

**EJ3. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 3> but was: <Gana jugador 2>
```

**EJ3. Código mínimo para que el test pase**

Si el número de jugadores es 2, se obtienen los dos enteros de las dos cartas y se comparan. En caso contrario, se obtiene el entero de la carta del tercer jugador y se compara con el resto. Dependiendo de cuál sea mayor, se devuelve un mensaje u otro.

```java
public String play(String round){
    String[] cards = round.split(" ");
    int valueCardPlayer1 = Character.getNumericValue(cards[0].charAt(0));
    int valueCardPlayer2 = Character.getNumericValue(cards[1].charAt(0));
    if (cards.length == 2) {
        if (valueCardPlayer1 > valueCardPlayer2) {
            return "Gana jugador 1";
        }
        return "Gana jugador 2";
    } else {
        int valueCardPlayer3 = Character.getNumericValue(cards[2].charAt(0));
        if (valueCardPlayer1 > valueCardPlayer2 && valueCardPlayer1 > valueCardPlayer3) {
            return "Gana jugador 1";
        } else if (valueCardPlayer2 > valueCardPlayer1 && valueCardPlayer2 > valueCardPlayer3) {
            return "Gana jugador 2";
        }
        return "Gana jugador 3";
    }
}
```

**EJ3. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo3.1.png "Pasa")

**EJ3. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 4

**INPUT y OUTPUT**: "5M 2M 4M 7M" - "Gana jugador 4"

**EJ4. Código de test**
```java
//"5M 2M 4M 7M" - "Gana jugador 4"
@Test
@DisplayName("5M 2M 4M 7M -> Gana jugador 4")
public void test4() {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play("5M 2M 4M 7M");
    // Then
    assertEquals("Gana jugador 4", result);
}
```

**EJ4. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 4> but was: <Gana jugador 1>
```

**EJ4. Código mínimo para que el test pase**

Si el número de jugadores es 2, se obtienen los dos enteros de las dos cartas y se comparan. Si el número de jugadores es 3, se obtienen los tres enteros de las tres cartas y se comparan. En caso contrario, se obtiene el entero de la carta del tercer y cuarto jugador y se comparan con el resto. Dependiendo de cuál sea mayor, se devuelve un mensaje u otro.

```java
public String play(String round){
    String[] cards = round.split(" ");
    int valueCardPlayer1 = Character.getNumericValue(cards[0].charAt(0));
    int valueCardPlayer2 = Character.getNumericValue(cards[1].charAt(0));
    if (cards.length == 2) {
        if (valueCardPlayer1 > valueCardPlayer2) {
            return "Gana jugador 1";
        }
        return "Gana jugador 2";
    } else if (cards.length == 3) {
        int valueCardPlayer3 = Character.getNumericValue(cards[2].charAt(0));
        if (valueCardPlayer1 > valueCardPlayer2 && valueCardPlayer1 > valueCardPlayer3) {
            return "Gana jugador 1";
        } else if (valueCardPlayer2 > valueCardPlayer1 && valueCardPlayer2 > valueCardPlayer3) {
            return "Gana jugador 2";
        }
        return "Gana jugador 3";
    } else {
        int valueCardPlayer3 = Character.getNumericValue(cards[2].charAt(0));
        int valueCardPlayer4 = Character.getNumericValue(cards[3].charAt(0));
        if (valueCardPlayer1 > valueCardPlayer2 && valueCardPlayer1 > valueCardPlayer3 && valueCardPlayer1 > valueCardPlayer4) {
            return "Gana jugador 1";
        } else if (valueCardPlayer2 > valueCardPlayer1 && valueCardPlayer2 > valueCardPlayer3 && valueCardPlayer2 > valueCardPlayer4) {
            return "Gana jugador 2";
        } else if (valueCardPlayer3 > valueCardPlayer1 && valueCardPlayer3 > valueCardPlayer2 && valueCardPlayer3 > valueCardPlayer4) {
            return "Gana jugador 3";
        }
        return "Gana jugador 4";
    }
}
```

**EJ4. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo4.1.png "Pasa")

**EJ4. Refactorización**

En esta refactorización he generalizado el código sustituyendo todos los if/else por un único for. Simplemente el for recorre todas las cartas, las compara y se va quedando con las de mayor valor.

```java
public String play(String round){
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    for (int i = 0; i < cards.length; i++) {
        int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
        if (playerCardValue > biggestCardValue) {
            biggestCardValue = playerCardValue;
            currentWinner = i;
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```
**EJ4. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo4.2.png "Pasa")

**EJ4. Refactorización de los tests**

En la refactorización de los tests he sustituido todos los tests anteriores por un "parametrized test".

```java
@ParameterizedTest(name = "{0} -> {1}")
@CsvSource({
    "1M 4M, Gana jugador 2",
    "5M 2M, Gana jugador 1",
    "1M 2M 4M, Gana jugador 3",
    "5M 2M 4M 7M, Gana jugador 4"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
    assertEquals(salida, result);
}
```
**EJ4. Captura de que TODOS los tests PASAN tras la refactorización de los tests**

![Pasa](capturas/Ejemplo4.3.png "Pasa")

### Ejemplo 5

**INPUT y OUTPUT**: "1M 4A 2M 7V" - "Gana jugador 3"

**EJ5. Código de test**

He refactorizado los tests en el ejemplo anterior.

```java
@ParameterizedTest(name = "{0} -> {1}")
@CsvSource({
    "1M 4M, Gana jugador 2",
    "5M 2M, Gana jugador 1",
    "1M 2M 4M, Gana jugador 3",
    "5M 2M 4M 7M, Gana jugador 4",
    "1M 4A 2M 7V, Gana jugador 3"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
    assertEquals(salida, result);
}
```

**EJ5. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 3> but was: <Gana jugador 4>
```

**EJ5. Código mínimo para que el test pase**

He creado una nueva variable, que es la letra de la carta del primer jugador. Y esta la voy comparando con la letra del siguiente jugador. Si las letras son distintas, devolvemos el mensaje esperado.

```java
public String play(String round){
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    for (int i = 1; i < cards.length - 1; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (firstLetter != playerCardLetter) {
            return "Gana jugador 3";
        }
    }
    for (int i = 0; i < cards.length; i++) {
        int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
        if (playerCardValue > biggestCardValue) {
            biggestCardValue = playerCardValue;
            currentWinner = i;
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ5. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo5.1.png "Pasa")

**EJ5. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 6

**INPUT y OUTPUT**: "2A 7V 4V 1A" - "Gana jugador 1"

**EJ6. Código de test**
```java
@ParameterizedTest(name = "{0} -> {1}")
@CsvSource({
    "1M 4M, Gana jugador 2",
    "5M 2M, Gana jugador 1",
    "1M 2M 4M, Gana jugador 3",
    "5M 2M 4M 7M, Gana jugador 4",
    "1M 4A 2M 7V, Gana jugador 3",
    "2A 7V 4V 1A, Gana jugador 1"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
    assertEquals(salida, result);
}
```

**EJ6. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 1> but was: <Gana jugador 3>
```

**EJ6. Código mínimo para que el test pase**

Este ejemplo lo he implementado de la siguiente forma. Primero he hecho un for que pone un valor de "0" a las posiciones del array de cartas que tengan distinta letra a la letra del primer jugador. Y, en el siguiente for, recorro el array sin las posiciones donde está el "0". Después, se hace lo mismo de antes, es decir, se compara y se devuelve el ganador.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    for (int i = 1; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (firstLetter != playerCardLetter) {
            cards[i] = "0";
        }
    }

    for (int i = 0; i < cards.length; i++) {
        if (!cards[i].equals("0")) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ6. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo6.1.png "Pasa")

**EJ6. Refactorización**

En esta refactorización he generalizado el código utilizando un único for para recorrer las cartas una única vez. Simplemente comparo los valores de las cartas si su letra es la misma a la letra de la primera carta.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for(int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ6. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo6.2.png "Pasa")

### Ejemplo 7

**INPUT y OUTPUT**: "7V 9M 1M 8V" - "Gana jugador 4"

**EJ7. Código de test**
```java
@ParameterizedTest(name = "{0} -> {1}")
@CsvSource({
    "1M 4M, Gana jugador 2",
    "5M 2M, Gana jugador 1",
    "1M 2M 4M, Gana jugador 3",
    "5M 2M 4M 7M, Gana jugador 4",
    "1M 4A 2M 7V, Gana jugador 3",
    "2A 7V 4V 1A, Gana jugador 1",
    "7V 9M 1M 8V, Gana jugador 4"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
    assertEquals(salida, result);
}
```

**EJ7. Mensaje del test añadido que NO PASA**

```log
En este ejemplo los tests pasan, ya que he refactorizado en el anterior ejemplo para hacer un código más general y eliminar uno de los bucles for.
```

**EJ7. Código mínimo para que el test pase**

No he añadido código a este ejemplo, ya que los tests pasan.

**EJ7. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo7.1.png "Pasa")

**EJ7. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 8

**INPUT y OUTPUT**: "2V 6M 3N 8V" - "Gana jugador 3"

**EJ8. Código de test**
```java
@ParameterizedTest(name = "{0} -> {1}")
@CsvSource({
    "1M 4M, Gana jugador 2",
    "5M 2M, Gana jugador 1",
    "1M 2M 4M, Gana jugador 3",
    "5M 2M 4M 7M, Gana jugador 4",
    "1M 4A 2M 7V, Gana jugador 3",
    "2A 7V 4V 1A, Gana jugador 1",
    "7V 9M 1M 8V, Gana jugador 4",
    "2V 6M 3N 8V, Gana jugador 3"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
    assertEquals(salida, result);
}
```

**EJ8. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 3> but was: <Gana jugador 4>
```

**EJ8. Código mínimo para que el test pase**

Lo único que he añadido para que este test pase ha sido el if donde si el jugador 3 tiene una carta con la letra N, devuelve directamente ese jugador como ganador.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards.length == 4 && 'N' == cards[2].charAt(1)) {
        return "Gana jugador 3";
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ8. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo8.1.png "Pasa")

**EJ8. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 9

**INPUT y OUTPUT**: "2V 7V 4V 1N" - "Gana jugador 4"

**EJ9. Código de test**
```java
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
    "2V 7V 4V 1N, Gana jugador 4"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
    assertEquals(salida, result);
}
```

**EJ9. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 4> but was: <Gana jugador 2>
```

**EJ9. Código mínimo para que el test pase**

Lo único que he añadido para que este test pase ha sido el if donde si el jugador 4 tiene una carta con la letra N, devuelve directamente ese jugador como ganador.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards.length == 4 && 'N' == cards[2].charAt(1)) {
        return "Gana jugador 3";
    }
    if (cards.length == 4 && 'N' == cards[3].charAt(1)) {
        return "Gana jugador 4";
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ9. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo9.1.png "Pasa")

**EJ9. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omitimos.

### Ejemplo 10

**INPUT y OUTPUT**: "7M 4N 1N 8V" - "Gana jugador 2"

**EJ10. Código de test**
```java
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
    "7M 4N 1N 8V, Gana jugador 2"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
    assertEquals(salida, result);
}
```

**EJ10. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 2> but was: <Gana jugador 3>
```

**EJ10. Código mínimo para que el test pase**

Lo único que he añadido para que este test pase ha sido el if donde si el jugador 2 tiene una carta con la letra N, devuelve directamente ese jugador como ganador.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards.length == 4 && 'N' == cards[1].charAt(1)) {
        return "Gana jugador 2";
    }
    if (cards.length == 4 && 'N' == cards[2].charAt(1)) {
        return "Gana jugador 3";
    }
    if (cards.length == 4 && 'N' == cards[3].charAt(1)) {
        return "Gana jugador 4";
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ10. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo10.1.png "Pasa")

**EJ10. Refactorización 1**

En esta refactorización devuelvo directamente el primer jugador que tenga la carta N.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (playerCardLetter == 'N') {
            return "Gana jugador " + (i + 1);
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ10. Captura de que TODOS los tests PASAN tras la refactorización 1**

![Pasa](capturas/Ejemplo10.2.png "Pasa")

**EJ10. Refactorización 2**

En esta refactorización he cambiado el tratamiento de las cartas con letra 'N', transformando la carta a un valor de "10" para poder seguir evaluando las cartas.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ10. Captura de que TODOS los tests PASAN tras la refactorización 2**

![Pasa](capturas/Ejemplo10.3.png "Pasa")

### Ejemplo 11

**INPUT y OUTPUT**: "2V 6M 3N SR" - "Gana jugador 4"

**EJ11. Código de test**
```java
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
    "2V 6M 3N SR, Gana jugador 4"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
     assertEquals(salida, result);
}
```

**EJ11. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 4> but was: <Gana jugador 3>
```

**EJ11. Código mínimo para que el test pase**

Aquello que he añadido para que el código pase es un if antes del anterior for. Solo entra en este if si hay 4 jugadores. En ese caso, mira si tiene la carta "SR" en la posición 3.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards.length == 4) {
        if (cards[3].charAt(0) == 'S' && cards[3].charAt(1) == 'R') {
            return "Gana jugador " + 4;
        }
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ11. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo11.1.png "Pasa")

**EJ11. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 12

**INPUT y OUTPUT**: "2V SR 4V 1N" - "Gana jugador 2"

**EJ12. Código de test**
```java
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
    "2V SR 4V 1N, Gana jugador 2"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
     assertEquals(salida, result);
}
```

**EJ12. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 2> but was: <Gana jugador 4>
```

**EJ12. Código mínimo para que el test pase**

Para que este test pase, he añadido un if dentro del primer if. Solo entra en este if si hay 4 jugadores. En ese caso, mira si tiene la carta "SR" en la posición 3 o en la posisión 1. Esta última opción forma parte de este último caso.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards.length == 4) {
        if (cards[3].charAt(0) == 'S' && cards[3].charAt(1) == 'R') {
            return "Gana jugador " + 4;
        }
        if (cards[1].charAt(0) == 'S' && cards[1].charAt(1) == 'R') {
            return "Gana jugador " + 2;
        }
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ12. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo12.1.png "Pasa")

**EJ12. Refactorización**

En esta refactorización he eliminado la verificación inicial de si la longitud de las cartas es igual a 4 y he simplificado la lógica para manejar las cartas con letras "SR" cambiándolas al valor "11" inmediatamente.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCard2 = cards[i].charAt(1);
        char playerCard1 = cards[i].charAt(0);
        if (playerCard1 == 'S' && playerCard2 == 'R') {
            cards[i] = "11";
        }
        if (playerCard2 == 'N') {
            cards[i] = "10";
        }
        if ("10".equals(cards[i]) || "11".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCard2 == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ12. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo12.2.png "Pasa")

### Ejemplo 13

**INPUT y OUTPUT**: "7M SR SR 8V" - "Gana jugador 3"

**EJ13. Código de test**
```java
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
    "7M SR SR 8V, Gana jugador 3"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
     assertEquals(salida, result);
}
```

**EJ13. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 3> but was: <Gana jugador 2>
```

**EJ13. Código mínimo para que el test pase**

Lo que he hecho para que este test pase ha sido añadir una nueva condición en uno de los ifs. Para que actualice el valor ganador si hay dos jugadores que tienen la carta SR o valor 11 (el valor que he puesto).

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCard2 = cards[i].charAt(1);
        char playerCard1 = cards[i].charAt(0);
        if (playerCard1 == 'S' && playerCard2 == 'R') {
            cards[i] = "11";
        }
        if (playerCard2 == 'N') {
            cards[i] = "10";
        }
        if ("10".equals(cards[i]) || "11".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || (playerCardValue == 11 && biggestCardValue == 11)) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCard2 == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ13. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo13.1.png "Pasa")

**EJ13. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 14

**INPUT y OUTPUT**: "2V PR 3N 1N" - "Gana jugador 2"

**EJ14. Código de test**
```java
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
    "2V PR 3N 1N, Gana jugador 2"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
     assertEquals(salida, result);
}
```

**EJ14. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 2> but was: <Gana jugador 3>
```

**EJ14. Código mínimo para que el test pase**

Para que este test pase, he añadido un if antes del for. Entra a este if si hay 4 jugadores y si se encuentra la carta PR en la posición 1 del array de cartas. En ese caso, se devuelve el mensaje esperado.

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards.length == 4) {
        if (cards[1].charAt(0) == 'P' && cards[1].charAt(1) == 'R') {
            return "Gana jugador " + 2;
        }
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCard2 = cards[i].charAt(1);
        char playerCard1 = cards[i].charAt(0);
        if (playerCard1 == 'S' && playerCard2 == 'R') {
            cards[i] = "11";
        }
        if (playerCard2 == 'N') {
            cards[i] = "10";
        }
        if ("10".equals(cards[i]) || "11".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || (playerCardValue == 11 && biggestCardValue == 11)) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCard2 == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ14. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo14.1.png "Pasa")

**EJ14. Refactorización**

En esta refactorización he eliminado la verificación inicial que dependía de que las cartas sean 4 y que la carta en la posición 1 tenga las letras "PR". Ahora verifico si la carta tiene las letras "PR" en cualquier posición y convierto cualquier carta que tenga las letras "PR" o "SR" en el valor "11".

```java
public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCard2 = cards[i].charAt(1);
        char playerCard1 = cards[i].charAt(0);
        if ((playerCard1 == 'S' && playerCard2 == 'R') || (playerCard1 == 'P' && playerCard2 == 'R')) {
            cards[i] = "11";
        }
        if (playerCard2 == 'N') {
            cards[i] = "10";
        }
        if ("10".equals(cards[i]) || "11".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || (playerCardValue == 11 && biggestCardValue == 11)) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCard2 == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}
```

**EJ14. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo14.2.png "Pasa")

### Ejemplo 15

**INPUT y OUTPUT**: "8A PR 1N PR" - "Gana jugador 4"

**EJ15. Código de test**
```java
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
    "8A PR 1N PR, Gana jugador 4"
})
public void test(String entrada, String salida) {
    // Given
    PiratesURJC game = new PiratesURJC();
    // When
    String result = game.play(entrada);
    // Then
     assertEquals(salida, result);
}
```

**EJ15. Mensaje del test añadido que NO PASA**

```log
En este caso los tests pasan, ya que hemos tratado de igual forma la carta SR y la carta PR. Y, antes, hemos añadido la funcionalidad para que si hay varias cartas SR gane la última. Este ejemplo nos dice que ocurre lo mismo pero con la carta PR.
```

**EJ15. Código mínimo para que el test pase**

No he añadido código mínimo, ya que la funcionalidad ya está cubierta.

**EJ15. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo15.1.png "Pasa")

**EJ15. Refactorización**

En esta refactorización he pasado a utilizar una lista SPECIAL_CARDS para identificar cartas especiales. Esta lista se define en la parte superior como un array de cadenas (String[]) con los valores "SR" y "PR". Además, he creado método privado llamado isSpecialCard, que devuelve true si la carta está en la lista SPECIAL_CARDS y false en caso contrario.

```java
private static String[] SPECIAL_CARDS = { "SR", "PR" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (isSpecialCard(cards[i])) {
            cards[i] = "11";
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("10".equals(cards[i]) || "11".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || (playerCardValue == 11 && biggestCardValue == 11)) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (String specialCard : SPECIAL_CARDS) {
        if (card.equals(specialCard)) {
            return true;
        }
    }
    return false;
}
```

**EJ15. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo15.2.png "Pasa")

### Ejemplo 16

**INPUT y OUTPUT**: "9V PR 4V SR" - "Gana jugador 2"

**EJ16. Código de test**

A partir de este ejemplo, en los tests solo voy a añadir la línea que cambia en el Parametrized Test. El resto de código es el mismo.

```java
"9V PR 4V SR, Gana jugador 2"
```

**EJ16. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 2> but was: <Gana jugador 4>
```

**EJ16. Código mínimo para que el test pase**

Para que este test pase, he añadido un if. Entra en este if si hay 4 jugadores. Además, dentro hay otro if, al cual entra si el jugador 2 tiene la carta PR y el jugador 4 tiene la carta SR.

```java
private static String[] SPECIAL_CARDS = { "SR", "PR" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards.length == 4) {
        if (cards[1].charAt(0) == 'P' && cards[1].charAt(1) == 'R' && cards[3].charAt(0) == 'S'
                && cards[3].charAt(1) == 'R') {
            return "Gana jugador 2";
        }
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (isSpecialCard(cards[i])) {
            cards[i] = "11";
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("10".equals(cards[i]) || "11".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || (playerCardValue == 11 && biggestCardValue == 11)) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (String specialCard : SPECIAL_CARDS) {
        if (card.equals(specialCard)) {
            return true;
        }
    }
    return false;
}
```

**EJ16. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo16.1.png "Pasa")

**EJ16. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 16B

**INPUT y OUTPUT**: "SR SR PR SR" - "Gana jugador 3"

**EJ16B. Código de test**

```java
"SR SR PR SR, Gana jugador 3"
```

**EJ16B. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 3> but was: <Gana jugador 4>
```

**EJ16B. Código mínimo para que el test pase**

En el primer if que he creado en el anterior ejemplo, he añadido un for que recorre las cartas de todos los jugadores. Si encuentra un jugador con la carta SR y otro con la carta PR, devuelve como ganador el jugador que tiene la carta PR.

```java
private static String[] SPECIAL_CARDS = { "SR", "PR" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean foundSR = false, foundPR = false;

    if (cards.length == 4) {
        if (cards[1].charAt(0) == 'P' && cards[1].charAt(1) == 'R' && cards[3].charAt(0) == 'S'
                && cards[3].charAt(1) == 'R') {
            return "Gana jugador 2";
        }
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].charAt(0) == 'S' && cards[i].charAt(1) == 'R') {
                foundSR = true;
            }
            if (cards[i].charAt(0) == 'P' && cards[i].charAt(1) == 'R') {
                currentWinner = i;
                foundPR = true;
            }
            if (foundSR && foundPR) {
                return "Gana jugador " + (currentWinner + 1);
            }
        }
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (isSpecialCard(cards[i])) {
            cards[i] = "11";
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("10".equals(cards[i]) || "11".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || (playerCardValue == 11 && biggestCardValue == 11)) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (String specialCard : SPECIAL_CARDS) {
        if (card.equals(specialCard)) {
            return true;
        }
    }
    return false;
}
```

**EJ16B. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo16B.1.png "Pasa")

**EJ16B. Refactorización**

En esta refactorización he introducido una mayor distinción entre las cartas especiales "SR" y "PR", asignando valores diferentes a cada una, es decir, asignando a la carta "PR" un valor mayor, para que gane a la carta "SR".

```java
private static String[] SPECIAL_CARDS = { "SR", "PR" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (isSpecialCard(cards[i])) {
            if (cards[i].equals("SR")) { // is SR
                cards[i] = "11";
            } else { // is PR
                cards[i] = "12";
            }
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("11".equals(cards[i]) || "12".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (String specialCard : SPECIAL_CARDS) {
        if (card.equals(specialCard)) {
            return true;
        }
    }
    return false;
}
```

**EJ16B. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo16B.2.png "Pasa")

### Ejemplo 17

**INPUT y OUTPUT**: "7N 8A 1V SK" - "Gana jugador 4"

**EJ17. Código de test**

```java
"7N 8A 1V SK, Gana jugador 4"
```

**EJ17. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 4> but was: <Gana jugador 1>
```

**EJ17. Código mínimo para que el test pase**

He creado un if. Entra en este if si hay 4 jugadores. En ese caso, si el jugador 4 tiene la carta SK, devuelve a ese jugador como ganador.

```java
private static String[] SPECIAL_CARDS = { "SR", "PR" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards.length == 4) {
        if (cards[3].charAt(0) == 'S' && cards[3].charAt(1) == 'K') {
            return "Gana jugador 4";
        }
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (isSpecialCard(cards[i])) {
            if (cards[i].equals("SR")) { // is SR
                cards[i] = "11";
            } else { // is PR
                cards[i] = "12";
            }
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("11".equals(cards[i]) || "12".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (String specialCard : SPECIAL_CARDS) {
        if (card.equals(specialCard)) {
            return true;
        }
    }
    return false;
}
```

**EJ17. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo17.1.png "Pasa")

**EJ17. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 18

**INPUT y OUTPUT**: "2V PR SK 1N" - "Gana jugador 3"

**EJ18. Código de test**

```java
"2V PR SK 1N, Gana jugador 3"
```

**EJ18. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 3> but was: <Gana jugador 2>
```

**EJ18. Código mínimo para que el test pase**

En el if que he creado en el ejemplo anterior, he creado dentro otro if, donde entra si el jugador 3 tiene la carta SK. En este caso, devuelve a ese jugador como ganador.

```java
private static String[] SPECIAL_CARDS = { "SR", "PR" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards.length == 4) {
        if (cards[3].charAt(0) == 'S' && cards[3].charAt(1) == 'K') {
            return "Gana jugador 4";
        }
        if (cards[2].charAt(0) == 'S' && cards[2].charAt(1) == 'K') {
            return "Gana jugador 3";
        }
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (isSpecialCard(cards[i])) {
            if (cards[i].equals("SR")) { // is SR
                cards[i] = "11";
            } else { // is PR
                cards[i] = "12";
            }
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("11".equals(cards[i]) || "12".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (String specialCard : SPECIAL_CARDS) {
        if (card.equals(specialCard)) {
            return true;
        }
    }
    return false;
}
```

**EJ18. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo18.1.png "Pasa")

**EJ18. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 19

**INPUT y OUTPUT**: "1N SK 4V SR" - "Gana jugador 2"

**EJ19. Código de test**

```java
"1N SK 4V SR, Gana jugador 2"
```

**EJ19. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 2> but was: <Gana jugador 4>
```

**EJ19. Código mínimo para que el test pase**

En el if que he creado en el ejemplo anterior, he creado dentro otro if, donde entra si el jugador 2 tiene la carta SK. En este caso, devuelve a ese jugador como ganador.

```java
private static String[] SPECIAL_CARDS = { "SR", "PR" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards.length == 4) {
        if (cards[3].charAt(0) == 'S' && cards[3].charAt(1) == 'K') {
            return "Gana jugador 4";
        }
        if (cards[2].charAt(0) == 'S' && cards[2].charAt(1) == 'K') {
            return "Gana jugador 3";
        }
        if (cards[1].charAt(0) == 'S' && cards[1].charAt(1) == 'K') {
            return "Gana jugador 2";
        }
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (isSpecialCard(cards[i])) {
            if (cards[i].equals("SR")) { // is SR
                cards[i] = "11";
            } else { // is PR
                cards[i] = "12";
            }
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("11".equals(cards[i]) || "12".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (String specialCard : SPECIAL_CARDS) {
        if (card.equals(specialCard)) {
            return true;
        }
    }
    return false;
}
```

**EJ19. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo19.1.png "Pasa")

**EJ19. Refactorización 1**

En esta refactorización, si se encuentra una carta especial "SK", se asigna un valor de "13" a la carta. Además, el valor de biggestCardValue se actualiza a 13, y currentWinner se actualiza al índice actual de la carta.

```java
private static String[] SPECIAL_CARDS = { "SR", "PR", "SK" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (isSpecialCard(cards[i])) {
            if (cards[i].equals("SR")) { // is SR
                cards[i] = "11";
            } else if (cards[i].equals("PR")) { // is PR
                cards[i] = "12";
            } else { // is SK
                cards[i] = "13";
                biggestCardValue = 13;
                currentWinner = i;
            }
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if ("11".equals(cards[i]) || "12".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (String specialCard : SPECIAL_CARDS) {
        if (card.equals(specialCard)) {
            return true;
        }
    }
    return false;
}
```

**EJ19. Captura de que TODOS los tests PASAN tras la refactorización 1**

![Pasa](capturas/Ejemplo19.2.png "Pasa")

**EJ19. Refactorización 2**

En esta refactorización he introducido un nuevo array llamado SPECIAL_VALUES, que contiene los valores especiales correspondientes a cada carta especial. Esto hace que la asignación de valores especiales a cartas específicas sea más clara. Además, he creado un nuevo método privado llamado getSpecialValue, que facilita el acceso a los valores especiales de las cartas.

```java
private static String[] SPECIAL_CARDS = { "SR", "PR", "SK" };
private static String[] SPECIAL_VALUES = { "11", "12", "13" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (isSpecialCard(cards[i])) {
            cards[i] = getSpecialValue(cards[i]);
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (int i = 0; i < SPECIAL_CARDS.length; i++) {
        if (card.equals(SPECIAL_CARDS[i]) || card.equals(SPECIAL_VALUES[i])) {
            return true;
        }
    }
    return false;
}

private String getSpecialValue(String card) {
    for (int i = 0; i < SPECIAL_CARDS.length; i++) {
        if (card.equals(SPECIAL_CARDS[i])) {
            return SPECIAL_VALUES[i];
        }
    }
    return null;
}
```

**EJ19. Captura de que TODOS los tests PASAN tras la refactorización 2**

![Pasa](capturas/Ejemplo19.3.png "Pasa")

### Ejemplo 20

**INPUT y OUTPUT**: "PR SK SR SR" - "Gana jugador 3"

**EJ20. Código de test**

```java
"PR SK SR SR, Gana jugador 3"
```

**EJ20. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 3> but was: <Gana jugador 2>
```

**EJ20. Código mínimo para que el test pase**

El código mínimo que he añadido para que el test pase ha sido un if antes del for. En el que directamente, si el jugador 2 tiene la carta SK y el jugador 3 tiene SR, se devuelve como ganador el jugador 3.

```java
private static String[] SPECIAL_CARDS = { "SR", "PR", "SK" };
private static String[] SPECIAL_VALUES = { "11", "12", "13" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    if (cards[1].charAt(0) == 'S' && cards[1].charAt(1) == 'K' && cards[2].charAt(0) == 'S'
            && cards[2].charAt(1) == 'R') {
        return "Gana jugador 3";
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (isSpecialCard(cards[i])) {
            cards[i] = getSpecialValue(cards[i]);
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (int i = 0; i < SPECIAL_CARDS.length; i++) {
        if (card.equals(SPECIAL_CARDS[i]) || card.equals(SPECIAL_VALUES[i])) {
            return true;
        }
    }
    return false;
}

private String getSpecialValue(String card) {
    for (int i = 0; i < SPECIAL_CARDS.length; i++) {
        if (card.equals(SPECIAL_CARDS[i])) {
            return SPECIAL_VALUES[i];
        }
    }
    return null;
}
```

**EJ20. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo20.1.png "Pasa")

**EJ20. Refactorización 1**

En esta refactorización, si se encuentra una combinación de cartas consecutivas "SK" y "SR", el valor de la carta "SR" se cambia a "14".

```java
private static String[] SPECIAL_CARDS = { "SR", "PR", "SK" };
private static String[] SPECIAL_VALUES = { "11", "12", "13" };

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (cards[i].equals("SK") && i + 1 < cards.length && cards[i + 1].equals("SR")) {
            cards[i + 1] = "14";
        }
        if (isSpecialCard(cards[i])) {
            cards[i] = getSpecialValue(cards[i]);
        }
        if (playerCardLetter == 'N') {
            cards[i] = "10";
        }
        if (isSpecialCard(cards[i]) || "14".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    for (int i = 0; i < SPECIAL_CARDS.length; i++) {
        if (card.equals(SPECIAL_CARDS[i]) || card.equals(SPECIAL_VALUES[i])) {
            return true;
        }
    }
    return false;
}

private String getSpecialValue(String card) {
    for (int i = 0; i < SPECIAL_CARDS.length; i++) {
        if (card.equals(SPECIAL_CARDS[i])) {
            return SPECIAL_VALUES[i];
        }
    }
    return null;
}
```

**EJ20. Captura de que TODOS los tests PASAN tras la refactorización 1**

![Pasa](capturas/Ejemplo20.2.png "Pasa")

**EJ20. Refactorización 2**

En esta refactorización he cambiado los arrays SPECIAL_CARDS y SPECIAL_VALUES a conjuntos. Esto hace que el método isSpecialCard se simplifique al utilizar el método "contains" de los conjuntos. Además, he creado un nuevo método privado llamado convertCardValue que se encarga de convertir los valores de las cartas según las condiciones establecidas.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (cards[i].equals("SK") && i + 1 < cards.length && cards[i + 1].equals("SR")) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i]);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private String convertCardValue(String card) {
    if (SPECIAL_CARDS.contains(card)) {
        switch (card) {
            case "SR":
                return "11";
            case "PR":
                return "12";
            case "SK":
                return "13";
            default:
                return null;
        }
    } else if (card.charAt(1) == 'N') {
        return "10";
    } else {
        return card;
    }
}
```

**EJ20. Captura de que TODOS los tests PASAN tras la refactorización 2**

![Pasa](capturas/Ejemplo20.3.png "Pasa")

### Ejemplo 21

**INPUT y OUTPUT**: "1V KK SR" - "Gana jugador 1"

**EJ21. Código de test**

```java
"1V KK SR, Gana jugador 1"
```

**EJ21. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 1> but was: <Gana jugador 3>
```

**EJ21. Código mínimo para que el test pase**

El código mínimo que he añadido para que el test pase ha sido un if al inicio del for. Si se encuentra la carta KK en alguno de los jugadores, se devuelve el jugador 1 como ganador.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (cards[i].equals("KK")) {
            return "Gana jugador 1";
        }
        if (cards[i].equals("SK") && i + 1 < cards.length && cards[i + 1].equals("SR")) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i]);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private String convertCardValue(String card) {
    if (SPECIAL_CARDS.contains(card)) {
        switch (card) {
            case "SR":
                return "11";
            case "PR":
                return "12";
            case "SK":
                return "13";
            default:
                return null;
        }
    } else if (card.charAt(1) == 'N') {
        return "10";
    } else {
        return card;
    }
}
```

**EJ21. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo21.1.png "Pasa")

**EJ21. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 22

**INPUT y OUTPUT**: "5A PR KK" - "Gana jugador 1"

**EJ22. Código de test**

```java
"5A PR KK, Gana jugador 1"
```

**EJ22. Mensaje del test añadido que NO PASA**

```log
Este test pasa, ya que el anterior ejemplo lo he implementado para que devolviese como ganador el jugador 1 si hubiese algún jugador con la carta KK. Y en este ejemplo coincide que el jugador ganador es el 1, igual que en el anterior ejemplo.
```

**EJ22. Código mínimo para que el test pase**

No he añadido código a este ejemplo, ya que los tests pasan.

**EJ22. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo22.1.png "Pasa")

**EJ22. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 23

**INPUT y OUTPUT**: "7M SK KK" - "Gana jugador 1"

**EJ23. Código de test**

```java
"7M SK KK, Gana jugador 1"
```

**EJ23. Mensaje del test añadido que NO PASA**

```log
Este test pasa, ya que el ejemplo 21 lo he implementado para que devolviese como ganador el jugador 1 si hubiese algún jugador con la carta KK. Y en este ejemplo coincide que el jugador ganador es el 1, igual que ese mismo ejemplo.
```

**EJ23. Código mínimo para que el test pase**

No he añadido código a este ejemplo, ya que los tests pasan.

**EJ23. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo23.1.png "Pasa")

**EJ23. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 24

**INPUT y OUTPUT**: "KK SK 5A SR" - "Gana jugador 3"

**EJ24. Código de test**

```java
"KK SK 5A SR, Gana jugador 3"
```

**EJ24. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 3> but was: <Gana jugador 1>
```

**EJ24. Código mínimo para que el test pase**

Primero, he añadido una variable booleana que localiza si hay algún jugador con la carta KK. En el primer for se establece esa variable a true si se encuentra esa carta. Después, hay un if con dos for. En el primero se establecen todas las cartas especiales a "00", y en el segundo se sobreescribe la letra de la primera carta.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean foundKK = false;

    for (int i = 0; i < cards.length; i++) {
        if (cards[i].equals("KK")) {
            foundKK = true;
            break;
        }
    }
    if (foundKK) {
        for (int i = 0; i < cards.length; i++) {
            if (isSpecialCard(cards[i])) {
                cards[i] = "00";
            }
        }
        for (int i = 0; i < cards.length; i++) {
            if (!"00".equals(cards[i])) {
                firstLetter = cards[i].charAt(1);
                break;
            }
        }
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (cards[i].equals("SK") && i + 1 < cards.length && cards[i + 1].equals("SR")) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i]);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private String convertCardValue(String card) {
    if (SPECIAL_CARDS.contains(card)) {
        switch (card) {
            case "SR":
                return "11";
            case "PR":
                return "12";
            case "SK":
                return "13";
            default:
                return null;
        }
    } else if (card.charAt(1) == 'N') {
        return "10";
    } else {
        return card;
    }
}
```

**EJ24. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo24.1.png "Pasa")

**EJ24. Refactorización 1**

En esta refactorización he extraído bloques de código en métodos separados (isfoundKK y getFirstLetter). El método isfoundKK verifica si una carta KK está presente en la ronda. Y el método getFirstLetter se encarga de obtener la primera letra de la carta de la ronda, omitiendo cartas especiales.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean foundKK = isfoundKK(cards);

    if (foundKK) {
        firstLetter = getFirstLetter(cards, firstLetter);
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (!foundKK && cards[i].equals("SK") && i + 1 < cards.length && cards[i + 1].equals("SR")) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i]);
        if (!foundKK && isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            firstLetter = card.charAt(1);
            break;
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (cards[i].equals("KK")) {
            return true;
        }
    }
    return false;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private String convertCardValue(String card) {
    if (SPECIAL_CARDS.contains(card)) {
        switch (card) {
            case "SR":
                return "11";
            case "PR":
                return "12";
            case "SK":
                return "13";
            default:
                return null;
        }
    } else if (card.charAt(1) == 'N') {
        return "10";
    } else {
        return card;
    }
}
```

**EJ24. Captura de que TODOS los tests PASAN tras la refactorización 1**

![Pasa](capturas/Ejemplo24.2.png "Pasa")

**EJ24. Refactorización 2**

En esta refactorización he creado un nuevo método llamado convertFiguresTo00, que toma una carta como argumento y devuelve "00" si la carta es una carta especial (SR, PR, SK o KK), de lo contrario devuelve la carta original.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean foundKK = isfoundKK(cards);

    firstLetter = getFirstLetter(cards, firstLetter);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (foundKK) {
            cards[i] = convertFiguresTo00(cards[i]);
        }
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i]);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private String convertCardValue(String card) {
    if (SPECIAL_CARDS.contains(card)) {
        switch (card) {
            case "SR":
                return "11";
            case "PR":
                return "12";
            case "SK":
                return "13";
            default:
                return null;
        }
    } else if (card.charAt(1) == 'N') {
        return "10";
    } else {
        return card;
    }
}

private String convertFiguresTo00(String card) {
    if (SPECIAL_CARDS.contains(card)) {
        switch (card) {
            case "SR":
                return "00";
            case "PR":
                return "00";
            case "SK":
                return "00";
            case "KK":
                return "00";
            default:
                return null;
        }
    } else {
        return card;
    }
}
```

**EJ24. Captura de que TODOS los tests PASAN tras la refactorización 2**

![Pasa](capturas/Ejemplo24.3.png "Pasa")

### Ejemplo 25

**INPUT y OUTPUT**: "PR KK SR PR" - "Gana jugador 2"

**EJ25. Código de test**

```java
"PR KK SR PR, Gana jugador 2"
```

**EJ25. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 2> but was: <Gana jugador 0>
```

**EJ25. Código mínimo para que el test pase**

Primero, he almacenado en una variable global el jugador que tiene la carta KK. Luego, al final de la función principal, si hay algún jugador con KK y el currentWinner es igual a -1 (esto significa que el resto de cartas son figuras), se devuelve como ganador el jugador de la carta KK.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14");
private int playerWithKK = -1;

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean foundKK = isfoundKK(cards);

    firstLetter = getFirstLetter(cards, firstLetter);

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (foundKK) {
            cards[i] = convertFiguresTo00(cards[i]);
        }
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i]);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (foundKK && currentWinner == -1) {
        return "Gana jugador " + (playerWithKK + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            playerWithKK = i;
            return true;
        }
    }
    return false;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private String convertCardValue(String card) {
    if (SPECIAL_CARDS.contains(card)) {
        switch (card) {
            case "SR":
                return "11";
            case "PR":
                return "12";
            case "SK":
                return "13";
            default:
                return null;
        }
    } else if (card.charAt(1) == 'N') {
        return "10";
    } else {
        return card;
    }
}

private String convertFiguresTo00(String card) {
    if (SPECIAL_CARDS.contains(card)) {
        switch (card) {
            case "SR":
                return "00";
            case "PR":
                return "00";
            case "SK":
                return "00";
            case "KK":
                return "00";
            default:
                return null;
        }
    } else {
        return card;
    }
}
```

**EJ25. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo25.1.png "Pasa")

**EJ25. Refactorización 1**

En esta refactorización he eliminado la variable playerWithKK global y la he puesto como local. Además, he creado un nuevo método llamado playerWithKK que busca si hay algún jugador con la carta "KK". En ese caso, devuelve el índice de ese jugador.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean foundKK = false;

    int playerWithKK =  playerWithKK(cards);
    if (playerWithKK != -1) {
        foundKK = true;
    }

    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if (foundKK) {
            cards[i] = convertFiguresTo00(cards[i]);
        }
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i]);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (foundKK && currentWinner == -1) {
        return "Gana jugador " + (playerWithKK + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private int playerWithKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private String convertCardValue(String card) {
    if (SPECIAL_CARDS.contains(card)) {
        switch (card) {
            case "SR":
                return "11";
            case "PR":
                return "12";
            case "SK":
                return "13";
            default:
                return null;
        }
    } else if (card.charAt(1) == 'N') {
        return "10";
    } else {
        return card;
    }
}

private String convertFiguresTo00(String card) {
    if (SPECIAL_CARDS.contains(card)) {
        switch (card) {
            case "SR":
                return "00";
            case "PR":
                return "00";
            case "SK":
                return "00";
            case "KK":
                return "00";
            default:
                return null;
        }
    } else {
        return card;
    }
}
```

**EJ25. Captura de que TODOS los tests PASAN tras la refactorización 1**

![Pasa](capturas/Ejemplo25.2.png "Pasa")

**EJ25. Refactorización 2**

En esta refactorización he añadido un nuevo valor 15 a la constante SPECIAL_VALUES. Además, he añadido el método allAreSpecialCards para verificar si todas las cartas son especiales. Por último, he unificado los métodos convertCardValue y convertFiguresTo00.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false;
    boolean foundKK = false;

    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials) {
    if (!SPECIAL_CARDS.contains(card)) {
        return card.charAt(1) == 'N' ? "10" : card;
    }

    switch (card) {
        case "SR":
            return foundKK ? "00" : "11";
        case "PR":
            return foundKK ? "00" : "12";
        case "SK":
            return foundKK ? "00" : "13";
        case "KK":
            return allSpecials ? "15" : "00";
        default:
            return null;
    }
}
```

**EJ25. Captura de que TODOS los tests PASAN tras la refactorización 2**

![Pasa](capturas/Ejemplo25.3.png "Pasa")

### Ejemplo 26

**INPUT y OUTPUT**: "1A 1V BB 2V" - "Gana jugador 4"

**EJ26. Código de test**

```java
"1A 1V BB 2V, Gana jugador 4"
```

**EJ26. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 4> but was: <Gana jugador 1>
```

**EJ26. Código mínimo para que el test pase**

He hecho un nuevo for en el que se busca la carta BB. Si se encuentra, se devuelve el jugador 4 como ganador.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false;
    boolean foundKK = false;

    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return "Gana jugador 4";
        }
    }

    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials) {
    if (!SPECIAL_CARDS.contains(card)) {
        return card.charAt(1) == 'N' ? "10" : card;
    }

    switch (card) {
        case "SR":
            return foundKK ? "00" : "11";
        case "PR":
            return foundKK ? "00" : "12";
        case "SK":
            return foundKK ? "00" : "13";
        case "KK":
            return allSpecials ? "15" : "00";
        default:
            return null;
    }
}
```

**EJ26. Captura de que TODOS los test PASAN**

A partir de este ejemplo solo muestro una captura más general de los tests.

![Pasa](capturas/Ejemplo26.1.png "Pasa")

**EJ26. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 27

**INPUT y OUTPUT**: "1A 8V BB 2N" - "Gana jugador 2"

**EJ27. Código de test**

```java
"1A 8V BB 2N, Gana jugador 2"
```

**EJ27. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 2> but was: <Gana jugador 4>
```

**EJ27. Código mínimo para que el test pase**

He añadido la carta especial BB y una función que devuelve true si hay algún jugador con esa carta.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false;
    boolean foundKK = false;
    boolean foundBB = false;

    foundBB = isfoundBB(cards);
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private boolean isfoundBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        if (foundBB && card.charAt(1) == 'N') {
            return card;
        }
        return card.charAt(1) == 'N' ? "10" : card;
    }

    switch (card) {
        case "SR":
            return foundKK ? "00" : "11";
        case "PR":
            return foundKK ? "00" : "12";
        case "SK":
            return foundKK ? "00" : "13";
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ27. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo27.1.png "Pasa")

**EJ27. Refactorización**

En esta refactorización lo único que he hecho ha sido agrupar la inicialización de las variables booleanas en una línea.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;

    foundBB = isfoundBB(cards);
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    return "Gana jugador " + (currentWinner + 1);
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private boolean isfoundBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        if (foundBB && card.charAt(1) == 'N') {
            return card;
        }
        return card.charAt(1) == 'N' ? "10" : card;
    }

    switch (card) {
        case "SR":
            return foundKK ? "00" : "11";
        case "PR":
            return foundKK ? "00" : "12";
        case "SK":
            return foundKK ? "00" : "13";
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ27. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo27.2.png "Pasa")

### Ejemplo 28

**INPUT y OUTPUT**: "2A 1V BB 2N" - "Gana jugador 3"

**EJ28. Código de test**

```java
"2A 1V BB 2N, Gana jugador 3"
```

**EJ28. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 3> but was: <Gana jugador 1>
```

**EJ28. Código mínimo para que el test pase**

Lo que hago para que este test pase es crear un nuevo método que recibe el array de cartas y el valor mayor de entre todas las cartas. Devuelve true si hay alguna otra carta (que no sea esa que hemos encontrado antes) del mismo valor, es decir, si hay empate. En caso contrario, devuelve false. Posteriormente, en la función principal, si hay empate devolvemos como ganador al jugador que tiene la carta BB.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");
private int playerWithBB = -1;

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;

    foundBB = isfoundBB(cards);
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    boolean foundBiggestCard = false;
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            int value = Character.getNumericValue(cards[i].charAt(0));
            if (value == biggestCardValue) {
                if (foundBiggestCard) {
                    return true;
                } else {
                    foundBiggestCard = true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private boolean isfoundBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            playerWithBB = i;
            return true;
        }
    }
    return false;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        if (foundBB && card.charAt(1) == 'N') {
            return card;
        }
        return card.charAt(1) == 'N' ? "10" : card;
    }

    switch (card) {
        case "SR":
            return foundKK ? "00" : "11";
        case "PR":
            return foundKK ? "00" : "12";
        case "SK":
            return foundKK ? "00" : "13";
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ28. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo28.1.png "Pasa")

**EJ28. Refactorización**

En esta refactorización he transformado la función isFoundBB por playerWithBB, para que me devuelva el índice del jugador que tiene la carta BB.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1;

    playerWithBB = playerWithBB(cards);
    if (playerWithBB != -1) {
        foundBB = true;
    }
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private int playerWithBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        if (foundBB && card.charAt(1) == 'N') {
            return card;
        }
        return card.charAt(1) == 'N' ? "10" : card;
    }
    switch (card) {
        case "SR":
            return foundKK ? "00" : "11";
        case "PR":
            return foundKK ? "00" : "12";
        case "SK":
            return foundKK ? "00" : "13";
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ28. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo28.2.png "Pasa")

### Ejemplo 29

**INPUT y OUTPUT**: "1A 8N BB SR" - "Gana jugador 2"

**EJ29. Código de test**

```java
"1A 8N BB SR, Gana jugador 2"
```

**EJ29. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 2> but was: <Gana jugador 4>
```

**EJ29. Código mínimo para que el test pase**

Lo único que he hecho para pasar este test ha sido añadir un if en la función convertCardValue, es decir, si hay BB y se encuentra la carta SR, se pone en su lugar un 7. He puesto un 7 por la siguiente razón: para que no gane SR tenemos que darle un valor numérico, ya que al estar la carta BB, no se considera el color para determinar el ganador. Además, como el ejemplo dice que debe ganar el jugador de la carta 8N, le damos a la carta SR el valor de 7, es decir un valor menor que 8.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1;

    playerWithBB = playerWithBB(cards);
    if (playerWithBB != -1) {
        foundBB = true;
    }
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private int playerWithBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        if (foundBB && card.charAt(1) == 'N') {
            return card;
        }
        return card.charAt(1) == 'N' ? "10" : card;
    }
    switch (card) {
        case "SR":
            if (foundBB) {
                return "7";
            }
            return foundKK ? "00" : "11";
        case "PR":
            return foundKK ? "00" : "12";
        case "SK":
            return foundKK ? "00" : "13";
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ29. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo29.1.png "Pasa")

**EJ29. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 30

**INPUT y OUTPUT**: "2N BB PR 9V" - "Gana jugador 4"

**EJ30. Código de test**

```java
"2N BB PR 9V, Gana jugador 4"
```

**EJ30. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 4> but was: <Gana jugador 3>
```

**EJ30. Código mínimo para que el test pase**

Lo único que he hecho para pasar este test ha sido añadir un if en la función convertCardValue, es decir, si hay BB y se encuentra la carta PR, se pone en su lugar un 8. He puesto un 8 por la siguiente razón: para que no gane PR tenemos que darle un valor numérico, ya que al estar la carta BB, no se considera el color para determinar el ganador. Además, como el ejemplo dice que debe ganar el jugador de la carta 9V, le damos a la carta PR el valor de 8, es decir un valor menor que 9.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1;

    playerWithBB = playerWithBB(cards);
    if (playerWithBB != -1) {
        foundBB = true;
    }
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private int playerWithBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        if (foundBB && card.charAt(1) == 'N') {
            return card;
        }
        return card.charAt(1) == 'N' ? "10" : card;
    }
    switch (card) {
        case "SR":
            if (foundBB) {
                return "7";
            }
            return foundKK ? "00" : "11";
        case "PR":
            if (foundBB) {
                return "8";
            }
            return foundKK ? "00" : "12";
        case "SK":
            return foundKK ? "00" : "13";
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ30. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo30.1.png "Pasa")

**EJ30. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 31

**INPUT y OUTPUT**: "1N SK BB" - "Gana jugador 1"

**EJ31. Código de test**

```java
"1N SK BB, Gana jugador 1"
```

**EJ31. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 1> but was: <Gana jugador 2>
```

**EJ31. Código mínimo para que el test pase**

Lo único que he hecho para pasar este test ha sido añadir un if en la función convertCardValue, es decir, si hay BB y se encuentra la carta SK, se pone en su lugar un 0. He puesto un 0 por la siguiente razón: para que no gane SK tenemos que darle un valor numérico, ya que al estar la carta BB, no se considera el color para determinar el ganador. Además, como el ejemplo dice que debe ganar el jugador de la carta 1N, le damos a la carta SK el valor de 0 es decir un valor menor que 1.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1;

    playerWithBB = playerWithBB(cards);
    if (playerWithBB != -1) {
        foundBB = true;
    }
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private int playerWithBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        if (foundBB && card.charAt(1) == 'N') {
            return card;
        }
        return card.charAt(1) == 'N' ? "10" : card;
    }
    switch (card) {
        case "SR":
            if (foundBB) {
                return "7";
            }
            return foundKK ? "00" : "11";
        case "PR":
            if (foundBB) {
                return "8";
            }
            return foundKK ? "00" : "12";
        case "SK":
            if (foundBB) {
                return "0";
            }
            return foundKK ? "00" : "13";
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ31. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo31.1.png "Pasa")

**EJ31. Refactorización**

En esta refactorización he simplificado el método convertCardValue.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1;

    playerWithBB = playerWithBB(cards);
    if (playerWithBB != -1) {
        foundBB = true;
    }
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private int playerWithBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        return foundBB && card.charAt(1) == 'N' ? card : (card.charAt(1) == 'N' ? "10" : card);
    }
    switch (card) {
        case "SR":
            return foundKK ? "00" : (foundBB ? "7" : "11");
        case "PR":
            return foundKK ? "00" : (foundBB ? "8" : "12");
        case "SK":
            return foundKK ? "00" : (foundBB ? "0" : "13");
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ31. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/Ejemplo31.2.png "Pasa")

### Ejemplo 32

**INPUT y OUTPUT**: "SR BB KK 8V 1N SK PR" - "Gana jugador 5"

**EJ32. Código de test**

```java
"SR BB KK 8V 1N SK PR, Gana jugador 5"
```

**EJ32. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 5> but was: <Gana jugador 2>
```

**EJ32. Código mínimo para que el test pase**

Lo único que he añadido para que pase el test ha sido un if que localiza si hay BB y luego KK. En ese caso, pone la BB a "00", el booleano de foundBB lo pone a false y el jugador que tiene la carta BB se vuelve a poner a -1.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1;

    playerWithBB = playerWithBB(cards);
    if (playerWithBB != -1) {
        foundBB = true;
    }
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        if ("BB".equals(cards[i]) && i + 1 < cards.length && "KK".equals(cards[i + 1])) {
            cards[i] = "00";
            foundBB = false;
            playerWithBB = -1;
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private int playerWithBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        return foundBB && card.charAt(1) == 'N' ? card : (card.charAt(1) == 'N' ? "10" : card);
    }
    switch (card) {
        case "SR":
            return foundKK ? "00" : (foundBB ? "7" : "11");
        case "PR":
            return foundKK ? "00" : (foundBB ? "8" : "12");
        case "SK":
            return foundKK ? "00" : (foundBB ? "0" : "13");
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ32. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo32.1.png "Pasa")

**EJ32. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 33

**INPUT y OUTPUT**: "6A KK BB SR" - "Gana jugador 4"

**EJ33. Código de test**

```java
"6A KK BB SR, Gana jugador 4"
```

**EJ33. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 4> but was: <Gana jugador 1>
```

**EJ33. Código mínimo para que el test pase**

Lo único que he añadido para que pase el test ha sido un if que localiza si hay KK y luego BB. En ese caso, pone el booleano de foundKK a false.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = 0;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1;

    playerWithBB = playerWithBB(cards);
    if (playerWithBB != -1) {
        foundBB = true;
    }
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        if ("BB".equals(cards[i]) && i + 1 < cards.length && "KK".equals(cards[i + 1])) {
            cards[i] = "00";
            foundBB = false;
            playerWithBB = -1;
        }
        if ("KK".equals(cards[i]) && i + 1 < cards.length && "BB".equals(cards[i + 1])) {
            foundKK = false;
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private int playerWithBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        return foundBB && card.charAt(1) == 'N' ? card : (card.charAt(1) == 'N' ? "10" : card);
    }
    switch (card) {
        case "SR":
            return foundKK ? "00" : (foundBB ? "7" : "11");
        case "PR":
            return foundKK ? "00" : (foundBB ? "8" : "12");
        case "SK":
            return foundKK ? "00" : (foundBB ? "0" : "13");
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ33. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo33.1.png "Pasa")

**EJ33. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 34

**INPUT y OUTPUT**: "KK SK BB" - "Gana jugador 2"

**EJ34. Código de test**

```java
"KK SK BB, Gana jugador 2"
```

**EJ34. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 2> but was: <Gana jugador 1>
```

**EJ34. Código mínimo para que el test pase**

Lo que he hecho para que pase este test ha sido otro for donde recorro todas las cartas y me guardo los índices de las cartas KK y BB. Luego, en un if, compruebo que la carta KK está antes que la carta BB. Y, en ese caso, pongo la carta KK a -1. He escogido el valor -1 ya que tiene que ser un valor menor a 0, ya que SK se transforma en un 0 y el ejemplo dice que gana la carta "SK". Por tanto, el nuevo valor del "KK" debe ser menor al valor de "SK".

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = -1;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1;

    playerWithBB = playerWithBB(cards);
    if (playerWithBB != -1) {
        foundBB = true;
    }
    foundKK = isfoundKK(cards);
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);

    int indexKK = -1;
    int indexBB = -1;
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            indexKK = i;
        }
        if ("BB".equals(cards[i])) {
            indexBB = i;
        }
    }
    if (indexKK != -1 && indexBB != -1 && indexKK < indexBB) {
        cards[indexKK] = "-1";
        foundKK = false;
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        if ("BB".equals(cards[i]) && i + 1 < cards.length && "KK".equals(cards[i + 1])) {
            cards[i] = "00";
            foundBB = false;
            playerWithBB = -1;
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (foundBB && biggestCardValue != 0 && isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private boolean isfoundKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return true;
        }
    }
    return false;
}

private int playerWithBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        return foundBB && card.charAt(1) == 'N' ? card : (card.charAt(1) == 'N' ? "10" : card);
    }
    switch (card) {
        case "SR":
            return foundKK ? "00" : (foundBB ? "7" : "11");
        case "PR":
            return foundKK ? "00" : (foundBB ? "8" : "12");
        case "SK":
            return foundKK ? "00" : (foundBB ? "0" : "13");
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ34. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo34.1.png "Pasa")

**EJ34. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo 35

**INPUT y OUTPUT**: "PR KK BB 7M" - "Gana jugador 1"

**EJ35. Código de test**

```java
"PR KK BB 7M, Gana jugador 1"
```

**EJ35. Mensaje del test añadido que NO PASA**

```log
Este test pasa, ya que al estar el KK antes que BB, se pone la carta KK a -1, luego PR se pondría a 8 (ya que hay BB), y por tanto, 8 > 7, así que ganaría el jugador de la carta PR, es decir, el jugador 1.
```

**EJ35. Código mínimo para que el test pase**

No he implementado código mínimo, ya que el test pasa.

**EJ35. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo35.1.png "Pasa")

**EJ35. Refactorización 1**

En esta refactorización he transformado el método isFoundKK por playerWithKK, para que me devuelva el índice del jugador que tiene la carta "KK".

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = -1;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1, playerWithKK = -1;

    playerWithBB = playerWithBB(cards);
    if (playerWithBB != -1) {
        foundBB = true;
    }
    playerWithKK = playerWithKK(cards);
    if (playerWithKK != -1) {
        foundKK = true;
    }
    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    if (playerWithKK != -1 && playerWithBB != -1 && playerWithKK < playerWithBB) {
        cards[playerWithKK] = "-1";
        foundKK = false;
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        if ("BB".equals(cards[i]) && i + 1 < cards.length && "KK".equals(cards[i + 1])) {
            cards[i] = "00";
            foundBB = false;
            playerWithBB = -1;
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (foundBB && biggestCardValue != 0 && isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private int playerWithKK(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("KK".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private int playerWithBB(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if ("BB".equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        return foundBB && card.charAt(1) == 'N' ? card : (card.charAt(1) == 'N' ? "10" : card);
    }
    switch (card) {
        case "SR":
            return foundKK ? "00" : (foundBB ? "7" : "11");
        case "PR":
            return foundKK ? "00" : (foundBB ? "8" : "12");
        case "SK":
            return foundKK ? "00" : (foundBB ? "0" : "13");
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ35. Captura de que TODOS los tests PASAN tras la refactorización 1**

![Pasa](capturas/Ejemplo35.2.png "Pasa")

**EJ35. Refactorización 2**

En esta refactorización he colocado el código para que sea más fácil de entender y he unificado los métodos anteriores llamados playerWithBB y playerWithKK en otro más general llamado playerWithASpecificCard.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = -1;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1, playerWithKK = -1;

    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    playerWithBB = playerWithASpecificCard(cards, "BB");
    playerWithKK = playerWithASpecificCard(cards, "KK");

    if (playerWithBB != -1) {
        foundBB = true;
    }
    if (playerWithKK != -1) {
        foundKK = true;
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        if ("BB".equals(cards[i]) && i + 1 < cards.length && "KK".equals(cards[i + 1])) {
            foundBB = false;
            playerWithBB = -1;
        }
        if (playerWithKK != -1 && playerWithBB != -1 && playerWithKK < playerWithBB) {
            cards[playerWithKK] = "-1";
            foundKK = false;
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (foundBB && biggestCardValue != 0 && isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private int playerWithASpecificCard(String[] cards, String specificCard) {
    for (int i = 0; i < cards.length; i++) {
        if (specificCard.equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        return foundBB && card.charAt(1) == 'N' ? card : (card.charAt(1) == 'N' ? "10" : card);
    }
    switch (card) {
        case "SR":
            return foundKK ? "00" : (foundBB ? "7" : "11");
        case "PR":
            return foundKK ? "00" : (foundBB ? "8" : "12");
        case "SK":
            return foundKK ? "00" : (foundBB ? "0" : "13");
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ35. Captura de que TODOS los tests PASAN tras la refactorización 2**

![Pasa](capturas/Ejemplo35.3.png "Pasa")

### Ejemplo EXTRA 1

**INPUT y OUTPUT**: "SR BB 8V KK 1N SK PR" - "Gana jugador 5"

**EJ1 EXTRA 1. Código de test**

```java
"SR BB 8V KK 1N SK PR, Gana jugador 5"
```

**EJ EXTRA 1. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 5> but was: <Gana jugador 3>
```

**EJ EXTRA 1. Código mínimo para que el test pase**

Lo que he hecho para pasar este test ha sido cambiar el if que controlaba que la carta BB estuviese antes que al carta KK. En lugar de comparar que ambas cartas estuviesen seguidas, comparo sus índices para controlar que una está después que la otra, y no inmediatamente después.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = -1;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1, playerWithKK = -1;

    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    playerWithBB = playerWithASpecificCard(cards, "BB");
    playerWithKK = playerWithASpecificCard(cards, "KK");

    if (playerWithBB != -1) {
        foundBB = true;
    }
    if (playerWithKK != -1) {
        foundKK = true;
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        if (playerWithKK != -1 && playerWithBB != -1 && playerWithBB < playerWithKK) {
            foundBB = false;
            playerWithBB = -1;
        }
        if (playerWithKK != -1 && playerWithBB != -1 && playerWithKK < playerWithBB) {
            cards[playerWithKK] = "-1";
            foundKK = false;
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if ("10".equals(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (foundBB && biggestCardValue != 0 && isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private int playerWithASpecificCard(String[] cards, String specificCard) {
    for (int i = 0; i < cards.length; i++) {
        if (specificCard.equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        return foundBB && card.charAt(1) == 'N' ? card : (card.charAt(1) == 'N' ? "10" : card);
    }
    switch (card) {
        case "SR":
            return foundKK ? "00" : (foundBB ? "7" : "11");
        case "PR":
            return foundKK ? "00" : (foundBB ? "8" : "12");
        case "SK":
            return foundKK ? "00" : (foundBB ? "0" : "13");
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ EXTRA 1. Captura de que TODOS los test PASAN**

![Pasa](capturas/EjemploExtra1.1.png "Pasa")

**EJ EXTRA 1. Refactorización**

No he refactorizado. Por tanto, este paso y el siguiente los omito.

### Ejemplo EXTRA 2

**INPUT y OUTPUT**: "7M 1N 4N 8V" - "Gana jugador 3"

**EJ1 EXTRA 2. Código de test**

```java
"7M 1N 4N 8V, Gana jugador 3"
```

**EJ EXTRA 2. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <Gana jugador 3> but was: <Gana jugador 2>
```

**EJ EXTRA 2. Código mínimo para que el test pase**

Lo que he hecho para que pase este test ha sido eliminar el if que comparaba la carta con "10", y, al encontrar una carta con letra N, ya no se transforma esa carta al número 10.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = -1;
    int currentWinner = -1;
    char firstLetter = cards[0].charAt(1);
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1, playerWithKK = -1;

    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards, firstLetter);
    playerWithBB = playerWithASpecificCard(cards, "BB");
    playerWithKK = playerWithASpecificCard(cards, "KK");

    if (playerWithBB != -1) {
        foundBB = true;
    }
    if (playerWithKK != -1) {
        foundKK = true;
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        if (playerWithKK != -1 && playerWithBB != -1 && playerWithBB < playerWithKK) {
            foundBB = false;
            playerWithBB = -1;
        }
        if (playerWithKK != -1 && playerWithBB != -1 && playerWithKK < playerWithBB) {
            cards[playerWithKK] = "-1";
            foundKK = false;
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (foundBB && biggestCardValue != 0 && isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    Set<Integer> foundValues = new HashSet<>();
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (!foundValues.add(value)) {
                    return true;
                }
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards, char firstLetter) {
    for (String card : cards) {
        if ("N".equals(String.valueOf(card.charAt(1)))) {
            return card.charAt(1);
        }
    }
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private int playerWithASpecificCard(String[] cards, String specificCard) {
    for (int i = 0; i < cards.length; i++) {
        if (specificCard.equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        return card;
    }
    switch (card) {
        case "SR":
            return foundKK ? "00" : (foundBB ? "7" : "11");
        case "PR":
            return foundKK ? "00" : (foundBB ? "8" : "12");
        case "SK":
            return foundKK ? "00" : (foundBB ? "0" : "13");
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ EXTRA 2. Captura de que TODOS los test PASAN**

![Pasa](capturas/EjemploExtra2.1.png "Pasa")

**EJ EXTRA 2. Refactorización 1**

En esta refactorización he cambiado el funcionamiento del método isATie.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = -1;
    int currentWinner = -1;
    char firstLetter;
    boolean allSpecials = false, foundKK = false, foundBB = false;
    int playerWithBB = -1, playerWithKK = -1;

    allSpecials = allAreSpecialCards(cards);
    firstLetter = getFirstLetter(cards);
    playerWithBB = playerWithASpecificCard(cards, "BB");
    playerWithKK = playerWithASpecificCard(cards, "KK");

    if (playerWithBB != -1) {
        foundBB = true;
    }
    if (playerWithKK != -1) {
        foundKK = true;
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        if (playerWithKK != -1 && playerWithBB != -1 && playerWithBB < playerWithKK) {
            foundBB = false;
            playerWithBB = -1;
        }
        if (playerWithKK != -1 && playerWithBB != -1 && playerWithKK < playerWithBB) {
            cards[playerWithKK] = "-1";
            foundKK = false;
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.valueOf(cards[i]);
            if (playerCardValue > biggestCardValue || playerCardValue == biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (foundBB && biggestCardValue != 0 && isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    boolean foundBiggestCardValue = false;
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            int value = Character.getNumericValue(card.charAt(0));
            if (value == biggestCardValue) {
                if (foundBiggestCardValue) {
                    return true;
                }
                foundBiggestCardValue = true;
            }
        }
    }
    return false;
}

private char getFirstLetter(String[] cards) {
    char firstLetter = cards[0].charAt(1);
    for (String card : cards) {
        if (card.charAt(1) == 'N') {
            return card.charAt(1);
        }
    }
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private int playerWithASpecificCard(String[] cards, String specificCard) {
    for (int i = 0; i < cards.length; i++) {
        if (specificCard.equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    if (SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card)) {
        return true;
    }
    return false;
}

private boolean allAreSpecialCards(String[] cards) {
    for (int i = 0; i < cards.length; i++) {
        if (!isSpecialCard(cards[i])) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        return card;
    }
    switch (card) {
        case "SR":
            return foundKK ? "00" : (foundBB ? "7" : "11");
        case "PR":
            return foundKK ? "00" : (foundBB ? "8" : "12");
        case "SK":
            return foundKK ? "00" : (foundBB ? "0" : "13");
        case "KK":
            return allSpecials ? "15" : "00";
        case "BB":
            return "00";
        default:
            return null;
    }
}
```

**EJ EXTRA 2. Captura de que TODOS los tests PASAN tras la refactorización 1**

![Pasa](capturas/EjemploExtra2.2.png "Pasa")

**EJ EXTRA 2. Refactorización 2**

En esta refactorización he cambiado el for de allAreSpecialCards por un for mejorado. Además, he mejorado las funciones de isSpecialCard y convertCardValue.

```java
private static final Set<String> SPECIAL_CARDS = Set.of("SR", "PR", "SK", "KK", "BB");
private static final Set<String> SPECIAL_VALUES = Set.of("11", "12", "13", "14", "15");

public String play(String round) {
    String[] cards = round.split(" ");
    int biggestCardValue = -1;
    int currentWinner = -1;
    char firstLetter = getFirstLetter(cards);
    boolean allSpecials = allAreSpecialCards(cards);
    boolean foundKK = false;
    boolean foundBB = false;
    int playerWithBB = playerWithASpecificCard(cards, "BB");
    int playerWithKK = playerWithASpecificCard(cards, "KK");

    if (playerWithBB != -1) {
        foundBB = true;
    }
    if (playerWithKK != -1) {
        foundKK = true;
    }

    for (int i = 0; i < cards.length; i++) {
        char playerCardLetter = cards[i].charAt(1);
        if ("SK".equals(cards[i]) && i + 1 < cards.length && "SR".equals(cards[i + 1])) {
            cards[i + 1] = "14";
        }
        if (playerWithKK != -1 && playerWithBB != -1 && playerWithBB < playerWithKK) {
            foundBB = false;
            playerWithBB = -1;
        }
        if (playerWithKK != -1 && playerWithBB != -1 && playerWithKK < playerWithBB) {
            cards[playerWithKK] = "-1";
            foundKK = false;
        }
        cards[i] = convertCardValue(cards[i], foundKK, allSpecials, foundBB);
        if (isSpecialCard(cards[i])) {
            int playerCardValue = Integer.parseInt(cards[i]);
            if (playerCardValue >= biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
        if (playerCardLetter == firstLetter || foundBB) {
            int playerCardValue = Character.getNumericValue(cards[i].charAt(0));
            if (playerCardValue > biggestCardValue) {
                biggestCardValue = playerCardValue;
                currentWinner = i;
            }
        }
    }
    if (foundBB && biggestCardValue != 0 && isATie(cards, biggestCardValue)) {
        return "Gana jugador " + (playerWithBB + 1);
    }
    return "Gana jugador " + (currentWinner + 1);
}

private boolean isATie(String[] cards, int biggestCardValue) {
    boolean foundBiggestCardValue = false;
    for (String card : cards) {
        int value = Character.getNumericValue(card.charAt(0));
        if (!isSpecialCard(card) && value == biggestCardValue) {
            if (foundBiggestCardValue) {
                return true;
            }
            foundBiggestCardValue = true;
        }
    }
    return false;
}

private char getFirstLetter(String[] cards) {
    char firstLetter = cards[0].charAt(1);
    for (String card : cards) {
        if (card.charAt(1) == 'N') {
            return card.charAt(1);
        }
    }
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return card.charAt(1);
        }
    }
    return firstLetter;
}

private int playerWithASpecificCard(String[] cards, String specificCard) {
    for (int i = 0; i < cards.length; i++) {
        if (specificCard.equals(cards[i])) {
            return i;
        }
    }
    return -1;
}

private boolean isSpecialCard(String card) {
    return SPECIAL_CARDS.contains(card) || SPECIAL_VALUES.contains(card);
}

private boolean allAreSpecialCards(String[] cards) {
    for (String card : cards) {
        if (!isSpecialCard(card)) {
            return false;
        }
    }
    return true;
}

private String convertCardValue(String card, boolean foundKK, boolean allSpecials, boolean foundBB) {
    if (!SPECIAL_CARDS.contains(card)) {
        return card;
    }
    return switch (card) {
        case "SR" -> foundKK ? "00" : (foundBB ? "7" : "11");
        case "PR" -> foundKK ? "00" : (foundBB ? "8" : "12");
        case "SK" -> foundKK ? "00" : (foundBB ? "0" : "13");
        case "KK" -> allSpecials ? "15" : "00";
        case "BB" -> "00";
        default -> null;
    };
}
```

**EJ EXTRA 2. Captura de que TODOS los tests PASAN tras la refactorización 2**

![Pasa](capturas/EjemploExtra2.3.png "Pasa")
