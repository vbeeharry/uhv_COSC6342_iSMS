package com.uhv.cosc6342.isms.ui;

/**
 * This is the UI Manager
 */
public class UserInterface {
    
    public static UserInterface ui = null;

    private UIInterface activeUI;
    private EntryPage entryPage;

    /**
     * Constructor
     */
    private UserInterface () {
        init();
    }

    /**
     * Init
     */
    private void init() { 
        entryPage = new EntryPage();
    
        welcome(entryPage);
    }

    /**
     * Welcome
     */
    private void welcome(UIInterface ui) {
        ui.displayTitle();
        ui.displayOptions();

        switch(ui.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            break;

            default:
            wrongEntry();
            welcome(entryPage);
        }
    }

    private void wrongEntry() {
        System.out.println("Invalid entry. Try again !!! \n");
    }

    /**
     * Singleton instance
     */
    public static UserInterface getInstance() {
        if (ui == null) {
            ui = new UserInterface();
        }

        return ui;
    }
}
