package controller;

import domain.Attempt;
import domain.Car;
import domain.Cars;
import java.util.List;
import service.RacingService;
import validator.AttemptValidator;
import view.InputView;
import view.OutputView;

public class RacingController {
    private final RacingService racingService = new RacingService();
    private Cars cars;
    private Attempt attempt;

    public void set() {
        cars = new Cars(InputView.inputCars());

        attempt = new Attempt(InputView.inputAttempt());

        race();
        result();
    }

    public void race() {
        System.out.println("실행 결과");
        for (int i = 0; i < attempt.getAttempt(); i++) {
            racingService.moveCars(cars);
            OutputView.showRoundResult(cars);
        }
    }

    private void result() {
        System.out.print("최종 우승자 : ");
        racingService.getWinners(cars);
    }


}
