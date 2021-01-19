package jp.ac.uryukyu.ie.e205728.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {
    /**
     * 検証手順
     *  (1) ナイトと敵を準備。敵の攻撃力はナイトを一撃で倒せるほど強い状態とする。
     *  (2) 敵が殴り、ナイトは一撃で倒されていることを期待。
     *  (3) ナイトが死んでいる、つまり死亡フラグ立ってること
     */
    @Test
    void deathTest() {
        Hero demoHero = new Hero("デモ勇者", 1000, 1000, true, true);
        Demon slime = new Demon("スライムもどき", 10, 10);
        demoHero.attack(slime);
        assertEquals(slime.getDead(), true);
    }
}
