package de.awesome_technologies.urcap.dynamixel;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.installation.ContributionConfiguration;
import com.ur.urcap.api.contribution.installation.CreationContext;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeService;
import com.ur.urcap.api.domain.data.DataModel;

import java.util.Locale;

public class DynamixelInstallationNodeService implements SwingInstallationNodeService<DynamixelInstallationContribution, DynamixelInstallationNodeView> {

    @Override
    public void configureContribution(ContributionConfiguration configuration) {

    }

    @Override
    public String getTitle(Locale locale) {
            return "Dynamixel";
    }

    @Override
    public DynamixelInstallationNodeView createView(ViewAPIProvider apiProvider) {
        return new DynamixelInstallationNodeView();
    }

    @Override
    public DynamixelInstallationContribution createInstallationNode(InstallationAPIProvider apiProvider, DynamixelInstallationNodeView view, DataModel model, CreationContext context) {
        return new DynamixelInstallationContribution(apiProvider, model);
    }
}
