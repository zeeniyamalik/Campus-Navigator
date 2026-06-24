import javax.swing.*;
import java.awt.*;
public class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        image = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);


        super.paintComponent(g);

        int imgW = image.getWidth(null);
        int imgH = image.getHeight(null);

        if (imgW <= 0 || imgH <= 0) return;

        double scale = Math.min((double) getWidth() / imgW, (double) getHeight() / imgH);

        int newW = (int) (imgW * scale);
        int newH = (int) (imgH * scale);

        int x = (getWidth() - newW) / 2;
        int y = (getHeight() - newH) / 2;

        g.drawImage(image, x, y, newW, newH, this);
    }
}
