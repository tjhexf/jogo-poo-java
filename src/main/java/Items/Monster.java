package Items;

public class Monster implements Estrutura {
    private int attackValue;
    private int defenseValue;
    private int healthValue;
    //Atributo que vai ser adicionada a recompensa ao matar o monstro
    private String rewardAtributte;
    private int rewardValue;
    private boolean visibility;
    public Monster(){}
    public Monster(int attackValue, int defenseValue, int healthValue, String rewardAtributte, int rewardValue){
        this.attackValue = attackValue;
        this.defenseValue = defenseValue;
        this.healthValue = healthValue;
        this.rewardAtributte = rewardAtributte;
        this.rewardValue = rewardValue;
    }

    public void setVisibility(boolean visibility){
        this.visibility = visibility;
    };

    public void fight(){

    }
    public void attack(){
    }

    public void defend(){
    }
    public int getAttackValue(){
        return this.attackValue;
    }

    public void setAttackValue(int attackValue){
        this.attackValue = attackValue;
    }

    public int getDefenseValue(){
        return this.defenseValue;
    }
    public void setDefenseValue(int defenseValue){
        this.defenseValue = defenseValue;
    }

    public int getHealthValue() {
        return this.attackValue;
    }
    public void setHealthValue(int healthValue){
        this.healthValue = healthValue;
    }

    public String getRewardAtributte (){
        return this.rewardAtributte;
    }
    public void setRewardAtributte(String rewardAtributte){
        this.rewardAtributte = rewardAtributte;
    }
    public int getRewardValue (){
        return this.rewardValue;
    }
    public void setRewardValue(int rewardValue){
        this.rewardValue = rewardValue;
    }

    public void giveReward(Heroi player){
        switch (rewardAtributte) {
            case "attack":
                player.setAtaque(player.getAtaque() + rewardValue);
                 break;
            case "defense":
               player.setDefesa(player.getDefesa() + rewardValue);
                break;
            case "health":
                player.setHealth(player.getHealth() + rewardValue);
                break;
        }

    }
}
