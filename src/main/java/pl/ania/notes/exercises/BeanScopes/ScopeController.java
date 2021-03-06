package pl.ania.notes.exercises.BeanScopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeController {

    //czy musi być adnotacja @Autowired?
    @Autowired
    private Customer customer;

    @RequestMapping("/nameSingleton")
    public String name() {
        String result = customer.getCustomerName();
        customer.setCustomerName("Adam", "Johnson");
        return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerName();
    }

    @RequestMapping("/namecheckSingleton")
    public String namecheck() {
        return "check Data: " + customer.getCustomerName();
    }

    @RequestMapping("/languagePrototype")
    public String language() {
        String result = customer.getCustomerLanguage();
        //customer.setCustomerLanguage("French") //this command creates new instance of Language
        return "init Data: " + result + "|-----| modified Data: " + customer.setCustomerLanguage("French");
    }

    @RequestMapping("/languagecheckPrototype")
    public String languagecheck() {
        return "check Data: " + customer.getCustomerLanguage();
    }

    @RequestMapping("/addressRequest")
    public String address() {
        String result = customer.getCustomerAddress();
        customer.setCustomerAddress("EU");
        return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerAddress();
    }

    @RequestMapping("/addresscheckRequest")
    public String addresscheck() {
        return "check Data: " + customer.getCustomerAddress();
    }

    @RequestMapping("/ageSession")
    public String age() {
        String result = customer.getCustomerAge();
        customer.setCustomerAge("25");
        return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerAge();
    }

    @RequestMapping("/agecheckSession")
    public String agecheck() {
        return "check Data: " + customer.getCustomerAge();
    }
}
