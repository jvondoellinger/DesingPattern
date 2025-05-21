package pack.console.operations;

import java.util.Scanner;

public class InitialOptions implements OperationConsole {

    private Scanner scanner;
    public InitialOptions(Scanner scanner) {
        this.scanner = scanner;
    }

    private int readInt() {
        String input = scanner.next();
        try {
            return Integer.parseInt(input);
        } catch (RuntimeException e) {
            return -1;
        }
    }

    @Override
    public void start() {
        var text = """
            ( 1 ) - Adicionar nova música
            ( 2 ) - Remover uma musica
            ( 3 ) - Listar musicas
            ( 4 ) - Corrigir
            ( 5 ) - Fechar...
            """;
        System.out.println(text);
        var line = readInt();
        while (line != 5) {
            switch (line) {
                case 1:
                    OperationFactory.getAddOperation().start();
                    break;
                case 2:
                    OperationFactory.getPrintAllOperation().start();
                    OperationFactory.getRemoveOperation().start();
                    break;
                case 3:
                    OperationFactory.getPrintAllOperation().start();
                    break;
                case 4:
                    OperationFactory.getPrintAllOperation().start();
                    OperationFactory.getUpdateOperation().start();
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
            System.out.println(text);
            line = readInt(); // to select another option
        }
    }
}
