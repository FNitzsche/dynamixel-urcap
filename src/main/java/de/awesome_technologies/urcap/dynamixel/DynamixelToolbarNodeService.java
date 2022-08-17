package de.awesome_technologies.urcap.dynamixel;

import com.ur.urcap.api.contribution.toolbar.ToolbarConfiguration;
import com.ur.urcap.api.contribution.toolbar.ToolbarContext;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarContribution;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarService;

import javax.swing.*;

public class DynamixelToolbarNodeService implements SwingToolbarService {
    @Override
    public Icon getIcon() {
        Icon icon = new ImageIcon(getClass().getResource("/icons/acme_logo.png"));
        return icon;
    }

    @Override
    public void configureContribution(ToolbarConfiguration configuration) {
        configuration.setToolbarHeight(250);
    }

    @Override
    public SwingToolbarContribution createToolbar(ToolbarContext context) {
        return new DynamixelToolbarContribution(context);
    }
}
