package lv.ctco.javaschool.game.boundary;

import lv.ctco.javaschool.game.entity.UserScoreDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

class GameApiTest {
    GameApi gameApi = new GameApi();

    @Test
    void sortWinnerList_positive() {
        List<UserScoreDto> list = new ArrayList<>();
        UserScoreDto dto11 = new UserScoreDto();
        dto11.setUsername("user1");
        dto11.setHit(1);
        list.add(dto11);

        UserScoreDto  dto22 = new UserScoreDto();
        dto22.setUsername("user2");
        dto22.setHit(2);
        list.add(dto22);

        UserScoreDto dto133 = new UserScoreDto();
        dto133.setUsername("user1");
        dto133.setHit(33);
        list.add(dto133);

        UserScoreDto dto135 = new UserScoreDto();
        dto135.setUsername("user1");
        dto135.setHit(35);
        list.add(dto135);

        UserScoreDto dto350 = new UserScoreDto();
        dto350.setUsername("user3");
        dto350.setHit(50);
        list.add(dto350);

        List<UserScoreDto> result = gameApi.sortWinnerList(list);
        assertThat(result, contains(dto11, dto22, dto350));
    }
}