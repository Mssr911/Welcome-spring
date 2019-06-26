package Hello.Lang;

public class LangDTO {

    private Integer id;
    private String code;
    private Lang lang;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LangDTO(Lang lang) {
        this.id = lang.getId();
        this.code = lang.getCode();
    }

}
