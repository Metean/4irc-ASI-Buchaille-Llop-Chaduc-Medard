package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import org.springframework.stereotype.Service;

@Service
public class CardDAO {
    private List<Card> myCardList;
    private Random randomGenerator;

    public CardDAO() {
        myCardList = new ArrayList<Card>();
        randomGenerator = new Random();
        createCardList();
    }

    private void createCardList() {
        Card c1 = new Card(1, 10, "Pikachu", "Pokemon de type electrique", "https://www.pokepedia.fr/images/thumb/7/76/Pikachu-DEPS.png/640px-Pikachu-DEPS.png", "Electrique", "", 10, 20, 30, 40);
        myCardList.add(c1);
    }
    public List<Card> getCardList() {
        return this.myCardList;
    }
    /*public Card getCardByName(String name){
        for (Card poneyBean : myPoneyList) {
            if(poneyBean.getName().equals(name)){
                return poneyBean;
            }
        }
        return null;
    }*/

    public Card getRandomCard(){
        int index = randomGenerator.nextInt(this.myCardList.size());
        return this.myCardList.get(index);
    }

    public Card addCard(int id, float price, String name, String description, String imgUrl, String family,
                        String affinity, int hp, int energy, int attack, int defense) {
        Card c = new Card(id, price, name, description, imgUrl, family, affinity, hp, energy, attack, defense);
        this.myCardList.add(c);
        return c;
    }
}
