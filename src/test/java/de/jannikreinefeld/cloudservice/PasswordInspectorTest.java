package de.jannikreinefeld.cloudservice;

import de.jannikreinefeld.cloudservice.passwordInspector.PasswordInspector;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordInspectorTest {
    @Test
    public void matchesNumber(){
        Assertions.assertThat(PasswordInspector.matchesNumber("123")).isTrue();
        Assertions.assertThat(PasswordInspector.matchesNumber("a123")).isTrue();
        Assertions.assertThat(PasswordInspector.matchesNumber("asd123dawaw")).isTrue();
        Assertions.assertThat(PasswordInspector.matchesNumber("%!13daw3234")).isTrue();
        Assertions.assertThat(PasswordInspector.matchesNumber("")).isFalse();
        Assertions.assertThat(PasswordInspector.matchesNumber("dawdaw")).isFalse();
        Assertions.assertThat(PasswordInspector.matchesNumber("$%ddwa")).isFalse();
    }
    @Test
    public void matchesLetter(){
        Assertions.assertThat(PasswordInspector.matchesLetter("123")).isFalse();
        Assertions.assertThat(PasswordInspector.matchesLetter("a123")).isTrue();
        Assertions.assertThat(PasswordInspector.matchesLetter("asd123dawaw")).isTrue();
        Assertions.assertThat(PasswordInspector.matchesLetter("%!13daw3234")).isTrue();
        Assertions.assertThat(PasswordInspector.matchesLetter("")).isFalse();
        Assertions.assertThat(PasswordInspector.matchesLetter("dawdaw")).isTrue();
        Assertions.assertThat(PasswordInspector.matchesLetter("$%ddwa")).isTrue();
    }

    @Test
    public void matchesSymbol(){
        Assertions.assertThat(PasswordInspector.matchesSymbol("123")).isFalse();
        Assertions.assertThat(PasswordInspector.matchesSymbol("a123")).isFalse();
        Assertions.assertThat(PasswordInspector.matchesSymbol("asd123dawaw")).isFalse();
        Assertions.assertThat(PasswordInspector.matchesSymbol("%!13daw3234")).isTrue();
        Assertions.assertThat(PasswordInspector.matchesSymbol("")).isFalse();
        Assertions.assertThat(PasswordInspector.matchesSymbol("dawdaw")).isFalse();
        Assertions.assertThat(PasswordInspector.matchesSymbol("$%ddwa")).isTrue();
        Assertions.assertThat(PasswordInspector.matchesSymbol("$%")).isTrue();
    }
    @Test
    public void testPossibility(){
        System.out.println(PasswordInspector.getPasswordScore("dwu658"));
       //Assertions.assertThat(PasswordInspector.getPasswordScore("12345")).isEqualTo(100000);
    }
}
