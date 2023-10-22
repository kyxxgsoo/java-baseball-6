package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    // 입력된 숫자 유효성 검사
    public static boolean checkValidation(String inputString) {
        // 입력된 숫자가 세 자리인지 체크
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요. 프로그램을 종료합니다.");
        }

        // 입력된 숫자가 (0~9)사이의 문자인지 체크
        if (!checkNumber(inputString)) {
            throw new IllegalArgumentException("숫자가 아닙니다. 프로그램을 종료합니다.");
        }

        // 입력된 숫자의 중복 체크
        if (!checkDuplication(inputString)) {
            throw new IllegalArgumentException("중복된 값을 입력했습니다. 프로그램을 종료합니다.");
        }

        return true;
    }

    // 입력된 숫자가 정수인지 체크
    public static boolean checkNumber(String inputString) {
        try {
            int number = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // 입력된 숫자가 중복인지 체크
    public static boolean checkDuplication(String inputString) {
        boolean[] checkArray = new boolean[10];

        for (int i = 0; i < inputString.length(); i++) {
            int intNumber = inputString.charAt(i) - '0';
            if (checkArray[intNumber]) {
                return false;
            } else {
                checkArray[intNumber] = true;
            }
        }
        return true;
    }

    // 컴퓨터가 랜덤 넘버를 생성
    public static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // String -> List<integer>로 파싱
    public static List<Integer> stringToList(String inputString) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            int number = inputString.charAt(i) - '0';
            if (1 <= number && number <= 9) {
                list.add(number);
            } else {
                throw new IllegalArgumentException("숫자가 아닙니다. 프로그램을 종료합니다.");
            }
        }

        return list;
    }

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = createRandomNumber();
        
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String number = camp.nextstep.edu.missionutils.Console.readLine();
            if (checkValidation(number)) {
                List<Integer> inputList = stringToList(number);

            }
        }
    }
}