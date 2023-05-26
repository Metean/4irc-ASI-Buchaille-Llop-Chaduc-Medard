package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import com.cpe.llop.chaduc.buchaille.medard.asi.services.CardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.CardFormDTO;

import java.util.Arrays;
import java.util.List;

@Controller
public class CardController {

    @Autowired
    CardServiceImpl cardDAO;

    // Accueil
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String index(Model model) {
        return "cardList";
    }

    // Afficher carte random
    @RequestMapping(value = { "/card"}, method = RequestMethod.GET)
    public String card(Model model) {
        model.addAttribute("myCard", cardDAO.getRandomCard());
        return "cardView";
    }

    // Afficher carte précise
    @RequestMapping(value = { "/card/{id}"}, method = RequestMethod.GET)
    public String cardId(Model model, @PathVariable("id") int id) {
        model.addAttribute("myCard", cardDAO.getCard(id));
        return "cardView";
    }

    // Afficher form
    @RequestMapping(value = { "/addCard"}, method = RequestMethod.GET)
    public String addcard(Model model) {
        List<String> allTypes = Arrays.asList("Acier", "Combat", "Dragon", "Eau", "Electrik", "Fée", "Feu",
                                "Glace", "Insecte", "Normal", "Plante", "Poison", "Psy", "Roche",
                                "Sol", "Spectre", "Ténèbres", "Vol");
        CardFormDTO cardForm = new CardFormDTO();

        model.addAttribute("allTypes", allTypes);
        model.addAttribute("cardForm", cardForm);
        return "cardForm";
    }

    // Traiter form et afficher carte
    @RequestMapping(value = { "/addCard"}, method = RequestMethod.POST)
    public String addcard(Model model, @ModelAttribute("cardForm") CardFormDTO cardForm) {

        int id = 0; // TODO: Id à définir !

        Card c = cardDAO.addCard(
                id,
                cardForm.getPrice(),
                cardForm.getName(),
                cardForm.getDescription(),
                cardForm.getImgUrl(),
                cardForm.getType1(),
                cardForm.getType2(),
                cardForm.getHp(),
                cardForm.getAttack(),
                cardForm.getDefense()
        );
        model.addAttribute("myCard", c);
        return "redirect:/view/" + id;
    }

}
