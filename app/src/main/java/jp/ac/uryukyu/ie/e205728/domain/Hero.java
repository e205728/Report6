package jp.ac.uryukyu.ie.e205728.domain;

/**
 * LivingThingを継承したクラス
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 */
public class Hero extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero(String name, int maximumHP, int attack, boolean getExcalibur, boolean getAvalon){
        super(name, maximumHP, attack);

        System.out.println("================================================================");
        System.out.printf("仕方がありません！姫が異世界より勇者%sを召喚しました。\n", name);
        System.out.printf("勇者%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
        System.out.printf("勇者%sよ、どうかこの世界を救ってください\n", name);
        System.out.println("----------------------------------------------------------------");
        System.out.printf("勇者%sは旅を出ました。\n", name);
        System.out.println("----------------------------------------------------------------");
        eventExcalibur(getExcalibur);
        System.out.println("----------------------------------------------------------------");
        eventAvalon(getAvalon);
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
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }

    public void eventExcalibur(boolean getExcalibur){
        System.out.printf("勇者%sがブリテン島に到着ました。岩に見知らぬ剣が刺さってました。\n", getName());
        System.out.printf("勇者%sが剣を抜こうと試みました。\n", getName());

        if(getExcalibur){
            int formerAttack = getAttack();
            setAttack(formerAttack * 100);
            System.out.printf("勇者%sが見事に「聖剣：エクスカリバー」を抜けました。\n", getName());
            System.out.printf("勇者%sが聖剣エクスカリバーの効果をもらいました：円卓の加護のもとに、攻撃力*100。\n", getName());
            System.out.printf("勇者%sのHPは%d。攻撃力は%d -> %d です。\n", getName(), getHitPoint(), formerAttack, getAttack());
        }else {
            System.out.printf("勇者%sが剣に手をつけた瞬間、正義感のあまりに剣を放棄しました。\n", getName());
        }
        System.out.printf("勇者%sは旅を続けました。\n", getName());
    }

    public void eventAvalon(boolean getAvalon){
        System.out.printf("勇者%sがアヴァロン島に到着ました。三人の湖の乙女に出会いました。\n", getName());
        System.out.printf("勇者%sは湖の乙女に、舟で湖の中心へ行こうと誘われました。\n", getName());

        if(getAvalon){
            int formerHitPoint = getHitPoint();
            setHitPoint(formerHitPoint * 2);
            System.out.printf("勇者%sが湖をすごく気に入りました。死後自分の遺体をここに埋めたいと願いました。\n", getName());
            System.out.printf("湖の乙女の加護により、一度致命傷受けても再生できる能力を手に入れました。勇者のHP*2。\n");
            System.out.printf("勇者%sのHPは%d　-> %d。攻撃力は%dです。\n", getName(), formerHitPoint, getHitPoint(), getAttack());

        }else {
            System.out.printf("勇者%sが年上がタイプのため、湖の乙女の誘いを断りました。\n", getName());
        }
        System.out.printf("勇者%sは魔王城に着きました。\n", getName());
    }
}
