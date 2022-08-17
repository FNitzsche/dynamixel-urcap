package de.awesome_technologies.urcap.dynamixel;

import com.ur.urcap.api.contribution.toolbar.ToolbarContext;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputCallback;
import de.awesome_technologies.urcap.dynamixel.dynamixelSDK.ReadWrite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.sun.jna.Library;

public class DynamixelToolbar {
    private JPanel basePanel;
    private JSlider minSlider;
    private JSlider maxSlider;
    private JCheckBox movementEnabledCheckBox;
    private JTextField minField;
    private JTextField maxField;
    private JSlider targetSlider;
    private JTextField targetField;
    private JButton moveButton;

    public DynamixelToolbar(ToolbarContext context) {
        ReadWrite rw = new ReadWrite();

        movementEnabledCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (movementEnabledCheckBox.isSelected()) {
                    DataModel dataModel = context.getAPIProvider().getApplicationAPI()
                            .getInstallationNode(DynamixelInstallationContribution.class).model;
                    int sliderBorder = dataModel.get("MAX_STEPS", 4096);
                    minSlider.setMaximum(sliderBorder);
                    maxSlider.setMaximum(sliderBorder);
                    if (minSlider.getValue() > sliderBorder) {
                        minSlider.setMaximum(sliderBorder);
                    }
                    if (maxSlider.getValue() > sliderBorder) {
                        maxSlider.setValue(sliderBorder);
                    }
                    if (targetSlider.getValue() > sliderBorder) {
                        targetSlider.setValue(sliderBorder);
                    }
                    rw.setVariables(dataModel);
                    rw.openConnectionAndEnableMovement();
                } else {
                    rw.disableMovementAndCloseConnection();
                }
            }
        });
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rw.moveToPosition((short) targetSlider.getValue());
            }
        });
        minSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (minSlider.getValue() > maxSlider.getValue()) {
                    minSlider.setValue(maxSlider.getValue());
                }
                minField.setText(((Integer) minSlider.getValue()).toString());
                targetSlider.setMinimum(minSlider.getValue());
                if (targetSlider.getValue() < minSlider.getValue()) {
                    targetSlider.setValue(minSlider.getValue());
                    targetField.setText(String.valueOf(minSlider.getValue()));
                }
            }
        });
        maxSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (maxSlider.getValue() < minSlider.getValue()) {
                    maxSlider.setValue(minSlider.getValue());
                }
                maxField.setText(((Integer) maxSlider.getValue()).toString());
                targetSlider.setMaximum(maxSlider.getValue());
                if (targetSlider.getValue() > maxSlider.getValue()) {
                    targetSlider.setValue(maxSlider.getValue());
                    targetField.setText(String.valueOf(maxSlider.getValue()));
                }
            }
        });
        targetSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                targetField.setText(((Integer) targetSlider.getValue()).toString());
            }
        });
        KeyboardInputCallback<Integer> callback = new KeyboardInputCallback<Integer>() {
            @Override
            public void onOk(Integer value) {
                if (value > maxSlider.getValue()) {
                    value = maxSlider.getValue();
                }
                minField.setText(String.valueOf(value));
                minSlider.setValue(value);
                targetSlider.setMinimum(value);
                if (targetSlider.getValue() < minSlider.getValue()) {
                    targetSlider.setValue(minSlider.getValue());
                    targetField.setText(String.valueOf(minSlider.getValue()));
                }
            }
        };
        minField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                context.getAPIProvider().getUserInterfaceAPI().getUserInteraction()
                        .getKeyboardInputFactory().createIntegerKeypadInput().show(minField, callback);
            }
        });
        KeyboardInputCallback<Integer> callback2 = new KeyboardInputCallback<Integer>() {
            @Override
            public void onOk(Integer value) {
                if (value < minSlider.getValue()) {
                    value = minSlider.getValue();
                }
                maxField.setText(String.valueOf(value));
                maxSlider.setValue(value);
                targetSlider.setMaximum(maxSlider.getValue());
                if (targetSlider.getValue() > maxSlider.getValue()) {
                    targetSlider.setValue(maxSlider.getValue());
                    targetField.setText(String.valueOf(maxSlider.getValue()));
                }
            }
        };
        maxField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                context.getAPIProvider().getUserInterfaceAPI().getUserInteraction()
                        .getKeyboardInputFactory().createIntegerKeypadInput().show(maxField, callback2);
            }
        });
        KeyboardInputCallback<Integer> callback3 = new KeyboardInputCallback<Integer>() {
            @Override
            public void onOk(Integer value) {
                targetField.setText(String.valueOf(value));
                targetSlider.setValue(value);
            }
        };
        targetField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                context.getAPIProvider().getUserInterfaceAPI().getUserInteraction()
                        .getKeyboardInputFactory().createIntegerKeypadInput().show(targetField, callback3);
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
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        basePanel.add(spacer2, gbc);
        minSlider = new JSlider();
        minSlider.setMaximum(4096);
        minSlider.setPaintLabels(false);
        minSlider.setPaintTicks(false);
        minSlider.setValue(0);
        minSlider.setValueIsAdjusting(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(minSlider, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Min. Position");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Max. Position");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(label2, gbc);
        maxSlider = new JSlider();
        maxSlider.setMaximum(4096);
        maxSlider.setPaintLabels(false);
        maxSlider.setValue(4096);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(maxSlider, gbc);
        movementEnabledCheckBox = new JCheckBox();
        movementEnabledCheckBox.setText("Movement Enabled");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(movementEnabledCheckBox, gbc);
        minField = new JTextField();
        minField.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(minField, gbc);
        maxField = new JTextField();
        maxField.setText("4096");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(maxField, gbc);
        targetSlider = new JSlider();
        targetSlider.setMajorTickSpacing(1000);
        targetSlider.setMaximum(4096);
        targetSlider.setMinorTickSpacing(50);
        targetSlider.setPaintLabels(true);
        targetSlider.setPaintTicks(true);
        targetSlider.setPaintTrack(true);
        targetSlider.setSnapToTicks(false);
        targetSlider.setValue(2048);
        targetSlider.setValueIsAdjusting(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(targetSlider, gbc);
        targetField = new JTextField();
        targetField.setText("2048");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(targetField, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Target Position");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        basePanel.add(label3, gbc);
        moveButton = new JButton();
        moveButton.setText("Move");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        basePanel.add(moveButton, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 60);
        basePanel.add(spacer3, gbc);
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
