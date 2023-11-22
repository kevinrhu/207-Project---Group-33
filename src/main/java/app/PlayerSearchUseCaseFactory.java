package main.java.app;

import main.java.interface_adapter.ViewManagerModel;
import main.java.interface_adapter.compare.CompareViewModel;
import main.java.interface_adapter.id_search.IDSearchViewModel;
import main.java.interface_adapter.navigation.NavigationViewModel;
import main.java.interface_adapter.player_search.PlayerSearchController;
import main.java.interface_adapter.player_search.PlayerSearchPresenter;
import main.java.interface_adapter.player_search.PlayerSearchViewModel;
import main.java.use_case.id_search.IDSearchDataAccessInterface;
import main.java.use_case.player_search.PlayerSearchDataAccessInterface;
import main.java.use_case.player_search.PlayerSearchInputDataBoundary;
import main.java.use_case.player_search.PlayerSearchInteractor;
import main.java.use_case.player_search.PlayerSearchOutputBoundary;
import main.java.view.MainMenuView;
import main.java.view.PlayerSearchView;

public class PlayerSearchUseCaseFactory {
    private PlayerSearchUseCaseFactory(){}

    public static PlayerSearchView create (ViewManagerModel viewManagerModel, NavigationViewModel navigationViewModel, PlayerSearchViewModel playerSearchViewModel, PlayerSearchDataAccessInterface playerSearchDataAccessInterface, IDSearchDataAccessInterface idSearchDataAccessInterface){
        PlayerSearchController playerSearchController = createPlayerSearchController(viewManagerModel, navigationViewModel, playerSearchViewModel, playerSearchDataAccessInterface, idSearchDataAccessInterface);
        return new PlayerSearchView(playerSearchController, playerSearchViewModel);
    }

    private static PlayerSearchController createPlayerSearchController(ViewManagerModel viewManagerModel, NavigationViewModel navigationViewModel, PlayerSearchViewModel playerSearchViewModel, PlayerSearchDataAccessInterface playerSearchDataAccessInterface, IDSearchDataAccessInterface idSearchDataAccessInterface){
        PlayerSearchOutputBoundary playerSearchOutputBoundary = new PlayerSearchPresenter(playerSearchViewModel, navigationViewModel, viewManagerModel);
        PlayerSearchInputDataBoundary playerSearchInputDataBoundary = new PlayerSearchInteractor(playerSearchDataAccessInterface, playerSearchOutputBoundary, idSearchDataAccessInterface);
        return new PlayerSearchController(playerSearchInputDataBoundary);
    }
}