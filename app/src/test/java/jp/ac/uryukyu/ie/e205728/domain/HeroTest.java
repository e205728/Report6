package jp.ac.uryukyu.ie.e205728.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroTest {
    /**
     * 検証手順
     *  (1) ヒーロ用意する、エクスカリバーもアヴァロンの加護も与えない
     *  (2) 攻撃、HP変わらないことを期待
     */
    @Test
    void noBlessTest() {
        int hp = 100;
        int attack = 20;
        Hero demoHero = new Hero("デモ勇者", hp, attack, false, false);
        assertTrue(demoHero.getHitPoint() == hp);
        assertTrue(demoHero.getAttack() == attack);
    }

    /**
     * 検証手順
     *  (1) ヒーロ用意する、エクスカリバーの加護のみ与える
     *  (2) 攻撃が100倍、HP変わらないことを期待
     */
    @Test
    void onlyExcaliburTest() {
        int hp = 100;
        int attack = 20;
        Hero demoHero = new Hero("デモ勇者", hp, attack, true, false);
        assertTrue(demoHero.getHitPoint() == hp);
        assertTrue(demoHero.getAttack() == attack * 100);
    }

    /**
     * 検証手順
     *  (1) ヒーロ用意する、アヴァロンの加護のみ与える
     *  (2) 攻撃が100倍、HP変わらないことを期待
     */
    @Test
    void onlyAvalonTest() {
        int hp = 100;
        int attack = 20;
        Hero demoHero = new Hero("デモ勇者", hp, attack, false, true);
        assertTrue(demoHero.getHitPoint() == hp * 2);
        assertTrue(demoHero.getAttack() == attack );
    }

    /**
     * 検証手順
     *  (1) ヒーロ用意する、エクスカリバーとアヴァロンの加護のみ与える
     *  (2) 攻撃が100倍、HPが2倍であることを期待
     */
    @Test
    void ExcaliburAvalonTest() {
        int hp = 100;
        int attack = 20;
        Hero demoHero = new Hero("デモ勇者", hp, attack, true, true);
        assertTrue(demoHero.getHitPoint() == hp * 2);
        assertTrue(demoHero.getAttack() == attack * 100 );
    }
}
