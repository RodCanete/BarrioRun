package gui;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FontLoader {
    private Font minecraftFont;
	private Font minecraftBoldFont;
	private Font hitrun;
	private Font pixelgame;

    public FontLoader() {
        try {
            minecraftFont = Font.createFont(Font.TRUETYPE_FONT, new File("data\\MinecraftRegular-Bmg3.otf"));
            minecraftBoldFont = Font.createFont(Font.TRUETYPE_FONT, new File("data\\MinecraftTen-VGORe.ttf"));
            hitrun = Font.createFont(Font.TRUETYPE_FONT, new File("data\\HitandRun-Regular.otf"));
            pixelgame = Font.createFont(Font.TRUETYPE_FONT, new File("data\\PixelGameFont.ttf"));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
    public Font hitrun() {
        return hitrun;
    }
    
    public Font getpixelgame() {
        return pixelgame;
    }
    
    public Font getMinecraftFont() {
        return minecraftFont;
    }

    public Font getminecraftBoldFont() {
        return minecraftBoldFont;
    }
}