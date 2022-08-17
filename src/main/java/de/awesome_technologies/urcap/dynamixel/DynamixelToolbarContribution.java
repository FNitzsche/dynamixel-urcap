package de.awesome_technologies.urcap.dynamixel;

import com.ur.urcap.api.contribution.toolbar.ToolbarContext;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarContribution;

import javax.swing.*;

public class DynamixelToolbarContribution implements SwingToolbarContribution {

    DynamixelToolbar dynamixelToolbar;
    ToolbarContext context;

    public DynamixelToolbarContribution(ToolbarContext context){
        this.context = context;
    }

    @Override
    public void buildUI(JPanel jPanel) {
        dynamixelToolbar = new DynamixelToolbar(context);
        jPanel.add(dynamixelToolbar.getBasePanel());
    }

    @Override
    public void openView() {

    }

    @Override
    public void closeView() {

    }
}
