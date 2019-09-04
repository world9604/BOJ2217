import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * @문제
         * N(1≤N≤100,000)개의 로프가 있다.
         * 이 로프를 이용하여 이런 저런 물체를 들어올릴 수 있다.
         * 각각의 로프는 그 굵기나 길이가 다르기 때문에 들 수 있는 물체의 중량이 서로 다를 수도 있다.
         * 하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다.
         * k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때,
         * 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
         * 각 로프들에 대한 정보가 주어졌을 때,
         * 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오.
         * 모든 로프를 사용해야 할 필요는 없으며,
         * 임의로 몇 개의 로프를 골라서 사용해도 된다.
         * 단, 각각의 로프는 한 개씩만 존재한다.
         *
         * @입력
         * 첫째 줄에 정수 N이 주어진다.
         * 다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다.
         * 이 값은 10,000을 넘지 않는 정수이다.
         *
         * @출력
         * 첫째 줄에 답을 출력한다.
         *
         * @예제입력
         * 2
         * 10
         * 15
         *
         * 10 15 => 최대 20(maxiumWegiht)
         * 10 + 10 = 20
         *
         * 10 15 => 최대 30
         * 15 + 15 = 30 (X)
         *
         * 10 15 => 최대 15
         * 7.5 + 7.5 = 15 (X)
         *
         * 로프중 가장 작은 중량을 K개 만큼 더해주면 최대 중량이 된다.
         * P1 P2 P3 P4 (P1 값이 가장 작다고 할때)
         * P1 * N = 최대 중량 (X)
         *
         * 1 2 3 4
         * 1 + 1 + 1 + 1 = 4 (X)
         * 2 + 2 + 2 = 6 (O)
         * 3 + 3 = 6 (O)
         * 4 (X)
         *
         * P1 * N
         * P2 * (N - 1)
         * P3 * (N - 2)
         * P4 * (N - 3)
         * 더 큰값으로 리셋 한다.
         *
         * @예제출력
         * 20
         */
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        int weightsByRope[] = new int[inputNum];

        int i = 0;
        for (int rope : weightsByRope) {
            weightsByRope[i] = sc.nextInt();
            i++;
        }

        Arrays.sort(weightsByRope);
        int maximumWeight = new Greedy(weightsByRope).caculate();

        System.out.printf("%d", maximumWeight);
    }
}

class Greedy {
    int[] weightsByRope;

    Greedy(int[] weightsByRope) {
        this.weightsByRope = weightsByRope;
    }

    public int caculate() {
        int maximumWeight = 0;
        for (int i = 0; i < weightsByRope.length; i++) {
            int tmpMaximumWeight = weightsByRope[i] * (weightsByRope.length - i);
            if(maximumWeight < tmpMaximumWeight)
                maximumWeight = tmpMaximumWeight;
        }
        return maximumWeight;
    }
}
