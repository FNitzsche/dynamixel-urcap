package de.awesome_technologies.urcap.dynamixel;

import com.ur.urcap.api.contribution.InstallationNodeContribution;
import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;

public class DynamixelInstallationContribution implements InstallationNodeContribution {

    // A reference to the URCap API.
    InstallationAPIProvider apiProvider;
    // A reference to the data model of the installation node.
    public DataModel model;

    public DynamixelInstallationContribution(InstallationAPIProvider apiProvider, DataModel model){
        this.apiProvider = apiProvider;
        this.model = model;
    }

    @Override
    public void openView() {

    }

    @Override
    public void closeView() {

    }

    @Override
    public void generateScript(ScriptWriter writer) {

    }
}
