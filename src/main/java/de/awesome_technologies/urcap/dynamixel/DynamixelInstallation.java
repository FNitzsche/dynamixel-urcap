package de.awesome_technologies.urcap.dynamixel;

import com.ur.urcap.api.contribution.installation.InstallationAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DynamixelInstallation {
    private JTextField amte;
    private JTextField amgp;
    private JTextField ampp;
    private JTextField di;
    private JTextField brate;
    private JTextField devname;
    private JPanel basePanel;
    private JTextField maxSteps;

    public DynamixelInstallation(InstallationAPIProvider apiProvider, DataModel dataModel) {
        amte.setText(String.valueOf(dataModel.get("ADDR_MX_TORQUE_ENABLE", 24)));
        amgp.setText(String.valueOf(dataModel.get("ADDR_MX_GOAL_POSITION", 30)));
        ampp.setText(String.valueOf(dataModel.get("ADDR_MX_PRESENT_POSITION", 36)));
        di.setText(String.valueOf(dataModel.get("DXL_ID", 1)));
        brate.setText(String.valueOf(dataModel.get("BAUDRATE", 57600)));
        devname.setText(dataModel.get("DEVICENAME", "/dev/ttyUSB0"));
        maxSteps.setText(String.valueOf(dataModel.get("MAX_STEPS", 4096)));

        KeyboardInputCallback<Integer> amtecallback = new KeyboardInputCallback<Integer>() {
            @Override
            public void onOk(Integer value) {
                amte.setText(String.valueOf(value));
                dataModel.set("ADDR_MX_TORQUE_ENABLE", value);
            }
        };
        KeyboardInputCallback<Integer> amgpcallback = new KeyboardInputCallback<Integer>() {
            @Override
            public void onOk(Integer value) {
                amgp.setText(String.valueOf(value));
                dataModel.set("ADDR_MX_GOAL_POSITION", value);
            }
        };
        KeyboardInputCallback<Integer> amppcallback = new KeyboardInputCallback<Integer>() {
            @Override
            public void onOk(Integer value) {
                ampp.setText(String.valueOf(value));
                dataModel.set("ADDR_MX_PRESENT_POSITION", value);
            }
        };
        KeyboardInputCallback<Integer> dicallback = new KeyboardInputCallback<Integer>() {
            @Override
            public void onOk(Integer value) {
                di.setText(String.valueOf(value));
                dataModel.set("DXL_ID", value);
            }
        };
        KeyboardInputCallback<Integer> bratecallback = new KeyboardInputCallback<Integer>() {
            @Override
            public void onOk(Integer value) {
                brate.setText(String.valueOf(value));
                dataModel.set("BAUDRATE", value);
            }
        };
        KeyboardInputCallback<String> devnamecallback = new KeyboardInputCallback<String>() {
            @Override
            public void onOk(String value) {
                devname.setText(String.valueOf(value));
                dataModel.set("DEVICENAME", value);
            }
        };
        KeyboardInputCallback<Integer> maxStepscallback = new KeyboardInputCallback<Integer>() {
            @Override
            public void onOk(Integer value) {
                maxSteps.setText(String.valueOf(value));
                dataModel.set("MAX_STEPS", value);
            }
        };

        amte.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                apiProvider.getUserInterfaceAPI().getUserInteraction()
                        .getKeyboardInputFactory().createIntegerKeypadInput().show(amte, amtecallback);
            }
        });
        amgp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                apiProvider.getUserInterfaceAPI().getUserInteraction()
                        .getKeyboardInputFactory().createIntegerKeypadInput().show(amgp, amgpcallback);
            }
        });
        ampp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                apiProvider.getUserInterfaceAPI().getUserInteraction()
                        .getKeyboardInputFactory().createIntegerKeypadInput().show(ampp, amppcallback);
            }
        });
        di.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                apiProvider.getUserInterfaceAPI().getUserInteraction()
                        .getKeyboardInputFactory().createIntegerKeypadInput().show(di, dicallback);
            }
        });
        brate.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                apiProvider.getUserInterfaceAPI().getUserInteraction()
                        .getKeyboardInputFactory().createIntegerKeypadInput().show(brate, bratecallback);
            }
        });
        devname.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                apiProvider.getUserInterfaceAPI().getUserInteraction()
                        .getKeyboardInputFactory().createStringKeyboardInput().show(devname, devnamecallback);
            }
        });
        maxSteps.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                apiProvider.getUserInterfaceAPI().getUserInteraction()
                        .getKeyboardInputFactory().createIntegerKeypadInput().show(maxSteps, maxStepscallback);
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        basePanel = new JPanel();
        basePanel.setLayout(new GridBagLayout());
        amte = new JTextField();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(amte, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(spacer1, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("ADDR_MX_TORQUE_ENABLE");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("ADDR_MX_GOAL_POSITION");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("ADDR_MX_PRESENT_POSITION");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("DXL_ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("BAUDRATE");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(label5, gbc);
        amgp = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(amgp, gbc);
        ampp = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(ampp, gbc);
        di = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(di, gbc);
        brate = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(brate, gbc);
        final JLabel label6 = new JLabel();
        label6.setText("DEVICENAME");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(label6, gbc);
        devname = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(devname, gbc);
        final JLabel label7 = new JLabel();
        label7.setText("MAX_STEPS");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(label7, gbc);
        maxSteps = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(maxSteps, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return basePanel;
    }

    public JPanel getBasePanel() {
        return basePanel;
    }
}
