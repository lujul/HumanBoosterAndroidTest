package com.androidand.test;

/**
 * Created by Human Booster on 26/09/2016.
 */

public class Intervalle {
    private int inf;
    private int sup;

    public Intervalle( int inf,int sup){
        this.inf=inf;
        this.sup=sup;
        if (inf>sup){
            this.inf=sup;
            this.sup=inf;
        }
    }
    public boolean contient(int x){
        if(inf <= x && x <= sup){
            return true;
        }else {
            return false;
        }
    }
    public boolean contient (Intervalle i){
        int intervInf =i.getInf();
        int intervSup =i.getSup();
         if (inf <=intervInf && intervSup<= sup){
             return true;
         }else{
             return false;
         }
    }
    public boolean estDisjointDe(Intervalle i){
        int intervInf =i.getInf();
        int intervSup =i.getSup();
        if(intervInf<inf&&intervSup<inf || intervInf>inf&&intervSup>sup ){
            return true;
        }else {
            return false;
        }
    }
    public boolean intersecte(Intervalle i){
        int intervInf =i.getInf();
        int intervSup =i.getSup();
        if(inf<=intervSup||intervInf<=sup){
            return true;
        }else{
            return false;
        }
    }
    public Intervalle intersection(Intervalle i){
        int intervInf =i.getInf();
        int intervSup =i.getSup();
        if(intersecte(i)){
            if(inf<=intervSup){
                return new Intervalle(inf,intervSup);
            }
            else{
                return new Intervalle(intervInf,sup);
            }
        } else {
            return null;
        }
    }

    public Boolean equals (Intervalle i){
        if((i.getInf()==inf) &&(i.getSup()==sup)){
            return true;
        }else{
            return false;
        }
    }
    public String toString(){

        return "[ "+String.valueOf(inf)+";"+String.valueOf(sup)+"]";
    }
    public int getInf() {

        return inf;
    }
    public void setInf(int inf) {

        this.inf = inf;
    }
    public int getSup() {

        return sup;
    }
    public void setSup(int sup) {

        this.sup = sup;
    }
}
