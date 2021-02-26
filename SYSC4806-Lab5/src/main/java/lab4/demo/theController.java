package lab4.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
    public class theController {
        @Autowired
        AddressBookRepository repository;

        @GetMapping("/")
        public String index(Model model) {
            AddressBook book = new AddressBook(new Long(1));
            model.addAttribute("addressbook", book);
            model.addAttribute("newBuddy", new BuddyInfo());
            return "addressbook";
        }

        @PostMapping("/")
        public String addBuddy(@ModelAttribute BuddyInfo buddy, Model model) {
            AddressBook book  = repository.findById(new Long(1)).orElse(new AddressBook(new Long(1)));
            book.addBuddy(buddy);
            buddy.setAddressBook(book);
            repository.save(book);

            model.addAttribute("addressbook", book);
            model.addAttribute("newBuddy", new BuddyInfo());
            return "addressbook";
        }
    }