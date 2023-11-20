package main.java.view;

import main.java.interface_adapter.player_search.PlayerSearchController;
import main.java.interface_adapter.player_search.PlayerSearchState;
import main.java.interface_adapter.player_search.PlayerSearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class PlayerSearchView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "id search";
    private final PlayerSearchViewModel playerSearchViewModel;
    private final JTextField queryInputField = new JTextField(15);
    private final JLabel result = new JLabel("");
    private final JLabel label = new JLabel("Enter player Id");
    private final JLabel buffer = new JLabel("<html><body><br><br></body></html>");
    private final PlayerSearchController playerSearchController;
    private final JButton search;
    private final JButton back;

    PlayerSearchView(PlayerSearchController playerSearchController, PlayerSearchViewModel playerSearchViewModel){
        this.playerSearchController = playerSearchController;
        this.playerSearchViewModel = playerSearchViewModel;
        this.playerSearchViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(playerSearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        search = new JButton(playerSearchViewModel.SEARCH_LABEL);
        search.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(search)){
                            PlayerSearchState currentstate = playerSearchViewModel.getSearchState();
                            try{
                                playerSearchController.execute(Integer.parseInt(currentstate.getSearch()));
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "An error occured. Please try again.");
                            }
                        }
                    }
                }
        );

        back = new JButton(playerSearchViewModel.BACK_BUTTON_LABEL);
        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)){

                        }
                    }
                }
        );
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
