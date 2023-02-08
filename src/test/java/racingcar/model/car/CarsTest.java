package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestDataManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 전진 테스트")
    @Test
    void movingCarsTest() {
        // given
        Cars cars = TestDataManager.getCarsByStrategies();

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        String carsPositionFormat = cars.getCarsPositionFormat();
        // then
        assertThat(carsPositionFormat)
                .contains("pobi : ---")
                .contains("crong : -");
    }


    @DisplayName("우승한 자동차 선별 테스트")
    @Test
    void winnerCarTest() {
        // given
        Cars cars = TestDataManager.getCarsByStrategies();

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        Cars winnerCars = cars.getWinnerCars();

        // then
        assertThat(winnerCars.getCarsWinnerFormat())
                .contains("pobi")
                .doesNotContain("crong");

    }

    @DisplayName("공동 우승 출력 테스트")
    @Test
    void winnerCarFormatTest() {
        // given
        Cars cars = TestDataManager.getCarsByStrategies();

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        Cars winnerCars = cars.getWinnerCars();

        // then
        assertThat(winnerCars.getCarsWinnerFormat())
                .contains("pobi")
                .contains("eddy");

    }

}