package jp.ac.uryukyu.ie.e205728.presenter;

import jp.ac.uryukyu.ie.e205728.domain.Demon;
import jp.ac.uryukyu.ie.e205728.domain.Hero;
import jp.ac.uryukyu.ie.e205728.domain.Knight;
import jp.ac.uryukyu.ie.e205728.domain.LivingThing;

public class Quest {

    public void story(){
        Demon demon = new Demon("サタン", 60, 30);
        Knight knight = new Knight("グレイグ", 10, 5);

        if(!peaceBack(demon, knight)){
            Hero hero = new Hero("アーサー", 50, 20, randomDice(), randomDice());
            peaceBack(demon, hero);
        }
        System.out.println("================================================================");

        if(demon.getDead()){
            System.out.printf("世界が平和に戻りました。\n");
        }else {
            System.out.printf("世界が滅んでしまいました。\n");
        }

        System.out.println("The End");
    }

    public boolean peaceBack(LivingThing enemy, LivingThing hero){
        System.out.println("================================================================");
        System.out.printf("%s vs. %s\n", hero.getName(), enemy.getName());

        int turn = 0;
        while( hero.getDead() == false && enemy.getDead() == false ){
            System.out.println("----------------------------------------------------------------");
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            hero.attack(enemy);
            enemy.attack(hero);
        }
        return enemy.getDead();
    }

    public boolean randomDice(){
        double change = Math.random();
        return change >= 0.5;
    }


}
