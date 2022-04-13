package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동자 준비자")
class CarPreparerTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> CarPreparer.of(CarFactory.of(NameWriter.from("abc"), () -> Movement.MOVE), Distance.ONE));
    }

    @Test
    @DisplayName("생산자와 초기 거리는 필수")
    void instance_nullArgument_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> CarPreparer.of(CarFactory.of(NameWriter.from("abc"), () -> Movement.MOVE), null));
        assertThatIllegalArgumentException().isThrownBy(() -> CarPreparer.of(null, Distance.ONE));
    }

    @Test
    @DisplayName("경주로들 준비")
    void tracks() {
        //given, when
        Tracks tracks = CarPreparer.of(CarFactory.of(NameWriter.from("abc,123"), () -> Movement.MOVE), Distance.ONE).tracks();
        //then
        assertThat(tracks.size()).isEqualTo(2);
    }
}
