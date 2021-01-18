package jp.ac.uryukyu.ie.e205728.domain;

/**
 * LivingThingを継承したクラス
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 */
public class Demon extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Demon(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);

        System.out.println("================================================================");
        System.out.printf("魔王%sが復活しました。", name);
        System.out.printf("魔王%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     *死亡時のメッセージを変更するためにオーバーライドしている。
     */
    @Override
    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("魔王%sは倒れました。\n", getName());
        }
    }
   

}
