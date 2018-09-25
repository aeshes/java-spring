package app.web;

import app.data.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private MessageRepository repository;

    @Autowired
    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute(repository.find(Long.MAX_VALUE, 20));
        return "messages";
    }
}
