/*
 * SK's Minecraft Launcher
 * Copyright (C) 2010-2014 Albert Pham <http://www.sk89q.com> and contributors
 * Please see LICENSE.txt for license information.
 */

package com.skcraft.launcher.dialog;

import com.skcraft.launcher.swing.ActionListeners;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class AboutDialog extends JDialog {

    public AboutDialog(Window parent) {
        super(parent, "About", ModalityType.DOCUMENT_MODAL);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        initComponents();
        setResizable(false);
        pack();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        JPanel container = new JPanel();
        container.setLayout(new MigLayout("insets dialog"));

        container.add(new JLabel("<html>Licensed under GNU General Public License, version 3."), "wrap, gapbottom unrel");
        container.add(new JLabel("<html>You are using SKCraft Launcher, an open-source customizable<br>" +
                "launcher platform that anyone can use."), "wrap, gapbottom unrel");
        container.add(new JLabel("<html>SKCraft does not necessarily endorse the version of<br>" +
                "the launcher that you are using."), "wrap, gapbottom unrel");
        container.add(new JLabel("<html>OAI Launcher Classic(Orange and Integration Launcher Classic)\u306f <br>" +
                "SKCraft Launcher\u3092\u30d9\u30fc\u30b9\u306b\u4f5c\u6210\u3055\u308c\u3066\u3044\u307e\u3059\u3002"), "wrap, gapbottom unrel");
        container.add(new JLabel("<html>Classic\u7248\u306e\u7ffb\u8a33\u4e88\u5b9a\u306f\u3042\u308a\u307e\u305b\u3093\u3002"), "wrap, gapbottom unrel");

        JButton okButton = new JButton("OK");
        JButton sourceCodeButton = new JButton("Website");

        container.add(sourceCodeButton, "span, split 3, sizegroup bttn");
        container.add(okButton, "tag ok, sizegroup bttn");

        add(container, BorderLayout.CENTER);

        getRootPane().setDefaultButton(okButton);
        getRootPane().registerKeyboardAction(ActionListeners.dispose(this), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        okButton.addActionListener(ActionListeners.dispose(this));
        sourceCodeButton.addActionListener(ActionListeners.openURL(this, "https://oocp.dip.jp/launcher"));
    }

    public static void showAboutDialog(Window parent) {
        AboutDialog dialog = new AboutDialog(parent);
        dialog.setVisible(true);
    }
}

