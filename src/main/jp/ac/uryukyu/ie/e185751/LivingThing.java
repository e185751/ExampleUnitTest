package jp.ac.uryukyu.ie.e185751;
/**
 * LivingThingクラス。
 *  String name; //キャラクターの名前
 *  int hitPoint; //キャラクターのHP
 *  int attack; //キャラクターの攻撃力
 *  boolean dead; //キャラクターの生死状態。true=死亡。
 * Created by e185751 on 2018/11/11.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;


    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name キャラクターの名
     * @param maximumHP キャラクターのHP
     * @param attack キャラクターの攻撃力
     */
    public LivingThing(String name, int maximumHP, int attack){
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }


    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead(){
        return dead;
    }


    /**
     * キャラクターの名前を保存する変数nameのgetterメソッド。
     * @return String
     */
    public String getName(){
        return name;
    }


    /**
     * キャラクターのHPのデータを保存する変数hitPointのgetterメソッド。
     * @return int
     */
    public int getHitPoint(){
        return hitPoint;
    }


    /**
     * キャラクターの攻撃力のデータを保存する変数attackのgetterメソッド。
     * @return int
     */
    public int getAttack(){
        return attack;
    }


    /**
     * キャラクターの生死状態を保存する変数deadを書き換えるsetterメソッド。
     * @param dead　生死状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }


    /**
     * キャラクターのHPを保存する変数hitPointを書き換えるsetterメソッド。
     * @param hp HP
     */
    public void setHitPoint(int hp){
        this.hitPoint = hp;
    }


    /**
     * キャラクターの攻撃力を保存する変数attackを書き換えるsetterメソッド。
     * @param attack 攻撃力
     */
    public void setAttack(int attack){
        this.attack = attack;
    }


    /**
     * キャラクターの名前を保存する変数nameを書き換えるsetterメソッド。
     * @param name 名前
     */
    public void setName(String name){
        this.name = name;
    }


    /**
     * opponentへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if (!dead) {
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    
    /**
     * キャラクター自身へ攻撃されたときのダメージ処理をするメソッド。オーバーライドされる。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}