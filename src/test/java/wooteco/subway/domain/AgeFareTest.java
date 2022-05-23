package wooteco.subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AgeFareTest {

    @DisplayName("청소년일 경우 350원을 공제하고 20% 할인을 한다.")
    @ParameterizedTest
    @ValueSource(ints = {13, 14, 17, 18})
    void valueOfTeenager(int age) {
        double fare = AgeFare.valueOf(age, 1350);
        assertThat(fare).isEqualTo(800);
    }

    @DisplayName("어린이일 경우 350원을 공제하고 50% 할인을 한다.")
    @ParameterizedTest
    @ValueSource(ints = {6, 7, 11, 12})
    void valueOfChildren(int age) {
        double fare = AgeFare.valueOf(age, 1350);
        assertThat(fare).isEqualTo(500);
    }

    @DisplayName("일반인일 경우 할인없이 가격 그대로 적용한다.")
    @ParameterizedTest
    @ValueSource(ints = {5, 19, 30, 55})
    void valueOfNormal(int age) {
        double fare = AgeFare.valueOf(age, 1350);
        assertThat(fare).isEqualTo(1350);
    }

}
