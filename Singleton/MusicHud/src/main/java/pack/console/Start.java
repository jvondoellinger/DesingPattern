package pack.console;

import pack.console.operations.OperationFactory;

public class Start {

    public static void main(String[] args) {
        System.out.println("""
                Seja bem-vindo!
                Este é a nossa aplicação de musíca, onde vode poder salvar o nome de todas as músicas que você quer assistir, mas sempre esquece os nomes na hora de baixar...
                
                Agora, de acordo com as opções abaixo, selecione a operação que você deseja realizar!
                """);
        var initial = OperationFactory.getInitialOperation();
        initial.start();
    }
}
