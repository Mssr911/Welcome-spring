package Hello.Lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/api")
class LangServlet {

    private final Logger logger = LoggerFactory.getLogger(LangServlet.class);

    private LangService service;

    public LangServlet(LangService service) {
        this.service = service;
    }

    @GetMapping("/langs")
    ResponseEntity<List<LangDTO>> findAllLanguages() {
        logger.info("Got request");
        return ResponseEntity.ok(service.findAll());
    }
}
