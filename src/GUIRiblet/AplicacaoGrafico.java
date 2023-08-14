/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRiblet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import javax.swing.JComponent;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 *
 * @author danil
 */
public class AplicacaoGrafico extends JComponent {

    private double angle;
    private double tam;
    private double altura;
    private double dr;
    private double dr0;

    private int xOffset = 20;
    private int yOffset = (int) altura / 10;

    public AplicacaoGrafico(float a, float t, float alt, float dr, float dr0) {
        this.angle = a;
        this.tam = t;
        this.altura = alt;
        this.dr = dr;
        this.dr0 = dr0;
    }

    @Override
    protected void paintComponent(Graphics g) {

        Riblet riblet = new Riblet(angle, tam, dr, dr0, altura);

        double angulo = 90 - (riblet.getAngulo() / 2);
        double metadaBaseT = Math.cos(Math.toRadians(angulo)) * riblet.getAltura();

        double inicioD = riblet.getDr0() - metadaBaseT + (xOffset * 1.5);
        double fimD = riblet.getDr0() + metadaBaseT + (xOffset * 1.5);

        int tam_a = (int) ((riblet.getTam() - riblet.getDr0() / riblet.getDr()));

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        Font f = new Font("Arial", Font.PLAIN, 12);
        g2d.setFont(f);
        g2d.drawString("Comprimento", 300, 335);

        GeneralPath linhaH = new GeneralPath();
        GeneralPath linhaComp = new GeneralPath();

        GeneralPath t_rib = new GeneralPath();

        linhaH.moveTo(25, 300);
        linhaH.lineTo(600, 300);

        linhaComp.moveTo(25, 310);
        linhaComp.lineTo(25, 330);
        linhaComp.lineTo(25, 320);
        linhaComp.lineTo(600, 320);
        linhaComp.lineTo(600, 330);
        linhaComp.lineTo(600, 310);

        int linhaBase = 300 - yOffset;

        t_rib.moveTo(xOffset / 2, linhaBase);
        t_rib.lineTo(riblet.getTam() - (xOffset / 2), linhaBase);

        for (int i = 0; i < tam_a; i++) {
            t_rib.moveTo((riblet.getDr() * i) + inicioD, linhaBase);
            t_rib.lineTo((riblet.getDr() * i) + (riblet.getDr0() + xOffset * 1.5), 300 - riblet.getAltura() - yOffset);
            t_rib.lineTo((riblet.getDr() * i) + fimD, linhaBase);
        }

        g2d.draw(linhaH);
        g2d.draw(linhaComp);
        g2d.draw(t_rib);

    }

}
