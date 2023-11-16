package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @DisplayName("방문 예상 날짜를 정상적으로 입력시 통과")
    @Test
    void createReadDate(){
        String input = "25";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Console.close();

        assertThatCode(() -> InputView.readDate())
                .doesNotThrowAnyException();
    }

    @DisplayName("메뉴를 정상적으로 입력시 통과")
    @Test
    void createReadMenu(){
        String input = "티본스테이크-2";

        assertThatCode(() -> InputView.readMenu(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("주문을 정상적으로 입력시 통과")
    @Test
    void createReadOrder(){
        String input = "양송이수프-2,바비큐립-1,제로콜라-2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Console.close();

        assertThatCode(() -> InputView.readOrder())
                .doesNotThrowAnyException();
    }

}