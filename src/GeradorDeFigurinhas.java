import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    /**
     * 46:59
     */
    public void Cria(InputStream inputStream, String nomeArquivo) throws Exception{
        //ler a imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));
       // InputStream inputStream = 
         //   new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
         //       .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria nova imagem com transparência e novo tamanho
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem - em memória
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.setColor(Color.YELLOW);
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar detalhes da fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);

        //escrever frase na imagem
        graphics.drawString("Rock yeah", 100, novaAltura - 100);
        
        //escrever a imagem nova em 
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }

}
