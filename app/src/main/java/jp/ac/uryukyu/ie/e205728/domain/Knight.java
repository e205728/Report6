package jp.ac.uryukyu.ie.e205728.domain;

public class Knight extends LivingThing{

    private int round;

    /**
     * 名前、HP、攻撃力を指定するコンストラクタ。
     * @param name Warriorの名前
     * @param maximumHP Warriorの体力
     * @param attack Warriorの攻撃力
     */
    public Knight(String name, int maximumHP, int attack){
        super(name, maximumHP, attack);
        this.round = 0;

        System.out.println("================================================================");
        System.out.printf("騎士団朝%sが国王の命令をもらって魔王を討伐に参りました。\n", name);
        System.out.printf("騎士団長%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    @Override
    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("騎士%sは魔王に敵わず、死んでしまいました。\n", getName());
        }
    }
}
