package jp.ac.uryukyu.ie.e205728.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTest {
    /**
     * 検証手順
     *  (1) ヒーローと敵を準備。ヒーローの攻撃力は敵を一撃で倒せるほど強い状態とする。
     *  (2) ヒーローが殴り、敵は一撃で倒されていることを期待。
     *  (3) 敵が死んでいる、つまり死亡フラグ立ってること
     */
    @Test
    void deathTest() {
        Hero demoHero = new Hero("デモ勇者", 1000, 1000, true, true);
        Demon slime = new Demon("スライムもどき", 10, 10);
        demoHero.attack(slime);
        assertEquals(slime.isDead(), true);
    }
}
