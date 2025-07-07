package menu;

import anootation.BadCode;
import configuration.singleton.RepositoryConfiguration;
import configuration.singleton.ScannerConfiguration;
import service.GameService;

public class MenuFactory {
    private MenuFactory() {}

    @BadCode
    public static IMenu getGameManagementMenu() {
        try {
            var repository = RepositoryConfiguration.getInstance();
            var scanner = ScannerConfiguration.getInstance();
            var service = new GameService(repository); // To Improve
            return new GameMenu(scanner, service);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
