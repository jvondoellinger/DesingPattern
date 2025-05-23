package pack;

public class LegalPerson implements PersonAdapter {
    protected LegalPerson() {}

    private String username;

    @Override
    public String getRegistry() {
        return getCnpj();
    }

    private String cnpj;

    protected void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getCnpj() {
        return cnpj;
    }
}
