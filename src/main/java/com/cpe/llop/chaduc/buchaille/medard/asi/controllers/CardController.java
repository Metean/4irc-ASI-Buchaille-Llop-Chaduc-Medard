package com.cpe.llop.chaduc.buchaille.medard.asi.controllers;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cpe.llop.chaduc.buchaille.medard.asi.models.dto.CardFormDTO;

@Controller
public class CardController {

    @Autowired
    CardDAO cardDAO;

    // Afficher carte
    @RequestMapping(value = { "/view"}, method = RequestMethod.GET)
    public String view(Model model) {
        model.addAttribute("myCard", cardDAO.getRandomCard());
        return "cardView";
    }

    // Afficher form
    @RequestMapping(value = { "/addCard"}, method = RequestMethod.GET)
    public String addcard(Model model) {
        CardFormDTO cardForm = new CardFormDTO();
        model.addAttribute("cardForm", cardForm);
        return "cardForm";
    }

    // Traiter form et afficher carte
    @RequestMapping(value = { "/addCard"}, method = RequestMethod.POST)
    public String addcard(Model model, @ModelAttribute("cardForm") CardFormDTO cardForm) {
        Card c = cardDAO.addCard(
                cardForm.getId(),
                cardForm.getPrice(),
                cardForm.getName(),
                cardForm.getDescription(),
                cardForm.getImgUrl(),
                cardForm.getFamily(),
                cardForm.getAffinity(),
                cardForm.getHp(),
                cardForm.getEnergy(),
                cardForm.getAttack(),
                cardForm.getDefense()
        );
        model.addAttribute("myCard", c);
        return "cardView";
    }

}
