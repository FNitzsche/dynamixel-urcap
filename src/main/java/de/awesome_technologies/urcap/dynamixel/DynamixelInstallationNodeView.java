package de.awesome_technologies.urcap.dynamixel;

import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeView;

import javax.swing.*;

public class DynamixelInstallationNodeView implements SwingInstallationNodeView<DynamixelInstallationContribution> {

    DynamixelInstallation dynamixelInstallation;

    @Override
    public void buildUI(JPanel panel, DynamixelInstallationContribution contribution) {
        dynamixelInstallation = new DynamixelInstallation(contribution.apiProvider, contribution.model);
        panel.add(dynamixelInstallation.getBasePanel());
    }
}
