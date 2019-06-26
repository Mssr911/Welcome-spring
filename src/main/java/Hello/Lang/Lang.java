package Hello.Lang;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Lang {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Integer id;
    private String welcome;
    private String code;

    public Lang(Integer id, String welcome, String code) {
        this.id = id;
        this.welcome = welcome;
        this.code = code;
    }

    public Lang() {
    }

    public Integer getId() {
        return id;
    }

    public String getWelcome() {
        return welcome;
    }

    public String getCode() {
        return code;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
