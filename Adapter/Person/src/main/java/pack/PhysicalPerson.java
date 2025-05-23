package pack;

public class PhysicalPerson implements PersonAdapter {
    protected PhysicalPerson() {}

    private String username;
    private String cpf;

    @Override
    public String getRegistry() {
        return getCpf();
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return cpf;
    }

    public String getUsername() {
        return username;
    }


}
