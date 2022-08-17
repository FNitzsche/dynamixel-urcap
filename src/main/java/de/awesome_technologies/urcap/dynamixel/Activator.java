package de.awesome_technologies.urcap.dynamixel;

import com.ur.urcap.api.contribution.installation.swing.SwingInstallationNodeService;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	@Override
	public void start(final BundleContext context) throws Exception {
		context.registerService(SwingToolbarService.class, new DynamixelToolbarNodeService(), null);
		context.registerService(SwingInstallationNodeService.class, new DynamixelInstallationNodeService(), null);
		}

	@Override
	public void stop(BundleContext context) throws Exception {
	}
}
