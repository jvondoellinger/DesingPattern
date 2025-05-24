import pack.PersonFactory;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        List<Exception> exs = new ArrayList<>();
        var legalName = "Global Internet S/A";
        var physicalName = "João";

        try {
            PersonFactory.getPhysicalPerson(physicalName, "");
        } catch (Exception ex) {
            exs.add(ex);
        }

        try {
            PersonFactory.getPhysicalPerson(physicalName, null);
        } catch (Exception ex) {
            exs.add(ex);
        }

        try {
            PersonFactory.getPhysicalPerson(physicalName, "123.123.123-12");
        } catch (Exception ex) {
            exs.add(ex);
        }

        try {
            PersonFactory.getLegalPerson(legalName, "");
        } catch (Exception ex) {
            exs.add(ex);
        }

        try {
            PersonFactory.getLegalPerson(legalName, null);
        } catch (Exception ex) {
            exs.add(ex);
        }

        try {
            PersonFactory.getLegalPerson(legalName, "11.111.111/0001-11");
        } catch (Exception ex) {
            exs.add(ex);
        }

        System.out.println("Total de erros: " + exs.size());

        for (Exception e : exs) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fim!");
    }
}
