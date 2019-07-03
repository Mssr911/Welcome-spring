package Hello.Welcome;

import Hello.Lang.Lang;
import Hello.Lang.LangRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class HelloService {

    static final String FALLBACK_NAME = "Unknown";
    static final Lang FALLBACK_LANG = new Lang(1, "Hello", "en");
    private LangRepository repository;

    HelloService(LangRepository repository) {
        this.repository = repository;
    }

    /**
     * Ta metoda przygotowuje powitanie szukając po ID języka
     */
    String prepareGreetingById(String imie, Integer langId) {
        langId = Optional.ofNullable(langId).orElse(FALLBACK_LANG.getId());
        var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcome();
        return welcomeMsg + " " + Optional.ofNullable(imie).orElse(FALLBACK_NAME) + "!";
    }

}
