package jp.ac.uryukyu.ie.e205728.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
@Getter
@Setter
public abstract class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
    }

    /**
     * 攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(hitPoint > 0){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage); 
        }
    }
    public String getName(){
        return this.name;
    }
    /**
      *getterメソッドを用意し,private指定したhitpointにアクセス可能にする
     */
    public int getHitPoint(){
        return this.hitPoint;
    }
    /**
     * getterメソッドを用意し,private指定したattackにアクセス可能にする
     */
    public int getAttack(){
        return this.attack;
    }
    /**
     * getterメソッドを用意し,private指定したdeadにアクセス可能にする
     */
     public boolean getDead(){
            return this.dead;
    }
    /**
     * フィールドname setterメソッドを用意する
     * @param name フィールドnameに代入する
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * フィールドhitPoint setterメソッドを用意する
     * @param hitPoint フィールドhitpointに代入する
     */
    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }
    /**
     * フィールドattack setterメソッドを用意する
     * @param attack フィールドattackに代入する
     */
    public void setAttack(int attack){
        this.attack = attack;
    }
    /**
     * フィールドdead setterメソッドを用意する
     * @param dead フィールドdeadに代入する
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }


    /**
     * @param damage もらったダメージ
     */
    public abstract void wounded(int damage);
}