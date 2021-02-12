package lab4.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;


@Controller
public class theController {
    private AddressBookRepository bookRepo;
    private BuddyInfoRepository buddyRepo;

    public theController(AddressBookRepository bookRepo, BuddyInfoRepository buddyRepo) {
        this.bookRepo = bookRepo;
        this.buddyRepo = buddyRepo;
    }
    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }

    @GetMapping("/addressbook")
    public String addressBook(@RequestParam(name="ID", required=true) Integer ID,
                              Model model) {
        model.addAttribute("ID", ID);

        AddressBook book = new AddressBook(Long.valueOf(ID));
        bookRepo.save(book);

        return "addressbook";
    }

    @GetMapping("/addBuddy")
    public String addBuddy(Model model) {
        AddressBook book = new AddressBook(new Long(1));
        model.addAttribute("newBuddy", new BuddyInfo("Bob", "123").getName());
        return "addBuddy";
    }

    @GetMapping("/removeBuddy")
    public String removeBuddy(@RequestParam(name = "name", required = true) String name, Model model) {
        AddressBook book = new AddressBook(new Long(1));
        model.addAttribute("theBuddyName", (book.getBuddy(name)));
        model.addAttribute("removedBuddy", book.removeBuddy(book.getBuddy(name)));
        return "removeBuddy";
    }


}

